package excercises.wisercat3.repository;

import excercises.wisercat3.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Integer, Animal> {
}
