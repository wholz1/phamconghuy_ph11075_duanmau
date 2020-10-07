package com.example.assignment.Model;

public class Hoa_Don {
    private String maHoaDon;
    private String ngayTao;
    private String idKhachHang;
    private String idNguoiDung;
    private String idSach;
    private int soLuong;
    private int donGia;

    public Hoa_Don() {
    }

    public Hoa_Don(String maHoaDon, String ngayTao, String idKhachHang, String idNguoiDung, String idSach, int soLuong, int donGia) {
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.idKhachHang = idKhachHang;
        this.idNguoiDung = idNguoiDung;
        this.idSach = idSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(String idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getIdNguoiDung() {
        return idNguoiDung;
    }

    public void setIdNguoiDung(String idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    public String getIdSach() {
        return idSach;
    }

    public void setIdSach(String idSach) {
        this.idSach = idSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
}
