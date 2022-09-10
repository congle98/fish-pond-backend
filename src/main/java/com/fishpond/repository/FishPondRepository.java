package com.fishpond.repository;

import com.fishpond.model.FishPond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishPondRepository extends JpaRepository<FishPond,Long> {
}
