package com.example.assignment.Model;

public class The_Loai {
    private String tenTheLoai;
    private String maTheLoai;

    public The_Loai() {
    }

    public The_Loai(String tenTheLoai, String maTheLoai) {
        this.tenTheLoai = tenTheLoai;
        this.maTheLoai = maTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }
}
