package exception.user;

/**
 * \* User: gzy
 * \* Date: 2017/1/10
 * \* Time: 14:54
 * \* Description:
 * \
 */
public class UserPasswordNotMatchException extends UserException {

    public UserPasswordNotMatchException() {
        super("user.password.not.match", null);
    }

}
