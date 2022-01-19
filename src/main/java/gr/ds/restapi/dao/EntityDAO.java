package gr.ds.restapi.dao;


import javax.transaction.Transactional;
import java.util.List;

public interface EntityDAO<EntityType> {

    List<EntityType> showALl();

    int addUser(EntityType user);

    @Transactional
    int deleteUser(int id);

    @Transactional
    int updateUser(EntityType user);

    EntityType getUser(String username);

}
