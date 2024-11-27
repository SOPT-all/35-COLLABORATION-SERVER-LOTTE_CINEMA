package org.sopt.lottecinemaserver.domain.screen.dto;

public class TimeResponse {
    private String beginTime;
    private String endTime;

    public TimeResponse(String beginTime, String endTime) {
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public String getEndTime() {
        return endTime;
    }
}
