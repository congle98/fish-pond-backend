package com.fishpond.repository;

import com.fishpond.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeviceRepository extends JpaRepository<Device,Long> {
    List<Device> findAllByFishPondId(Long fishPondId);
    List<Device> findAllByFishPondIdIn(List<Long> fishPondIds);
    Optional<Device> findDistinctByDeviceId(String deviceId);
}
