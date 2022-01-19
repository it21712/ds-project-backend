package gr.ds.restapi.dao;

import gr.ds.restapi.entity.Pet;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PetDAOImpl  implements EntityDAO<Pet> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Pet> showALl() {
        return null;
    }

    @Override
    public int addUser(Pet user) {
        return 0;
    }

    @Override
    public int deleteUser(int id) {
        return 0;
    }

    @Override
    @Transactional
    public int updateUser(Pet pet) {

        Session session = entityManager.unwrap(Session.class);

        int id = pet.getSerialNumber();
        Pet oldPet = session.createQuery("SELECT p FROM Pet p WHERE p.serialNumber = :id", Pet.class).setParameter("id", id).getSingleResult();

        session.evict(oldPet);

        session.update(pet);
        session.close();

        return 0;

    }

    @Override
    public Pet getUser(String username) {
        return null;
    }
}
