package excercises.wisercat3.service;

import excercises.wisercat3.model.Pet;
import excercises.wisercat3.repository.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PetService {

    private final PetsRepository petsRepository;

    @Autowired
    public PetService(PetsRepository petsRepository){
        this.petsRepository = petsRepository;
    }

    public List<Pet> getPets(){
        return petsRepository.findAll();
    }



}
