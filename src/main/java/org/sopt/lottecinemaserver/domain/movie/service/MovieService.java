package org.sopt.lottecinemaserver.domain.movie.service;

import jakarta.transaction.Transactional;
import org.sopt.lottecinemaserver.domain.movie.dto.response.PopularMovieListResponse;
import org.sopt.lottecinemaserver.domain.movie.dto.response.PopularMovieResponse;
import org.sopt.lottecinemaserver.domain.movie.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Transactional(readOnly = true)
    public PopularMovieListResponse getMoviesByFilter(String filter) {
        List<PopularMovieResponse> movieResponses = movieRepository.findAll().stream()
                .map(movie -> new PopularMovieResponse(
                        movie.getTitle(),
                        movie.getShowtime(),
                        movie.getRating(),
                        movie.getReleaseDate()
                        ))
                .collect(Collectors.toList());

        return new PopularMovieListResponse(movieResponses);
    }
}
