package org.sopt.lottecinemaserver.domain.seat.repository;

import org.sopt.lottecinemaserver.domain.seat.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Long> {

}
