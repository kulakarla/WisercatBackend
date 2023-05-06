package excercises.wisercat3.service;

import excercises.wisercat3.model.Animal;
import excercises.wisercat3.model.Color;
import excercises.wisercat3.model.Country;
import excercises.wisercat3.repository.AnimalRepository;
import excercises.wisercat3.repository.ColorRepository;
import excercises.wisercat3.repository.CountryRepository;
import excercises.wisercat3.repository.PetsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {

    private final AnimalRepository animalRepository;

    private final ColorRepository colorRepository;

    private final CountryRepository countryRepository;


    public OptionService(AnimalRepository animalRepository, ColorRepository colorRepository, CountryRepository countryRepository) {
        this.animalRepository = animalRepository;
        this.colorRepository = colorRepository;
        this.countryRepository = countryRepository;
    }

    public List<Animal> getAnimals(){
        return animalRepository.findAll();
    }

    public List<Color> getColors(){
        return colorRepository.findAll();
    }

    public List<Country> getCountries(){
        return countryRepository.findAll();
    }
}
