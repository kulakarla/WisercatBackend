package excercises.wisercat3.repository;

import excercises.wisercat3.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    boolean existsByName(String animal);
}
