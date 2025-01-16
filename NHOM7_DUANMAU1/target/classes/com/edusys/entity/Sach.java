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
public class Sach {
    private String masach;
    private String tensach;
    private String maloai;
    private String manxb;
    private Date ngayxuatban;
    private String tacgia;
    private String mota;
    private int soluong;
    private String vitri;

    public Sach() {
    }

    public Sach(String masach, String tensach, String maloai, String manxb, Date ngayxuatban, String tacgia, String mota, int soluong, String vitri) {
        this.masach = masach;
        this.tensach = tensach;
        this.maloai = maloai;
        this.manxb = manxb;
        this.ngayxuatban = ngayxuatban;
        this.tacgia = tacgia;
        this.mota = mota;
        this.soluong = soluong;
        this.vitri = vitri;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getMaloai() {
        return maloai;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    public String getManxb() {
        return manxb;
    }

    public void setManxb(String manxb) {
        this.manxb = manxb;
    }

    public Date getNgayxuatban() {
        return ngayxuatban;
    }

    public void setNgayxuatban(Date ngayxuatban) {
        this.ngayxuatban = ngayxuatban;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getVitri() {
        return vitri;
    }

    public void setVitri(String vitri) {
        this.vitri = vitri;
    }

}
