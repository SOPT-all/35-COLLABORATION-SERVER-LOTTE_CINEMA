package org.sopt.lottecinemaserver.domain.region.repository;

import org.sopt.lottecinemaserver.domain.region.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
