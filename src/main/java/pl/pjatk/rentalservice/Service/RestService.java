package pl.pjatk.rentalservice.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.rentalservice.Model.Movie;

@Service
public class RestService {

    private final RestTemplate restTemplate;

    public RestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie getMovie(Long id){
       Movie forEntity = restTemplate.getForEntity("http://localhost:8080/movie/" + id, Movie.class).getBody();
       return forEntity;
    }

    public void returnMovie(Long id){
      restTemplate.put("http://localhost:8080/movie/changeAvailbility/" + id, null);

    }


}
