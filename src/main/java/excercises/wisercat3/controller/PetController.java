package excercises.wisercat3.controller;

import excercises.wisercat3.dto.PetDTO;
import excercises.wisercat3.model.Pet;
import excercises.wisercat3.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/pet")
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService){
        this.petService = petService;
    }


    @GetMapping
    public ResponseEntity<List<PetDTO>> getPets(){
        List<PetDTO> pets = petService.getPets();
        if (pets.size() == 0){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(pets);
        }
    }


    //TODO
    //User specific pet fetching with request header
    @GetMapping("/{userName}")
    public ResponseEntity<List<PetDTO>> getUserPets(@PathVariable(name = "userName") String userName){

        try {
            List<PetDTO> pets = petService.getPetsUser(userName);

            return ResponseEntity.ok(pets);

        }catch (UsernameNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User not found", e
            );
        }
    }
}
