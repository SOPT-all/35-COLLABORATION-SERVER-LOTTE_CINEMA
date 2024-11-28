package org.sopt.lottecinemaserver.domain.seat.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.sopt.lottecinemaserver.domain.seat.dto.response.ReservedSeatsResponse;
import org.sopt.lottecinemaserver.domain.seat.entity.Seat;
import org.sopt.lottecinemaserver.domain.seat.repository.SeatRepository;
import org.sopt.lottecinemaserver.global.exception.CustomException;
import org.sopt.lottecinemaserver.global.exception.ErrorType;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeatService {
    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Transactional
    public void reserveSeats(Long movieId, List<Integer> seats) {
        // 요청된 좌석 내 중복 확인
        validateDuplicateSeats(seats);

        // 영화 ID로 Seat 조회
        Seat seat = seatRepository.findByMovieId(movieId)
                .orElseThrow(() -> new CustomException(ErrorType.NOT_FOUND_MOVIE));

        // 기존 예약된 좌석 가져오기
        Set<Integer> existingReservedSeats = Arrays.stream(seat.getReservedSeat().split(","))
                .filter(s -> !s.isEmpty()) // 빈 문자열 필터링
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        // 새로 요청된 좌석과 기존 좌석의 중복 확인
        for (Integer requestedSeat : seats) {
            if (existingReservedSeats.contains(requestedSeat)) {
                throw new CustomException(ErrorType.DUPLE_SEAT);
            }
        }

        // 새로 요청된 좌석을 기존 예약된 좌석에 추가
        existingReservedSeats.addAll(seats);

        // 직렬화: Set을 String으로 변환
        String updatedReservedSeatsString = existingReservedSeats.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        // Seat 엔티티 업데이트
        seat.setReservedSeat(updatedReservedSeatsString);
        seatRepository.save(seat);
    }

    private void validateDuplicateSeats(List<Integer> seats) {
        Set<Integer> seatSet = new HashSet<>();
        for (Integer seat : seats) {
            if (!seatSet.add(seat)) { // 중복이 감지되면 예외 발생
                throw new CustomException(ErrorType.INVALID_DUPLE_SEAT_ERROR);
            }
        }
    }


    @Transactional(readOnly = true)
    public ReservedSeatsResponse getReservedSeats(Long movieId) {
        // 영화 ID로 Seat 조회
        Optional<Seat> optionalSeat = seatRepository.findByMovieId(movieId);

        // String을 리스트로 역직렬화
        List<Integer> reservedSeats = optionalSeat.map(seat -> Arrays.stream(seat.getReservedSeat().split(","))
                        .filter(s -> !s.isEmpty())
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
                .orElse(List.of()); // 없으면 빈 리스트 반환

        return new ReservedSeatsResponse(reservedSeats);
    }
}


