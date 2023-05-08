package excercises.wisercat3.mapper;

import excercises.wisercat3.dto.PetDTO;
import excercises.wisercat3.model.Pet;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PetDTOMapper implements Function<Pet, PetDTO> {

    @Override
    public PetDTO apply(Pet pet) {
        return new PetDTO(
                pet.getId(),
                pet.getIdCode(),
                pet.getName(),
                pet.getAnimal(),
                pet.getColor(),
                pet.getCountry());
    }
}
