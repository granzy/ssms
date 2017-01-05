package mappers.user;

import domain.user.UserOrganizationJob;

import java.util.List;

/**
 * \* User: gzy
 * \* Date: 2017/1/4
 * \* Time: 15:22
 * \* Description:
 * \
 */
public interface UserOrganizationJobMapper {

    List<UserOrganizationJob> findByUserId(Long userId);

}
