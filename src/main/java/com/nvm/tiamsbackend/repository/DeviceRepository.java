package com.nvm.tiamsbackend.repository;

import com.nvm.tiamsbackend.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {

}
