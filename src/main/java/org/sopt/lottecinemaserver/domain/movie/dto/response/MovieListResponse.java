package org.sopt.lottecinemaserver.domain.movie.dto.response;

import java.util.List;

public class MovieListResponse {
    private final List<MovieResponse> movieList;

    public MovieListResponse(List<MovieResponse> movieList) {
        this.movieList = movieList;
    }

    public List<MovieResponse> getMovieList() {
        return movieList;
    }
}
