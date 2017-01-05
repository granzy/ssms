package service.user;

import domain.user.UserOrganizationJob;

import java.util.List;

/**
 * Created by gzy on 2017/1/4.
 */
public interface UserOrganizationJobService {

    List<UserOrganizationJob> findByUserId(Long userId);

}
