package gr.ds.dsbackendproject.dao;

import gr.ds.dsbackendproject.entity.Admin;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AdminDAOImpl implements EntityDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List showALl() {
        return null;
    }

    @Override
    @Transactional
    public int addEntity(Object user) {

        Session session = entityManager.unwrap(Session.class);

        session.save(user);
        session.close();
        return 0;
    }

    @Override
    public int deleteEntityByUsername(int id) {
        return 0;
    }

    @Override
    public int updateEntity(Object user) {
        return 0;
    }

    @Override
    public Admin getEntity(String username) {
        Session session = entityManager.unwrap(Session.class);
        Query adminQ = session.createQuery("select a from Admin a where a.username= :username", Admin.class).setParameter("username", username);
        if(adminQ == null)
            return null;

        return (Admin) adminQ.getSingleResult();
    }
}
