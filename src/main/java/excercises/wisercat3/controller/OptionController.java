package excercises.wisercat3.controller;

import excercises.wisercat3.dto.PetDTO;
import excercises.wisercat3.model.Animal;
import excercises.wisercat3.model.Color;
import excercises.wisercat3.model.Country;
import excercises.wisercat3.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/option")
public class OptionController {

    @Autowired
    private final OptionService optionService;

    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @GetMapping("/animal")
    public ResponseEntity<List<Animal>> getAnimals(){
        return ResponseEntity.ok(optionService.getAnimals());

    }

    @GetMapping("/color")
    public ResponseEntity<List<Color>> getColors(){
        return ResponseEntity.ok(optionService.getColors());
    }

    @GetMapping("/country")
    public ResponseEntity<List<Country>> getCountries(){
        return ResponseEntity.ok(optionService.getCountries());
    }
}
