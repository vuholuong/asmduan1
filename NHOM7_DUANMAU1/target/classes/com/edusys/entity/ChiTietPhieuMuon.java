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
public class ChiTietPhieuMuon {
    private String mapm;
    private String masach;
    private Date ngaytra;

    public ChiTietPhieuMuon() {
    }

    public ChiTietPhieuMuon(String mapm, String masach, Date ngaytra) {
        this.mapm = mapm;
        this.masach = masach;
        this.ngaytra = ngaytra;
    }

    public String getMapm() {
        return mapm;
    }

    public void setMapm(String mapm) {
        this.mapm = mapm;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public Date getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(Date ngaytra) {
        this.ngaytra = ngaytra;
    }
    
}
