package com.nvm.tiamsbackend.entity;

import com.nvm.tiamsbackend.common.Utils;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Device {
    @Id
    private String id = Utils.generateId();
    private String tag;
    private String model;
    private String serialNumber;
    private String mac;
    private String imageUrl;
    private Date purchaseDate;
    private String purchaseFrom;
    private Date expiryDate;
    private DeviceStatus status;

}

enum DeviceStatus {
    DEPLOYED,
    ASSIGNED,
    UNASSIGNED,
    SCRAPPED
}