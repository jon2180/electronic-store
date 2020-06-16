package com.huangyunchi.entity;

import java.io.Serializable;
import java.util.Date;

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


    public long getVendorId() {
        return vendorId;
    }

    public void setVendorId(long vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorLicense() {
        return vendorLicense;
    }

    public void setVendorLicense(String vendorLicense) {
        this.vendorLicense = vendorLicense;
    }

    public String getVendorTel() {
        return vendorTel;
    }

    public void setVendorTel(String vendorTel) {
        this.vendorTel = vendorTel;
    }

    public String getVendorEmail() {
        return vendorEmail;
    }

    public void setVendorEmail(String vendorEmail) {
        this.vendorEmail = vendorEmail;
    }

    public double getVendorScore() {
        return vendorScore;
    }

    public void setVendorScore(double vendorScore) {
        this.vendorScore = vendorScore;
    }

    public int getVendorLevel() {
        return vendorLevel;
    }

    public void setVendorLevel(int vendorLevel) {
        this.vendorLevel = vendorLevel;
    }

    public Date getVendorRegisterTime() {
        return vendorRegisterTime;
    }

    public void setVendorRegisterTime(Date vendorRegisterTime) {
        this.vendorRegisterTime = vendorRegisterTime;
    }

    public int getVendorStatus() {
        return vendorStatus;
    }

    public void setVendorStatus(int vendorStatus) {
        this.vendorStatus = vendorStatus;
    }

    public String getVendorPassword() {
        return vendorPassword;
    }

    public void setVendorPassword(String vendorPassword) {
        this.vendorPassword = vendorPassword;
    }
}
