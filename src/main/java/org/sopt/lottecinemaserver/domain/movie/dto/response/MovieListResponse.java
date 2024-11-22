package org.sopt.lottecinemaserver.domain.movie.dto.response;

import java.util.List;

public class PopularMovieListResponse {
    private final List<PopularMovieResponse> movieList;

    public PopularMovieListResponse(List<PopularMovieResponse> movieList) {
        this.movieList = movieList;
    }

    public List<PopularMovieResponse> getPopularMovieList() {
        return movieList;
    }
}
