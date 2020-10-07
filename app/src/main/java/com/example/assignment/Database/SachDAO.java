package com.example.assignment.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.assignment.Model.Sach;

import java.util.ArrayList;
import java.util.List;

public class SachDAO {
    private MySQLite mySQLite;

    public SachDAO(MySQLite mySQLite) {
        this.mySQLite = mySQLite;
    }

    public boolean xoaSach(String id) {
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        long kq = sqLiteDatabase.delete("qLiS", "maSach=?", new String[]{id});
        if (kq > 0) return true;
        else return false;
    }

    public boolean themSach(Sach sach) {
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maSach", sach.maSach);
        contentValues.put("tenSach", sach.tenSach);
        contentValues.put("soLuong", sach.soLuong);
        contentValues.put("ngayNhap", sach.ngayNhap);
        contentValues.put("tacGia", sach.tacGia);
        contentValues.put("giaSach", sach.giaSach);
        contentValues.put("nhaXuatBan", sach.nhaXB);
        contentValues.put("idTheLoai", sach.theLoai);

        long kq = sqLiteDatabase.insert("qLiS", null, contentValues);
        if (kq > 0) return true;
        else return false;
    }

    public List<Sach> getAllSach() {
        List<Sach> sachList = new ArrayList<>();
        String truyVan = "SELECT * FROM qLiS";
        Cursor cursor = mySQLite.getWritableDatabase().rawQuery(truyVan, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                String maSach = cursor.getString(cursor.getColumnIndex("maSach"));
                String tenSach = cursor.getString(cursor.getColumnIndex("tenSach"));
                String soLuong = cursor.getString(cursor.getColumnIndex("soLuong"));
                String ngayNhap = cursor.getString(cursor.getColumnIndex("ngayNhap"));
                String tacGia = cursor.getString(cursor.getColumnIndex("tacGia"));
                String gia = cursor.getString(cursor.getColumnIndex("giaSach"));
                String nhaXuatBan = cursor.getString(cursor.getColumnIndex("nhaXuatBan"));
                String theLoai = cursor.getString(cursor.getColumnIndex("idTheLoai"));

                Sach sach = new Sach();
                sach.maSach = maSach;
                sach.tenSach = tenSach;
                sach.giaSach = gia;
                sach.tacGia = tacGia;
                sach.nhaXB = nhaXuatBan;
                sach.theLoai = theLoai;
                sach.soLuong = soLuong;
                sach.ngayNhap = ngayNhap;
                sachList.add(sach);

                cursor.moveToNext();
            }
            cursor.close();
        }
        return sachList;
    }

    public boolean suaSach(Sach sach) {
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("maSach", sach.maSach);
        contentValues.put("tenSach", sach.tenSach);
        contentValues.put("soLuong", sach.soLuong);
        contentValues.put("ngayNhap", sach.ngayNhap);
        contentValues.put("tacGia", sach.tacGia);
        contentValues.put("giaSach", sach.giaSach);
        contentValues.put("nhaXuatBan", sach.nhaXB);
        contentValues.put("idTheLoai", sach.theLoai);

        long kq = sqLiteDatabase.update("qLiS", contentValues,
                "maSach=?", new String[]{sach.maSach});

        if (kq > 0) return true;
        else return false;
    }
}
