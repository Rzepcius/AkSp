package com.example.aksp.bonus.hateoas.validation;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author andrzej.rzepecki
 **/

@RestController
@RequestMapping("/api/movies")
public class MovieApi {

    List<Movie> movieList;

    public MovieApi(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @GetMapping
    public List<Movie> getMovies(){
        return movieList;
    }

    @PostMapping
    public boolean addMovie(@Valid @RequestBody Movie movie){
        return movieList.add(movie);
    }
}
