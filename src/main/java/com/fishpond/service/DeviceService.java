package com.fishpond.service;


import com.fishpond.model.Device;

import java.util.Optional;

public interface DeviceService {
    Device findByDeviceId(String deviceId);
}
