package excercises.wisercat3.repository;

import excercises.wisercat3.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Integer> {
}
