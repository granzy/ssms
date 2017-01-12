package service.user;

import domain.user.User;

/**
 * Created by gzy on 2017/1/4.
 */
public interface UserService {

    public User findByUsername(String username);

    public User login(String username, String password);

}
