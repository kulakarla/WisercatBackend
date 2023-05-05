package excercises.wisercat3.repository;

import excercises.wisercat3.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetsRepository extends JpaRepository<Pet, Integer> {
}
