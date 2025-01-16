/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.entity;

/**
 *
 * @author THANH VINH
 */
public class NhaXB {
    private String manxb;
    private String tennxb;
    private String sdt;
    private String diachi;

    public NhaXB() {
    }

    public NhaXB(String manxb, String tennxb, String sdt, String diachi) {
        this.manxb = manxb;
        this.tennxb = tennxb;
        this.sdt = sdt;
        this.diachi = diachi;
    }

    public String getManxb() {
        return manxb;
    }

    public void setManxb(String manxb) {
        this.manxb = manxb;
    }

    public String getTennxb() {
        return tennxb;
    }

    public void setTennxb(String tennxb) {
        this.tennxb = tennxb;
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
    
    
}
