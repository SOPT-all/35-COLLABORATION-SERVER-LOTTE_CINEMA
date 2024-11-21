package org.sopt.lottecinemaserver.domain.screen.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.sopt.lottecinemaserver.domain.screen.domain.Screen;
import org.sopt.lottecinemaserver.domain.screen.dto.ScreenListResponseDto;
import org.sopt.lottecinemaserver.domain.screen.dto.TimeResponse;
import org.sopt.lottecinemaserver.domain.screen.repository.ScreenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScreenService {

    private final ScreenRepository screenRepository;

    public ScreenService(ScreenRepository screenRepository) {
        this.screenRepository = screenRepository;
    }

    @Transactional(readOnly = true)
    public List<ScreenListResponseDto> getRandomScreens(int theaterCount) {
        List<Screen> allScreens = screenRepository.findAll();

        Collections.shuffle(allScreens);
        List<Screen> selectedScreens = allScreens.subList(0, theaterCount);

        List<ScreenListResponseDto> response = new ArrayList<>();
        for (Screen screen : selectedScreens) {
            List<TimeResponse> timeResponses = new ArrayList<>();
            screen.getTimeList().forEach(time -> timeResponses.add(
                    new TimeResponse(time.getBeginTime(), time.getEntTime())
            ));
            response.add(new ScreenListResponseDto(screen.getName(), screen.getSubname(),
                    screen.getDescription(), timeResponses));
        }
        return response;
    }
}
