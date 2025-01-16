/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.entity;

import java.util.Date;

/**
 *
 * @author THANH VINH
 */
public class PhieuTraSach {
    private String mapt;
    private String mapm;
    private Date ngaytra;
    private String trangthai;

    public PhieuTraSach() {
    }

    public PhieuTraSach(String mapt, String mapm, Date ngaytra, String trangthai) {
        this.mapt = mapt;
        this.mapm = mapm;
        this.ngaytra = ngaytra;
        this.trangthai = trangthai;
    }

    public String getMapt() {
        return mapt;
    }

    public void setMapt(String mapt) {
        this.mapt = mapt;
    }

    public String getMapm() {
        return mapm;
    }

    public void setMapm(String mapm) {
        this.mapm = mapm;
    }

    public Date getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(Date ngaytra) {
        this.ngaytra = ngaytra;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
    
}
