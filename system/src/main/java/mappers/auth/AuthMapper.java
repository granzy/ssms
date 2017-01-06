package mappers.auth;

import java.util.List;
import java.util.Map;

/**
 * Created by gzy on 2017/1/6.
 */
public interface AuthMapper {

    public List<Long> findRoleIds(Map<String,Object> paramsMap);

}
