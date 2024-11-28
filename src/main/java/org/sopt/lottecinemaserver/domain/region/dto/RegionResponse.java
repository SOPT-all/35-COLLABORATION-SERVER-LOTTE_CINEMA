package org.sopt.lottecinemaserver.domain.region.dto;

public class RegionResponse {
    private final Long id;
    private final String name;
    private final int theaterCount;

    public RegionResponse(Long id, String name, int theaterCount) {
        this.id = id;
        this.name = name;
        this.theaterCount = theaterCount;
    }

    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTheaterCount() {
        return theaterCount;
    }
}
