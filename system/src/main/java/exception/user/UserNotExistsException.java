package exception.user;

/**
 * \* User: gzy
 * \* Date: 2017/1/10
 * \* Time: 14:25
 * \* Description:
 * \
 */
public class UserNotExistsException extends UserException {

    public UserNotExistsException() {
        super("user.not.exists", null);
    }
}
