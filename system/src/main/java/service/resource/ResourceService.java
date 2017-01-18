package service.resource;

import domain.resource.Menu;
import domain.resource.Resource;
import domain.user.User;

import java.util.List;

/**
 * \* User: gzy
 * \* Date: 2017/1/9
 * \* Time: 15:07
 * \* Description:
 * \
 */
public interface ResourceService {

    public String findActualResourceIdentity(Resource resource);

    public List<Menu> findMenus(User user);

}
