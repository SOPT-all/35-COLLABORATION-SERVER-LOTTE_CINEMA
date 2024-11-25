package org.sopt.lottecinemaserver.domain.seat.entity;

import jakarta.persistence.*;
import org.sopt.lottecinemaserver.domain.movie.entity.Movie;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Long id;

    @Column(name = "reserved_seats")
    private String reservedSeat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    Seat(){ }

    public Long getId() { return id; }

    public String getReservedSeat() { return reservedSeat; }

    public Movie getMovie() { return movie; }
}
