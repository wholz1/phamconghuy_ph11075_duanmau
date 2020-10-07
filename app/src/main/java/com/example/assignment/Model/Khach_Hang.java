package com.example.assignment.Model;

public class Khach_Hang {
    private String maKhachHang;
    private String tenKhachHang;
    private String soDT;

    public Khach_Hang() {
    }

    public Khach_Hang(String maKhachHang, String tenKhachHang, String soDT) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.soDT = soDT;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }
}
