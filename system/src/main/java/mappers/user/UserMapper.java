package mappers.user;

import domain.user.User;

/**
 * \* User: gzy
 * \* Date: 2017/1/3
 * \* Time: 17:23
 * \* Description:
 * \
 */
public interface UserMapper {

    User findByUsername(String userName);

    User findByEmail(String email);

    User findByMobilePhoneNumber(String mobilePhoneNumber);
}
