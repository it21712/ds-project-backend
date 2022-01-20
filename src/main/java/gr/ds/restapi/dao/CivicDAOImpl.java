package gr.ds.restapi.dao;

import gr.ds.restapi.entity.CivicOfficial;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CivicDAOImpl implements EntityDAO<CivicOfficial> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<CivicOfficial> showALl() {
        return null;
    }

    @Override
    public int addEntity(CivicOfficial user) {
        return 0;
    }

    @Override
    public int deleteEntityByUsername(int id) {
        return 0;
    }

    @Override
    public int updateEntity(CivicOfficial user) {
        return 0;
    }

    @Override
    @Transactional
    public CivicOfficial getEntity(String username) {

        Session session = entityManager.unwrap(Session.class);

        CivicOfficial tmp = session.createQuery("SELECT c FROM CivicOfficial c WHERE c.username = :username", CivicOfficial.class).setParameter("username", username).getSingleResult();
        CivicOfficial civic = new CivicOfficial(tmp.getFullName(), tmp.getRegion());

        return tmp;
    }
}
