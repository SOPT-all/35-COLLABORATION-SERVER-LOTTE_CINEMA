package org.sopt.lottecinemaserver.domain.movie.dto.response;

import org.sopt.lottecinemaserver.domain.movie.entity.Movie;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MovieResponse {
    private final String title;
    private final int showtime;
    private final String rating;
    private final Date releasedDate;
    private final String imageUrl;
    private final String reservedRate;

    public MovieResponse(String title, int showtime, String rating, Date releasedDate, String imageUrl, String reservedRate){
        this.title = title;
        this.showtime = showtime;
        this.rating = rating;
        this.releasedDate = releasedDate;
        this.imageUrl = imageUrl;
        this.reservedRate = reservedRate;
    }

    public static List<MovieResponse> movieListToResponseList(List<Movie> movieList){
        return movieList.stream()
                .limit(4)
                .map(movie -> new MovieResponse(
                        movie.getTitle(),
                        movie.getShowtime(),
                        movie.getRating(),
                        movie.getReleaseDate(),
                        movie.getImageUrl(),
                        movie.getReservedRate()
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
    public Date getReleasedDate() {
        return releasedDate;
    }
    public String getImageUrl() {return imageUrl;}
    public String getReservedRate() {return reservedRate;}
}
