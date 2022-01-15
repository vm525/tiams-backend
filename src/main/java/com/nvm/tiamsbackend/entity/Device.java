package com.nvm.tiamsbackend.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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