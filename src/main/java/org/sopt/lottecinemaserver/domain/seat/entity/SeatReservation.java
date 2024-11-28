package org.sopt.lottecinemaserver.domain.seat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.sopt.lottecinemaserver.domain.movie.entity.Movie;

@Entity
@Table(name = "seat_reservation")
public class SeatReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @Column(name = "seat_number", nullable = false)
    private Integer seatNumber;

    protected SeatReservation() { }

    public SeatReservation(Movie movie, Integer seatNumber) {
        this.movie = movie;
        this.seatNumber = seatNumber;
    }

    public Long getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }
}