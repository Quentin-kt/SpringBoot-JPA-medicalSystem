package com.hospital.medicalsystem.entity;

import lombok.Data;

@Data
public class Result {
    private Integer code;
    private String msg;
    private Object data ;
}
