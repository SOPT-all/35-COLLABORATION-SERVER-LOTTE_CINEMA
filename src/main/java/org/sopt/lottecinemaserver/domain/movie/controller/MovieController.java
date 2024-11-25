package org.sopt.lottecinemaserver.domain.movie.controller;

import org.sopt.lottecinemaserver.domain.movie.dto.response.MovieListResponse;
import org.sopt.lottecinemaserver.domain.movie.service.MovieService;
import org.sopt.lottecinemaserver.global.common.ApiResponse;
import org.sopt.lottecinemaserver.global.common.SuccessType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
    private final MovieService movieService;
    public MovieController(MovieService movieService){this.movieService = movieService;}

    @GetMapping("/popular")
    ResponseEntity<ApiResponse<MovieListResponse>> getPopularMovieList(@RequestParam String filter){
        //TODO filter validator
        return ResponseEntity.ok(
                ApiResponse.success(SuccessType.GET_POPULAR_MOVIE_LIST, movieService.getMoviesByFilter(filter))
        );
    }

    @GetMapping("/only")
    ResponseEntity<ApiResponse<MovieListResponse>> getOnlyMovieList(){
        //TODO filter validator
        return ResponseEntity.ok(
                ApiResponse.success(SuccessType.GET_ONLY_MOVIE_LIST, movieService.getOnlyMovies())
        );
    }



}
