package org.sopt.lottecinemaserver.domain.seat.entity;

import jakarta.persistence.*;
import org.sopt.lottecinemaserver.domain.movie.entity.Movie;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

}
