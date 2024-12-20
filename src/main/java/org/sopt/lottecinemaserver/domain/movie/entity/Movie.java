package org.sopt.lottecinemaserver.domain.movie.entity;

import jakarta.persistence.*;
import org.sopt.lottecinemaserver.domain.seat.entity.Seat;

import java.sql.Date;
import java.util.List;
//COMMENT

@Entity
public class Movie {
    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private int showtime;

    @Column
    private String rating;

    @Column
    private Date releaseDate;

    @Column
    private String imageUrl;

    @Column
    private String reservedRate;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Seat> seatList;

    protected Movie(){

    }

    public Long getId() {
        return id;
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getImageUrl() { return imageUrl; }

    public String getReservedRate() { return reservedRate; }
}
