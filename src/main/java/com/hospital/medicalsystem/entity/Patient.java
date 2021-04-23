package com.hospital.medicalsystem.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Patient {
    @Id
    //证件号、证件类型、患者名、社保号、电话、状态
    private String idCard;
    private String idType;
    private String name;
    private String socialSecurityNo;
    private String state;
}
