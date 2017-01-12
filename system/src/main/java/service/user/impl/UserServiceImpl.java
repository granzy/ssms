package service.user.impl;

import base.util.UserLogUtils;
import domain.user.User;
import domain.user.UserStatus;
import domain.user.UserStatusHistory;
import exception.user.UserBlockedException;
import exception.user.UserNotExistsException;
import exception.user.UserPasswordNotMatchException;
import mappers.user.UserMapper;
import mappers.user.UserStatusHistoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import service.user.PasswordService;
import service.user.UserService;

import javax.annotation.Resource;

/**
 * \* User: gzy
 * \* Date: 2017/1/4
 * \* Time: 11:45
 * \* Description:
 * \
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserStatusHistoryMapper userStatusHistoryMapper;

    @Resource
    private PasswordService passwordService;

    @Override
    public User findByUsername(String username) {
        if(StringUtils.isEmpty(username)) {
            return null;
        }
        return userMapper.findByUsername(username);
    }

    private boolean maybeUsername(String username) {
        if (!username.matches(User.USERNAME_PATTERN)) {
            return false;
        }
        //如果用户名不在指定范围内也是错误的
        if (username.length() < User.USERNAME_MIN_LENGTH || username.length() > User.USERNAME_MAX_LENGTH) {
            return false;
        }

        return true;
    }

    private boolean maybeEmail(String username) {
        if (!username.matches(User.EMAIL_PATTERN)) {
            return false;
        }
        return true;
    }

    private boolean maybeMobilePhoneNumber(String username) {
        if (!username.matches(User.MOBILE_PHONE_NUMBER_PATTERN)) {
            return false;
        }
        return true;
    }

    @Override
    public User login(String username, String password) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            UserLogUtils.log(
                    username,
                    "loginError",
                    "username is empty");
            throw new UserNotExistsException();
        }

        //密码如果不在指定范围内 肯定错误
        if (password.length() < User.PASSWORD_MIN_LENGTH || password.length() > User.PASSWORD_MAX_LENGTH) {
            UserLogUtils.log(
                    username,
                    "loginError",
                    "password length error! password is between {} and {}",
                    User.PASSWORD_MIN_LENGTH, User.PASSWORD_MAX_LENGTH);

            throw new UserPasswordNotMatchException();
        }

        User user = null;

        if (maybeUsername(username)) {
            user = userMapper.findByUsername(username);
        }

        if (user == null && maybeEmail(username)) {
            user = userMapper.findByEmail(username);
        }

        if (user == null && maybeMobilePhoneNumber(username)) {
            user = userMapper.findByMobilePhoneNumber(username);
        }

        if (user == null || Boolean.TRUE.equals(user.getDeleted())) {
            UserLogUtils.log(
                    username,
                    "loginError",
                    "user is not exists!");

            throw new UserNotExistsException();
        }
        passwordService.validate(user, password);

        if (user.getStatus() == UserStatus.blocked) {
            UserLogUtils.log(
                    username,
                    "loginError",
                    "user is blocked!");
            UserStatusHistory userStatusHistory = userStatusHistoryMapper.getLast(user.getId());
            if(userStatusHistory!=null){
                throw new UserBlockedException(userStatusHistory.getReason());
            }

        }

        UserLogUtils.log(
                username,
                "loginSuccess",
                "");
        return user;
    }
}
