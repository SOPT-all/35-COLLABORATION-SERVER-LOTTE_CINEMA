package org.sopt.lottecinemaserver.domain.movie.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    private final MovieService movieService;
    public MovieController(MovieService movieService){this.movieService = movieService;}

    @GetMapping("/api/v1/movie/popular")
    ResponseEntity<ApiResponse<PopularMovieListResponse>> getPopularMovieList(@RequestParam String filter){
        //TODO filter validator
        return ResponseEntity.ok(
                ApiResponse.success(SuccessType.GET_POPULAR_MOVIE_LIST, movieService.getMoviesByFilter(filter))
        );
    }



}
