package excercises.wisercat3.repository;

import excercises.wisercat3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
