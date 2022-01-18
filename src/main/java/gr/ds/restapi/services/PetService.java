package gr.ds.restapi.services;

import gr.ds.restapi.dao.PetRepository;
import gr.ds.restapi.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService implements IPetService {

    @Autowired
    PetRepository petRepository;

    @Override
    public List<Pet> getPetsByCitizenName(String username) {

        List<Pet> pets  = petRepository.getPetsByCitizenName(username);
        return pets;
    }

    @Override
    public List<Pet> getPendingPetsByCitizenName(String username) {

        List<Pet> pets  = petRepository.getPendingPetsByCitizenName(username);
        return pets;
    }

    @Override
    public List<Pet> getPetsByRegion(String region) {
        List<Pet> pets = petRepository.getPetsByRegion(region);
        return pets;
    }
}
