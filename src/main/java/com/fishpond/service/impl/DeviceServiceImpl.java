package com.fishpond.service.impl;

import com.fishpond.model.Device;
import com.fishpond.repository.DeviceRepository;
import com.fishpond.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public Device findByDeviceId(String deviceId) {
        return deviceRepository.findDistinctByDeviceId(deviceId).orElseThrow(()-> new RuntimeException("không tồn tại!!"));
    }
}
