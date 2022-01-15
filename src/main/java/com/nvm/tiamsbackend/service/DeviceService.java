package com.nvm.tiamsbackend.service;

import com.nvm.tiamsbackend.entity.Device;

import java.util.Optional;

public interface DeviceService {

    void saveDevice(Device device);

    Optional<Device> getDeviceById(Long deviceId);
}
