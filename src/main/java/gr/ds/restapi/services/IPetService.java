package gr.ds.restapi.services;

import gr.ds.restapi.entity.Pet;

import java.util.List;

public interface IPetService {

    List<Pet> getPetsByCitizenName(String username);
    List<Pet> getPendingPetsByCitizenName(String username);
    List<Pet> getPetsByRegion(String region);
}
