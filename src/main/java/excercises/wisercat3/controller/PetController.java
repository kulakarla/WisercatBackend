package excercises.wisercat3.controller;

import excercises.wisercat3.dto.PetDTO;
import excercises.wisercat3.model.Pet;
import excercises.wisercat3.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pet")
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService){
        this.petService = petService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
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
    @GetMapping("/user")
    public ResponseEntity<String> getUserPets(@RequestHeader("X-Content-For") String userName){
        return ResponseEntity.ok(userName);
    }
}
