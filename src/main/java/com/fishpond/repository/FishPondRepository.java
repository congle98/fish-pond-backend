package com.fishpond.repository;

import com.fishpond.model.FishPond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FishPondRepository extends JpaRepository<FishPond,Long> {
    List<FishPond> getAllByUserIdIn(List<Long> userIds);
}
