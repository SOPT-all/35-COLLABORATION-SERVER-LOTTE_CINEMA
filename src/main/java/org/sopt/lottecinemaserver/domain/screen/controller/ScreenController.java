package org.sopt.lottecinemaserver.domain.screen.controller;

import java.util.List;
import org.sopt.lottecinemaserver.domain.screen.dto.ScreenListResponseDto;
import org.sopt.lottecinemaserver.domain.screen.service.ScreenService;
import org.sopt.lottecinemaserver.global.common.ApiResponse;
import org.sopt.lottecinemaserver.global.common.SuccessType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/screen")
public class ScreenController {

    private final ScreenService screenService;

    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }

    @GetMapping("/{theaterCount}")
    public ResponseEntity<ApiResponse<List<ScreenListResponseDto>>> getScreenAndTimeList(
            @PathVariable final int theaterCount
    ) {
        return ResponseEntity.ok(
                ApiResponse.success(SuccessType.GET_SCREEN_TIME_LIST_SUCCESS, screenService.getRandomScreens(theaterCount)));
    }
}
