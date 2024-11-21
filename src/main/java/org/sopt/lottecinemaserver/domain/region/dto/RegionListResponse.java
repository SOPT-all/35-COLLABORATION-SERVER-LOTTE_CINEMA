package org.sopt.lottecinemaserver.domain.region.dto;

import java.util.List;

public class RegionListResponse {
    private final List<RegionResponse> regionList;

    public RegionListResponse(List<RegionResponse> regionList) {
        this.regionList = regionList;
    }

    public List<RegionResponse> getRegionList() {
        return regionList;
    }
}
