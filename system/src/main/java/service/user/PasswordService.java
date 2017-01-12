package service.user;

import domain.user.User;

/**
 * \* User: gzy
 * \* Date: 2017/1/10
 * \* Time: 15:42
 * \* Description:
 * \
 */
public interface PasswordService {

    public void validate(User user, String password);

}
