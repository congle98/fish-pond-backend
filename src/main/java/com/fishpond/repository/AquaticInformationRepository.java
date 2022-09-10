package com.fishpond.repository;

import com.fishpond.model.AquaticInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AquaticInformationRepository extends JpaRepository<AquaticInformation,Long> {
}
