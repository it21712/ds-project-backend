package gr.ds.restapi.dao;

import gr.ds.restapi.entity.Citizen;

import org.hibernate.Session;
import org.hibernate.query.Query;



import org.springframework.stereotype.Repository;


import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class CitizenDAOImpl implements UserDAO<Citizen>{

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    @Transactional
    public List<Citizen> showALl() {
        Session session = entityManager.unwrap(Session.class);

        Query<Citizen> citizenQuery = session.createQuery("SELECT c FROM Citizen c", Citizen.class);

        session.close();

        List<Citizen> citizens = citizenQuery.getResultList();

        return citizens;
    }

    @Override
    @Transactional
    public int addUser(Citizen citizen) {

        Session session = entityManager.unwrap(Session.class);

        session.save(citizen);
        session.close();

        return 0;
    }

    @Override
    @Transactional
    public int deleteUser(int id) {

        Session session = entityManager.unwrap(Session.class);

        Citizen citizen = session.createQuery("SELECT c FROM Citizen c WHERE c.id = :id", Citizen.class).setParameter("id", id).getSingleResult();

        session.remove(citizen);
        return 0;
    }

    @Override
    @Transactional
    public int updateUser(Citizen citizen) {

        Session session = entityManager.unwrap(Session.class);

        int id = citizen.getId();
        Citizen oldCitizen = session.createQuery("SELECT c FROM Citizen c WHERE c.id = :id", Citizen.class).setParameter("id", id).getSingleResult();

        session.evict(oldCitizen);

        session.update(citizen);



        return 0;
    }


}
