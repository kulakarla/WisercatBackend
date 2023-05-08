package excercises.wisercat3.controller;

import excercises.wisercat3.dto.PetDTO;
import excercises.wisercat3.model.Animal;
import excercises.wisercat3.model.Color;
import excercises.wisercat3.model.Country;
import excercises.wisercat3.service.OptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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


    @Operation(summary = "Fetching animals from database")
    @ApiResponse(responseCode = "200", description = "Animals successfully fetched",
    content = {@Content(mediaType = "application/json", array = @ArraySchema(
            schema = @Schema(implementation = Animal.class)
    ))})
    @GetMapping("/animal")
    public ResponseEntity<List<Animal>> getAnimals(){
        return ResponseEntity.ok(optionService.getAnimals());

    }
    @Operation(summary = "Fetching colors from database")
    @ApiResponse(responseCode = "200", description = "Colors successfully fetched",
            content = {@Content(mediaType = "application/json", array = @ArraySchema(
                    schema = @Schema(implementation = Color.class)
            ))})
    @GetMapping("/color")
    public ResponseEntity<List<Color>> getColors(){
        return ResponseEntity.ok(optionService.getColors());
    }


    @Operation(summary = "Fetching countries from database")
    @ApiResponse(responseCode = "200", description = "Countries successfully fetched",
            content = {@Content(mediaType = "application/json", array = @ArraySchema(
                    schema = @Schema(implementation = Country.class)
            ))})
    @GetMapping("/country")
    public ResponseEntity<List<Country>> getCountries(){
        return ResponseEntity.ok(optionService.getCountries());
    }
}
