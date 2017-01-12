package mappers.resource;


import domain.resource.Resource;

import java.util.List;

/**
 * \* User: gzy
 * \* Date: 2017/1/9
 * \* Time: 14:46
 * \* Description:
 * \
 */
public interface ResourceMapper {

    public Resource findOne(Long id);

    public List<Resource> findAll();

}
