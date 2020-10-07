package com.example.assignment.Model;

public class Quan_Li_Nguoi_Dung {
    public String userName;
    public String matKhau;
    public String tenND;
    public String soDT;
    public String Email;

    public Quan_Li_Nguoi_Dung() {
    }

    public Quan_Li_Nguoi_Dung(String userName, String matKhau, String tenND, String soDT, String email) {
        this.userName = userName;
        this.matKhau = matKhau;
        this.tenND = tenND;
        this.soDT = soDT;
        Email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTenND() {
        return tenND;
    }

    public void setTenND(String tenND) {
        this.tenND = tenND;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
