package exception.user;

import exception.base.BaseException;

/**
 * \* User: gzy
 * \* Date: 2017/1/10
 * \* Time: 11:16
 * \* Description:
 * \
 */
public class UserException extends BaseException {

    public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }

}
