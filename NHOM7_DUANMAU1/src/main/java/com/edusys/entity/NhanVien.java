/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.entity;

public class NhanVien {
    private String manv; 
    private String hoten;
    private String sdt;
    private String email;
    private String diachi;
    private Boolean chucvu = false;
    private String matkhau;

    public NhanVien() {
    }

    public NhanVien(String manv, String hoten, String sdt, String email, String diachi, String matkhau) {
        this.manv = manv;
        this.hoten = hoten;
        this.sdt = sdt;
        this.email = email;
        this.diachi = diachi;
        this.matkhau = matkhau;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Boolean getChucvu() {
        return chucvu;
    }

    public void setChucvu(Boolean chucvu) {
        this.chucvu = chucvu;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    

}
