package org.sopt.lottecinemaserver.domain.movie.service;

import jakarta.transaction.Transactional;
import org.sopt.lottecinemaserver.domain.movie.dto.response.MovieListResponse;
import org.sopt.lottecinemaserver.domain.movie.dto.response.MovieResponse;
import org.sopt.lottecinemaserver.domain.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.sopt.lottecinemaserver.domain.movie.dto.response.MovieResponse.movieListToResponseList;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public MovieListResponse getMoviesByFilter(String filter) {
        return switch (filter){
            case "전체" -> get4AllMovies();
            case "상영중" -> get4ReleasedMovies();
            case "상영예정" -> get4UnreleasedMovies();
            default -> throw new IllegalStateException("Unexpected value: " + filter);
        };
    }

    public MovieListResponse getOnlyMovies() {
        //임의로 단독 영화 4개 결정
        List<Long> onlyIndex = List.of(1L,3L,5L,7L);

        List<MovieResponse> movieResponses = movieRepository.findAllById(onlyIndex)
                .stream()
                .map(movie -> new MovieResponse(
                        movie.getTitle(),
                        movie.getShowtime(),
                        movie.getRating(),
                        movie.getReleaseDate()
                ))
                .collect(Collectors.toList());
        return new MovieListResponse(movieResponses);
    }

    @Transactional
    private MovieListResponse get4AllMovies(){
        List<MovieResponse> movieResponses = movieListToResponseList(
                movieRepository.get4UnreleasedMovies(Date.valueOf(LocalDate.now()))
        );

        return new MovieListResponse(movieResponses);
    }

    @Transactional
    private MovieListResponse get4ReleasedMovies(){
        List<MovieResponse> movieResponses = movieListToResponseList(
                movieRepository.get4UnreleasedMovies(Date.valueOf(LocalDate.now()))
        );

        return new MovieListResponse(movieResponses);
    }

    @Transactional
    private MovieListResponse get4UnreleasedMovies(){
        List<MovieResponse> movieResponses = movieListToResponseList(
                movieRepository.get4UnreleasedMovies(Date.valueOf(LocalDate.now()))
        );

        return new MovieListResponse(movieResponses);
    }


}
