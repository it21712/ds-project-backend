package gr.ds.restapi.dao;

import gr.ds.restapi.entity.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements  EntityDAO<User> {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    CitizenDAOImpl citizenDAO;

    @Override
    public List<User> showALl() {
        return null;
    }

    @Override
    public int addEntity(User entity) {
        Session session = entityManager.unwrap(Session.class);

        session.save(entity);
        session.close();

        return 0;
    }

    @Override
    public int deleteEntityByUsername(int id) {
        return 0;
    }

    @Override
    public int updateEntity(User entity) {
        return 0;
    }

    @Override
    public User getEntity(String username) {
        return null;
    }
}
