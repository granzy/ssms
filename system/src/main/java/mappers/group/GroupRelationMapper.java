package mappers.group;

import java.util.List;
import java.util.Map;

/**
 * Created by gzy on 2017/1/6.
 */
public interface GroupRelationMapper {

    List<Long> findGroupIds(Map<String,Object> paramMap);

}
