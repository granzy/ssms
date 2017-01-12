package exception.user;

/**
 * \* User: gzy
 * \* Date: 2017/1/10
 * \* Time: 15:52
 * \* Description:
 * \
 */
public class UserPasswordRetryLimitExceedException extends UserException {

    public UserPasswordRetryLimitExceedException(int retryLimitCount) {
        super("user.password.retry.limit.exceed", new Object[]{retryLimitCount});
    }

}
