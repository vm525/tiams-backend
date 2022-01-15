package com.nvm.tiamsbackend.controller;

import com.nvm.tiamsbackend.entity.Device;
import com.nvm.tiamsbackend.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping("api/v1/device/{id}")
    public Optional<Device> getDeviceById(@PathVariable("id") Long deviceId) {
        return deviceService.getDeviceById(deviceId);
    }

    @PostMapping("/api/v1/device/add")
    public void addNewDevice(@RequestBody Device device) {
        deviceService.saveDevice(device);
    }

}
