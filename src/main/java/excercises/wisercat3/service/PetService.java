package excercises.wisercat3.service;

import excercises.wisercat3.dto.PetDTO;
import excercises.wisercat3.mapper.PetDTOMapper;
import excercises.wisercat3.repository.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {

    private final PetsRepository petsRepository;

    private final PetDTOMapper petDTOMapper;

    @Autowired
    public PetService(PetsRepository petsRepository, PetDTOMapper petDTOMapper){
        this.petsRepository = petsRepository;
        this.petDTOMapper = petDTOMapper;
    }

    public List<PetDTO> getPets(){
        return petsRepository.findAll()
                .stream()
                .map(petDTOMapper)
                .collect(Collectors.toList());
    }



}
