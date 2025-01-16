/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.entity;

import com.edusys.utils.XDate;
import java.util.Date;

/**
 *
 * @author THANH VINH
 */
public class PhieuLamThe {
    private String maplt;
    private String manv;
    private Boolean loaiphieu = false;
    private Float phithe;
    private Date ngaylapphieu = XDate.now();

    public PhieuLamThe() {
    }

    public PhieuLamThe(String maplt, String manv, Float phithe) {
        this.maplt = maplt;
        this.manv = manv;
        this.phithe = phithe;
    }

    public String getMaplt() {
        return maplt;
    }

    public void setMaplt(String maplt) {
        this.maplt = maplt;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public Boolean getLoaiphieu() {
        return loaiphieu;
    }

    public void setLoaiphieu(Boolean loaiphieu) {
        this.loaiphieu = loaiphieu;
    }

    public Float getPhithe() {
        return phithe;
    }

    public void setPhithe(Float phithe) {
        this.phithe = phithe;
    }

    public Date getNgaylapphieu() {
        return ngaylapphieu;
    }

    public void setNgaylapphieu(Date ngaylapphieu) {
        this.ngaylapphieu = ngaylapphieu;
    }

    

    
    
    
    
}
