package com.fishpond.service;

import com.fishpond.model.AquaticInformation;
import com.fishpond.model.dto.AquaticInformationOfDevice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AquaticInformationService {

    Page<AquaticInformation> findAll(String keyword, Pageable pageable);

    AquaticInformation findById(Long id);

    Page<AquaticInformation> findAllByUser(String userName, String keyword, Pageable pageable);

    AquaticInformation findByIdAndUser(Long id,Long uId);

    Page<AquaticInformation> findAllByDeviceId(Long deviceId, Pageable pageable);

    Page<AquaticInformation> findAllOfDeviceLastUpdate(String keyword,Pageable pageable);

    AquaticInformation save(AquaticInformationOfDevice aquaticInformationOfDevice);
}
