package com.hospital.medicalsystem.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //设置主键PersonIdr为自增
    //用户Id、用户名、密码、电话、邮件、用户身份
    private Integer personId;
    private String name;
    private String password;
    private String tel;
    private String email;
    private Integer userTypes;
}