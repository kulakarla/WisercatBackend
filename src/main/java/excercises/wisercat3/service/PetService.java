package excercises.wisercat3.service;

import excercises.wisercat3.dto.PetDTO;
import excercises.wisercat3.exception.PetSystemException;
import excercises.wisercat3.mapper.PetDTOMapper;
import excercises.wisercat3.model.Pet;
import excercises.wisercat3.model.User;
import excercises.wisercat3.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PetService {

    private final PetsRepository petsRepository;

    private final UserRepository userRepository;

    private final ColorRepository colorRepository;

    private final CountryRepository countryRepository;

    private final AnimalRepository animalRepository;

    private final PetDTOMapper petDTOMapper;

    @Autowired
    public PetService(PetsRepository petsRepository, UserRepository userRepository, ColorRepository colorRepository, CountryRepository countryRepository, AnimalRepository animalRepository, PetDTOMapper petDTOMapper){
        this.petsRepository = petsRepository;
        this.userRepository = userRepository;
        this.colorRepository = colorRepository;
        this.countryRepository = countryRepository;
        this.animalRepository = animalRepository;
        this.petDTOMapper = petDTOMapper;
    }

    public List<PetDTO> getPets(){
        return petsRepository.findAll()
                .stream()
                .map(petDTOMapper)
                .collect(Collectors.toList());
    }


    public List<PetDTO> getPetsUser(String userName){

        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + userName));

        return petsRepository.findByUser(user)
                .stream()
                .map(petDTOMapper)
                .collect(Collectors.toList());

    }


    public void addUserPet(PetDTO pet, String userName) {
        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username:" + userName));

        if(!verifyPetDetails(pet) || petsRepository.existsByIdCode(pet.idCode())){
            throw new PetSystemException("Pet details are incorrect");
        }


        petsRepository.save(new Pet(
                null,
                pet.idCode(),
                pet.name(),
                pet.animal(),
                pet.color(),
                pet.country(),
                user

        ));

    }

    private boolean verifyPetDetails(PetDTO pet) {
        return colorRepository.existsByName(pet.color()) &&
                animalRepository.existsByName(pet.animal()) &&
                countryRepository.existsByName(pet.country()) &&
                pet.idCode().length() == 8 &&
                pet.name().length() > 0 &&
                pet.idCode().matches("[0-9]{8}");
    }

    public void editUserPet(PetDTO pet, String userName) {
        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username:" + userName));

        if(!verifyPetDetails(pet)){
            throw new PetSystemException("Pet details are incorrect");
        }

        if(petsRepository.existsByIdCode(pet.idCode())){
            if(!petIdCodeExistsIsEditPet(pet)){
                throw new PetSystemException("Pet ID already taken");
            }
        }

        Pet petToUpdate = petsRepository.findById(pet.id())
                .orElseThrow(() -> new PetSystemException("Pet you are trying to update doesn't exist"));


        petToUpdate.setName(pet.name());
        petToUpdate.setColor(pet.color());
        petToUpdate.setIdCode(pet.idCode());
        petToUpdate.setAnimal(pet.animal());
        petToUpdate.setCountry(pet.country());

        petsRepository.save(petToUpdate);


    }

    private boolean petIdCodeExistsIsEditPet(PetDTO petDTO) {
        Pet pet = petsRepository.findPetByIdCode(petDTO.idCode());

        return Objects.equals(pet.getId(), petDTO.id());
    }

}

