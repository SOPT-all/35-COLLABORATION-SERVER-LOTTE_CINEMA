package org.sopt.lottecinemaserver.domain.theater.dto;

import java.util.List;

public class TheaterListResponseDto {
    private final List<String> theaterList;

    public TheaterListResponseDto(List<String> theaterList) {
        this.theaterList = theaterList;
    }

    public List<String> getTheaterList() {
        return theaterList;
    }
}
