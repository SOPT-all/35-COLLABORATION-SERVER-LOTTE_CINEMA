package org.sopt.lottecinemaserver.domain.region.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import org.sopt.lottecinemaserver.domain.theater.domain.Theater;

@Entity
@Table(name = "region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "theater_count")
    private int theaterCount;

    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Theater> theaterList;

    protected Region() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTheaterCount() {
        return theaterCount;
    }

    public List<Theater> getTheaterList() {
        return theaterList;
    }

}
