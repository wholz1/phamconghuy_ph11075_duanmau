package com.example.assignment.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.assignment.Model.Hoa_Don;

import java.util.ArrayList;
import java.util.List;

public class HoaDonDAO {
    private MySQLite mySQLite;

    public HoaDonDAO(MySQLite mySQLite) {
        this.mySQLite = mySQLite;
    }

    public boolean xoaHoaDon(String id) {
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();

        long kq = sqLiteDatabase.delete("qliHD", "maHoaDon=?", new String[]{id});

        if (kq > 0) return true;
        else return false;
    }

    public boolean themHoaDon(Hoa_Don hoa_don) {
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maHoaDon", hoa_don.getMaHoaDon());
        contentValues.put("ngayTao", hoa_don.getNgayTao());
        contentValues.put("idKhachHang", hoa_don.getIdKhachHang());
        contentValues.put("idNguoiDung", hoa_don.getIdNguoiDung());
        contentValues.put("idSach", hoa_don.getIdSach());
        contentValues.put("soLuong", hoa_don.getSoLuong());
        contentValues.put("donGia", hoa_don.getDonGia());

        long kq = sqLiteDatabase.insert("qliHD", null, contentValues);
        if (kq > 0) return true;
        else return false;
    }

    public List<Hoa_Don> getAllHoaDon() {
        List<Hoa_Don> hoaDonList = new ArrayList<>();
        String truyVan = "SELECT * FROM qliHD";
        Cursor cursor = mySQLite.getWritableDatabase().rawQuery(truyVan, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                String maHoaDon = cursor.getString(cursor.getColumnIndex("maHoaDon"));
                String ngayTao = cursor.getString(cursor.getColumnIndex("ngayTao"));
                String idKhachHang = cursor.getString(cursor.getColumnIndex("idKhachHang"));
                String idNguoiDung = cursor.getString(cursor.getColumnIndex("idNguoiDung"));
                String idSach = cursor.getString(cursor.getColumnIndex("idSach"));
                String soLuong = cursor.getString(cursor.getColumnIndex("soLuong"));
                String donGia = cursor.getString(cursor.getColumnIndex("donGia"));

                Hoa_Don hoa_don = new Hoa_Don();
                hoa_don.setMaHoaDon(maHoaDon);
                hoa_don.setNgayTao(ngayTao);
                hoa_don.setIdKhachHang(idKhachHang);
                hoa_don.setIdNguoiDung(idNguoiDung);
                hoa_don.setIdSach(idSach);
                hoa_don.setSoLuong(Integer.parseInt(soLuong));
                hoa_don.setDonGia(Integer.parseInt(donGia));
                hoaDonList.add(hoa_don);

                cursor.moveToNext();
            }
            cursor.close();
        }
        return hoaDonList;
    }

    public boolean suaHoaDon(Hoa_Don hoa_don) {
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("maHoaDon", hoa_don.getMaHoaDon());
        contentValues.put("ngayTao", hoa_don.getNgayTao());
        contentValues.put("idKhachHang", hoa_don.getIdKhachHang());
        contentValues.put("idNguoiDung", hoa_don.getIdNguoiDung());
        contentValues.put("idSach", hoa_don.getIdSach());
        contentValues.put("soLuong", hoa_don.getSoLuong());
        contentValues.put("donGia", hoa_don.getDonGia());

        long kq = sqLiteDatabase.update("qliND", contentValues,
                "maHoaDon=?", new String[]{hoa_don.getMaHoaDon()});
        if (kq > 0) return true;
        else return false;
    }
}
