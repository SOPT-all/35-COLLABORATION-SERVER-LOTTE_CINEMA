package org.sopt.lottecinemaserver.domain.time.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.sopt.lottecinemaserver.domain.screen.domain.Screen;

@Entity
@Table(name = "time")
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_id")
    private Long id;

    @Column(name = "begin_time")
    private String beginTime;

    @Column(name = "end_time")
    private String entTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "screen_id", referencedColumnName = "screen_id", nullable = false)
    private Screen screen;

    protected Time() {

    }

    public Long getId() {
        return id;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public String getEntTime() {
        return entTime;
    }

    public Screen getScreen() {
        return screen;
    }
}
