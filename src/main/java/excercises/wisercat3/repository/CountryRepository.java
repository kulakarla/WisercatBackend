package excercises.wisercat3.repository;

import excercises.wisercat3.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
