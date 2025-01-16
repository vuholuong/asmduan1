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
public class TheDocGia {
    private String madg;
    private String maplt;
    private String hoten;
    private String sdt;
    private String diachi;
    private Date ngaydangki;
    private Date ngayhethan;
    private String hinh;

    public TheDocGia() {
    }

    public TheDocGia(String madg, String maplt, String hoten, String sdt, String diachi, Date ngaydangki, Date ngayhethan, String hinh) {
        this.madg = madg;
        this.maplt = maplt;
        this.hoten = hoten;
        this.sdt = sdt;
        this.diachi = diachi;
        this.ngaydangki = ngaydangki;
        this.ngayhethan = ngayhethan;
        this.hinh = hinh;
    }

    public String getMadg() {
        return madg;
    }

    public void setMadg(String madg) {
        this.madg = madg;
    }

    public String getMaplt() {
        return maplt;
    }

    public void setMaplt(String maplt) {
        this.maplt = maplt;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Date getNgaydangki() {
        return ngaydangki;
    }

    public void setNgaydangki(Date ngaydangki) {
        this.ngaydangki = ngaydangki;
    }

    public Date getNgayhethan() {
        return ngayhethan;
    }

    public void setNgayhethan(Date ngayhethan) {
        this.ngayhethan = ngayhethan;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    

}
