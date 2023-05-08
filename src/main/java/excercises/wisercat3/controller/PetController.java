package excercises.wisercat3.controller;

import excercises.wisercat3.dto.PetDTO;
import excercises.wisercat3.exception.PetSystemException;
import excercises.wisercat3.model.Pet;
import excercises.wisercat3.service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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


    @Operation(summary = "Get all pets from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "No pets found",
            content = @Content),
            @ApiResponse(responseCode = "200", description = "Pets successfully fetched",
            content = {@Content(mediaType = "application/json", array = @ArraySchema(
                schema = @Schema(implementation = PetDTO.class)
            ))})
    })
    @GetMapping
    public ResponseEntity<List<PetDTO>> getPets(){
        List<PetDTO> pets = petService.getPets();

        if(pets.size() == 0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(pets, HttpStatus.OK);
        }
    }


    @Operation(summary = "Get users pets")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User pets successfully fetched",
            content = {@Content(mediaType = "application/json", array = @ArraySchema(
                    schema = @Schema(implementation = PetDTO.class)
            ))}),
            @ApiResponse(responseCode = "404", description = "User not found",
            content = @Content)
    })
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

    @Operation(summary = "Add an users new pet to database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pet successfully added",
            content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = PetDTO.class))}),
            @ApiResponse(responseCode = "404", description = "User not found",
            content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid values for adding a new pet",
            content = @Content)
    })
    @PostMapping("/{userName}/add")
    public ResponseEntity<PetDTO> addPet(@RequestBody PetDTO pet, @PathVariable(name = "userName") String userName){
        try {
            petService.addUserPet(pet, userName);
            return new ResponseEntity<>(pet, HttpStatus.CREATED);
        }catch(UsernameNotFoundException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User not found", e
            );
        }catch(PetSystemException p) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Pet with this id code already exists", p
            );
        }

    }

    @Operation(summary = "Editing an users pet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pet successfully updated",
            content = {@Content(mediaType = "application/json",
            schema = @Schema(implementation = PetDTO.class))}),
            @ApiResponse(responseCode = "404", description = "User not found",
            content = @Content),
            @ApiResponse(responseCode = "400", description = "Pet edit not allowed",
            content = @Content)
    })
    @PutMapping("/{userName}/edit")
    public ResponseEntity<PetDTO> editPet(@RequestBody PetDTO pet, @PathVariable(name = "userName") String userName){
        try {
            petService.editUserPet(pet, userName);
            return new ResponseEntity<>(pet, HttpStatus.OK);
        }catch(UsernameNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User not found", e
            );
        }catch(PetSystemException p){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Pet information is incorrect", p
            );
        }
    }
}
