package com.huangyunchi.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Vendor implements Serializable {

    private long vendorId;
    private String vendorName;
    private String vendorLicense;
    private String vendorTel;
    private String vendorEmail;
    private String vendorPassword;
    private double vendorScore;
    private int vendorLevel;
    private Date vendorRegisterTime;
    private int vendorStatus;

}
