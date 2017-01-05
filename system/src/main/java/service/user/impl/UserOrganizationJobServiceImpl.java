package service.user.impl;

import domain.user.UserOrganizationJob;
import mappers.user.UserOrganizationJobMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import service.user.UserOrganizationJobService;

import javax.annotation.Resource;
import java.util.List;

/**
 * \* User: gzy
 * \* Date: 2017/1/4
 * \* Time: 11:45
 * \* Description:
 * \
 */
@Service("userOrganizationJobService")
public class UserOrganizationJobServiceImpl implements UserOrganizationJobService {


    @Resource
    private UserOrganizationJobMapper userOrganizationJobMapper;

    @Override
    public List<UserOrganizationJob> findByUserId(Long userId) {
        if(StringUtils.isEmpty(userId)) {
            return null;
        }
        return userOrganizationJobMapper.findByUserId(userId);
    }
}
