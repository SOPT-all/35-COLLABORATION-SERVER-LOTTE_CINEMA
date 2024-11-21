package org.sopt.lottecinemaserver.domain.theater.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.sopt.lottecinemaserver.domain.region.domain.Region;

@Entity
@Table(name = "theater")
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theater_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "region_id", referencedColumnName = "region_id", nullable = false)
    private Region region;

    protected Theater() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Region getRegion() {
        return region;
    }

}
