package com.fishpond.service.impl;

import com.fishpond.model.AquaticInformation;
import com.fishpond.model.Device;
import com.fishpond.model.dto.AquaticInformationOfDevice;
import com.fishpond.repository.AquaticInformationRepository;
import com.fishpond.service.AquaticInformationService;
import com.fishpond.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class AquaticInformationServiceImpl implements AquaticInformationService {

    @Autowired
    private AquaticInformationRepository aquaticInformationRepository;

    @Autowired
    private DeviceService deviceService;

    @Override
    public Page<AquaticInformation> findAll(String keyword, Pageable pageable) {
        return aquaticInformationRepository.findAll(keyword,pageable);
    }

    @Override
    public AquaticInformation findById(Long id) {
        return aquaticInformationRepository.findById(id).orElseThrow(()-> new RuntimeException("không tồn tại!"));
    }

    @Override
    public Page<AquaticInformation> findAllByUser(String userName, String keyword, Pageable pageable) {
        return aquaticInformationRepository.findAllByUser(userName,keyword,pageable);
    }

    @Override
    public AquaticInformation findByIdAndUser(Long id, Long uId) {
        return null;
    }

    @Override
    public Page<AquaticInformation> findAllByDeviceId(Long deviceId, Pageable pageable) {
        return aquaticInformationRepository.findAllByDevice(deviceId,pageable);
    }


    @Override
    public Page<AquaticInformation> findAllOfDeviceLastUpdate(String keyword, Pageable pageable) {
        return aquaticInformationRepository.findAllOfDeviceUpdateDate(keyword,pageable);
    }

    @Override
    public AquaticInformation save(AquaticInformationOfDevice aquaticInformationOfDevice) {
        AquaticInformation aquaticInformation = new AquaticInformation();

        Device device = deviceService.findByDeviceId(aquaticInformationOfDevice.getDeviceId());

        aquaticInformation.setDevice(device);
        aquaticInformation.setCreateDate(LocalDateTime.now());
        aquaticInformation.setDissolvedOxygen(aquaticInformationOfDevice.getDissolvedOxygen());
        aquaticInformation.setHumidity(aquaticInformationOfDevice.getHumidity());
        aquaticInformation.setPh(aquaticInformationOfDevice.getPh());
        aquaticInformation.setTemperature(aquaticInformationOfDevice.getTemperature());

        if(aquaticInformationOfDevice.getTemperature() >= 20 && aquaticInformationOfDevice.getTemperature() <= 30){
            aquaticInformation.setEvaluation("tốt");
        }
        else if((aquaticInformationOfDevice.getTemperature() >= 15 && aquaticInformationOfDevice.getTemperature() < 20)
                || (aquaticInformationOfDevice.getTemperature() > 30 && aquaticInformationOfDevice.getTemperature() <= 40)){
            aquaticInformation.setEvaluation("bình thường");
        }
        else {
            aquaticInformation.setEvaluation("cảnh báo");
        }

        return aquaticInformationRepository.save(aquaticInformation);
    }
}
