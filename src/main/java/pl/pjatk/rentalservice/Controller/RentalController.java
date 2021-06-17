package pl.pjatk.rentalservice.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.rentalservice.Model.Movie;
import pl.pjatk.rentalservice.Service.RestService;

@RestController
@RequestMapping("/movie")
public class RentalController {

    private final RestService restService;

    public RentalController(RestService restService) {
        this.restService = restService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id){
        return ResponseEntity.ok(restService.getMovie(id));
    }

    @PutMapping("/return/{id}")
    public void changeAvailable(@PathVariable Long id) {
        restService.returnMovie(id);
    }




}
