package excercises.wisercat3.repository;

import excercises.wisercat3.model.Pet;
import excercises.wisercat3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetsRepository extends JpaRepository<Pet, Integer> {

    List<Pet> findByUser(User user);
    boolean existsByIdCode(String idCode);

    boolean existsByAnimal(String animal);
    boolean existsByCountry(String country);
}
