/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.entity;

/**
 *
 * @author THANH VINH
 */
public class PhieuPhat {
    private String mapp;
    private String mapt;
    private String noidung;
    private Float phiphat;

    public PhieuPhat() {
    }

    public PhieuPhat(String mapp, String mapt, String noidung, float phiphat) {
        this.mapp = mapp;
        this.mapt = mapt;
        this.noidung = noidung;
        this.phiphat = phiphat;
    }

    public String getMapp() {
        return mapp;
    }

    public void setMapp(String mapp) {
        this.mapp = mapp;
    }

    public String getMapt() {
        return mapt;
    }

    public void setMapt(String mapt) {
        this.mapt = mapt;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public float getPhiphat() {
        return phiphat;
    }

    public void setPhiphat(float phiphat) {
        this.phiphat = phiphat;
    }
    
}
