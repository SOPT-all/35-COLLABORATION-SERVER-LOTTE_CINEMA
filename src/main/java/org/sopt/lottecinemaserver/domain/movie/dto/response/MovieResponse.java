package org.sopt.lottecinemaserver.domain.movie.dto.response;

import org.sopt.lottecinemaserver.domain.movie.entity.Movie;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MovieResponse {
    private final String title;
    private final int showtime;
    private final String rating;
    private final Date released_date;

    public MovieResponse(String title, int showtime, String rating, Date released_date){
        this.title = title;
        this.showtime = showtime;
        this.rating = rating;
        this.released_date = released_date;
    }

    public static List<MovieResponse> movieListToResponseList(List<Movie> movieList){
        return movieList.stream()
                .limit(4)
                .map(movie -> new MovieResponse(
                        movie.getTitle(),
                        movie.getShowtime(),
                        movie.getRating(),
                        movie.getReleaseDate()
                ))
                .collect(Collectors.toList());
    }

    public String getTitle() {
        return title;
    }
    public int getShowtime() {
        return showtime;
    }
    public String getRating() {
        return rating;
    }
    public Date getReleased_date() {
        return released_date;
    }
}
