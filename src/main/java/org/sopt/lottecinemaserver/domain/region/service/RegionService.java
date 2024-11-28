package org.sopt.lottecinemaserver.domain.region.service;

import java.util.List;
import java.util.stream.Collectors;
import org.sopt.lottecinemaserver.domain.region.dto.RegionListResponse;
import org.sopt.lottecinemaserver.domain.region.dto.RegionResponse;
import org.sopt.lottecinemaserver.domain.region.repository.RegionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegionService {
    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Transactional(readOnly = true)
    public RegionListResponse getRegions() {
        List<RegionResponse> regionResponses = regionRepository.findAll().stream()
                .map(region -> new RegionResponse(region.getId(), region.getName(), region.getTheaterCount()))
                .collect(Collectors.toList());
        return new RegionListResponse(regionResponses);
    }
}
