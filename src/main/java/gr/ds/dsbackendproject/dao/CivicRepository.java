package gr.ds.dsbackendproject.dao;

import gr.ds.dsbackendproject.entity.CivicOfficial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CivicRepository  extends JpaRepository<CivicOfficial, Integer> {

    CivicOfficial getCivicOfficialByCode(Integer code);

}
