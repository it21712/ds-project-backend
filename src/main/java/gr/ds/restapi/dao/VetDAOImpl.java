package gr.ds.restapi.dao;

import gr.ds.restapi.entity.Vet;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class VetDAOImpl implements EntityDAO<Vet> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Vet> showALl() {
        return null;
    }

    @Override
    public int addEntity(Vet user) {
        return 0;
    }

    @Override
    public int deleteEntityByUsername(int id) {
        return 0;
    }

    @Override
    public int updateEntity(Vet user) {
        return 0;
    }

    @Override
    public Vet getEntity(String username) {

        Session session = entityManager.unwrap(Session.class);

        Vet tmp = session.createQuery("SELECT v FROM Vet v WHERE v.username = :username", Vet.class).setParameter("username", username).getSingleResult();

        return tmp;
    }
}
