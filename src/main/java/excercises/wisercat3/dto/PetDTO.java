package excercises.wisercat3.dto;


import excercises.wisercat3.model.User;
import excercises.wisercat3.model.Pet;
import jakarta.persistence.*;

import java.util.UUID;

public record PetDTO (

        Integer id,

        UUID id_code,

        String name,

        String animal,

        String color,

        String country


){

}
