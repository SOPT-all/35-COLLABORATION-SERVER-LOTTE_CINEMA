package org.sopt.lottecinemaserver.domain.screen.dto;

import java.util.List;

public class ScreenResponseDto {
    private String name;
    private String subname;
    private String description;
    private List<TimeResponse> timesList;

    public ScreenResponseDto(String name, String subname, String description, List<TimeResponse> timesList) {
        this.name = name;
        this.subname = subname;
        this.description = description;
        this.timesList = timesList;
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

    public List<TimeResponse> getTimesList() {
        return timesList;
    }
}
