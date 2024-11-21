package org.sopt.lottecinemaserver.domain.theater.service;

import java.util.List;
import org.sopt.lottecinemaserver.domain.region.domain.Region;
import org.sopt.lottecinemaserver.domain.region.repository.RegionRepository;
import org.sopt.lottecinemaserver.domain.theater.domain.Theater;
import org.sopt.lottecinemaserver.domain.theater.dto.TheaterListResponseDto;
import org.sopt.lottecinemaserver.global.exception.CustomException;
import org.sopt.lottecinemaserver.global.exception.ErrorType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TheaterService {
    private final RegionRepository regionRepository;

    public TheaterService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Transactional(readOnly = true)
    public TheaterListResponseDto getTheaters(final Long regionId) {
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new CustomException(ErrorType.NOT_FOUND_REGION_ERROR));

        List<String> theaterNames = region.getTheaterList().stream()
                .map(Theater::getName)
                .toList();

        return new TheaterListResponseDto(theaterNames);
    }
}
