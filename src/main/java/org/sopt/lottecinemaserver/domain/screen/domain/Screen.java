package org.sopt.lottecinemaserver.domain.screen.domain;

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
import org.sopt.lottecinemaserver.domain.time.domain.Time;

@Entity
@Table(name = "screen")
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "screen_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "subname")
    private String subname;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "screen", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Time> timeList;

    protected Screen() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSubname() {
        return subname;
    }

    public String getDescription() {
        return description;
    }

    public List<Time> getTimeList() {
        return timeList;
    }
}
