package excercises.wisercat3.service;

import excercises.wisercat3.dto.PetDTO;
import excercises.wisercat3.mapper.PetDTOMapper;
import excercises.wisercat3.model.User;
import excercises.wisercat3.repository.PetsRepository;
import excercises.wisercat3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetService {

    private final PetsRepository petsRepository;

    private final UserRepository userRepository;

    private final PetDTOMapper petDTOMapper;

    @Autowired
    public PetService(PetsRepository petsRepository, UserRepository userRepository, PetDTOMapper petDTOMapper){
        this.petsRepository = petsRepository;
        this.userRepository = userRepository;
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



}
