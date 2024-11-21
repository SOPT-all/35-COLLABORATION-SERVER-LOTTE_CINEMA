package org.sopt.lottecinemaserver.domain.region.dto;

public class RegionResponse {
    private final String name;
    private final int theaterCount;

    public RegionResponse(String name, int theaterCount) {
        this.name = name;
        this.theaterCount = theaterCount;
    }

    public String getName() {
        return name;
    }

    public int getTheaterCount() {
        return theaterCount;
    }
}
