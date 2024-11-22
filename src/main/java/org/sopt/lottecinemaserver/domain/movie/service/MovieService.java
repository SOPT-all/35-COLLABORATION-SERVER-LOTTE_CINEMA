package org.sopt.lottecinemaserver.domain.movie.service;

import jakarta.transaction.Transactional;
import org.sopt.lottecinemaserver.domain.movie.dto.response.PopularMovieListResponse;
import org.sopt.lottecinemaserver.domain.movie.dto.response.PopularMovieResponse;
import org.sopt.lottecinemaserver.domain.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Transactional
    public PopularMovieListResponse getMoviesByFilter(String filter) {
        return switch (filter){
            case "전체" -> get4AllMovies();
            case "상영중" -> get4ReleasedMovies();
            case "상영예정" -> get4UnreleasedMovies();
            default -> throw new IllegalStateException("Unexpected value: " + filter);
        };
    }

    @Transactional
    private PopularMovieListResponse get4AllMovies(){
        List<PopularMovieResponse> movieResponses = movieRepository.get4AllMovies()
                .stream()
                .map(movie -> new PopularMovieResponse(
                        movie.getTitle(),
                        movie.getShowtime(),
                        movie.getRating(),
                        movie.getReleaseDate()
                ))
                .collect(Collectors.toList());

        return new PopularMovieListResponse(movieResponses);
    }

    @Transactional
    private PopularMovieListResponse get4ReleasedMovies(){
        List<PopularMovieResponse> movieResponses = movieRepository.get4ReleasedMovies(Date.valueOf(LocalDate.now()))
                .stream()
                .map(movie -> new PopularMovieResponse(
                        movie.getTitle(),
                        movie.getShowtime(),
                        movie.getRating(),
                        movie.getReleaseDate()
                ))
                .collect(Collectors.toList());

        return new PopularMovieListResponse(movieResponses);
    }

    @Transactional
    private PopularMovieListResponse get4UnreleasedMovies(){
        List<PopularMovieResponse> movieResponses = movieRepository.get4UnreleasedMovies(Date.valueOf(LocalDate.now()))
                .stream()
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
