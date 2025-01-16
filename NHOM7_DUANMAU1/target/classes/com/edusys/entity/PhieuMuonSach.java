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
public class PhieuMuonSach {
    private String mapm;
    private String manv;
    private String madg;
    private String trangthai;
    private Date ngaymuon;
    private int soluong;

    public PhieuMuonSach() {
    }

    public PhieuMuonSach(String mapm, String manv, String madg, String trangthai, Date ngaymuon, int soluong) {
        this.mapm = mapm;
        this.manv = manv;
        this.madg = madg;
        this.trangthai = trangthai;
        this.ngaymuon = ngaymuon;
        this.soluong = soluong;
    }

    public String getMapm() {
        return mapm;
    }

    public void setMapm(String mapm) {
        this.mapm = mapm;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getMadg() {
        return madg;
    }

    public void setMadg(String madg) {
        this.madg = madg;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public Date getNgaymuon() {
        return ngaymuon;
    }

    public void setNgaymuon(Date ngaymuon) {
        this.ngaymuon = ngaymuon;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
