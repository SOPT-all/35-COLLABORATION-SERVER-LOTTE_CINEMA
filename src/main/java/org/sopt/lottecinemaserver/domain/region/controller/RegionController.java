package org.sopt.lottecinemaserver.domain.region.controller;

import org.sopt.lottecinemaserver.domain.region.dto.RegionListResponse;
import org.sopt.lottecinemaserver.domain.region.service.RegionService;
import org.sopt.lottecinemaserver.global.common.ApiResponse;
import org.sopt.lottecinemaserver.global.common.SuccessType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/region")
public class RegionController {

    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<RegionListResponse>> getRegionList() {
        return ResponseEntity.ok(ApiResponse.success(SuccessType.GET_REGION_LIST_SUCCESS, regionService.getRegions()));
    }
}