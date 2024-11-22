package org.sopt.lottecinemaserver.domain.movie.dto.response;

import java.util.Date;

public class PopularMovieResponse {
    private final String title;
    private final int showtime;
    private final String rating;
    private final Date released_date;

    public PopularMovieResponse(String title, int showtime, String rating, Date released_date){
        this.title = title;
        this.showtime = showtime;
        this.rating = rating;
        this.released_date = released_date;
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
