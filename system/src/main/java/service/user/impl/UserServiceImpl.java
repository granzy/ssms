package service.user.impl;

import domain.user.User;
import mappers.user.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
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

    @Override
    public User findByUsername(String username) {
        if(StringUtils.isEmpty(username)) {
            return null;
        }
        return userMapper.findByUsername(username);
    }
}
