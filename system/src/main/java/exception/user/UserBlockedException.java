package exception.user;

/**
 * \* User: gzy
 * \* Date: 2017/1/10
 * \* Time: 16:30
 * \* Description:
 * \
 */
public class UserBlockedException extends UserException {

    public UserBlockedException(String reason) {
        super("user.blocked", new Object[]{reason});
    }

}
