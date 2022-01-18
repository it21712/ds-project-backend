package gr.ds.restapi.dao;


import gr.ds.restapi.entity.User;


import java.util.List;

public interface UserDAO<UserType extends User> {

    List<UserType> showALl();

    int addUser(UserType user);

    int deleteUser(int id);

    int updateUser(UserType user);

    UserType getUser(String username);

}
