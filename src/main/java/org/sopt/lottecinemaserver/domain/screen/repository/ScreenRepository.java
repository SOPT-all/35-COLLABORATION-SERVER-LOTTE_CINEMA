package org.sopt.lottecinemaserver.domain.screen.repository;

import org.sopt.lottecinemaserver.domain.screen.domain.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenRepository extends JpaRepository<Screen, Long> {
}
