package mappers.user;

import domain.user.User;
import domain.user.UserStatusHistory;

/**
 * \* User: gzy
 * \* Date: 2017/1/3
 * \* Time: 17:23
 * \* Description:
 * \
 */
public interface UserStatusHistoryMapper {

    public UserStatusHistory getLast(Long userId);

}
