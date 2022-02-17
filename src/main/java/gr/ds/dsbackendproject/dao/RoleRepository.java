package gr.ds.dsbackendproject.dao;

import gr.ds.dsbackendproject.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Integer> {

    void deleteByUserId(Integer integer);
    List<Role> findByUserId(Integer integer);

}
