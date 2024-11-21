package org.sopt.lottecinemaserver.domain.movie.entity;

import jakarta.persistence.*;
import java.sql.Date;
//COMMENT

@Entity
public class Movie {
    @Id
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
}
