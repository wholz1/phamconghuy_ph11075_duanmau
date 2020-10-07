package com.example.assignment.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.assignment.Model.Khach_Hang;

import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO {
    private MySQLite mySQLite;

    public KhachHangDAO(MySQLite mySQLite) {
        this.mySQLite = mySQLite;
    }

    public void xoaKhachHang(String id) {
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        sqLiteDatabase.delete("qliKH", "maKhachHang=?", new String[]{id});
    }

    public long themKhachHang(Khach_Hang khach_hang) {
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("maKhachHang", khach_hang.getMaKhachHang());
        contentValues.put("tenKhachHang", khach_hang.getTenKhachHang());
        contentValues.put("soDT", khach_hang.getSoDT());

        return sqLiteDatabase.insert("qliKH", null, contentValues);
    }

    public List<Khach_Hang> getAllKhachHang() {
        List<Khach_Hang> khachHangList = new ArrayList<>();
        String truyVan = "SELECT * FROM qliKH";
        Cursor cursor = mySQLite.getWritableDatabase().rawQuery(truyVan, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                String maKhachHang = cursor.getString(cursor.getColumnIndex("maKhachHang"));
                String tenKhachHang = cursor.getString(cursor.getColumnIndex("tenKhachHang"));
                String soDT = cursor.getString(cursor.getColumnIndex("soDT"));

                Khach_Hang khach_hang = new Khach_Hang();

                khach_hang.setMaKhachHang(maKhachHang);
                khach_hang.setTenKhachHang(tenKhachHang);
                khach_hang.setSoDT(soDT);

                cursor.moveToNext();
            }
            cursor.close();
        }
        return khachHangList;
    }

    public int suaKhachHang(Khach_Hang khach_hang) {
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("maKhachHang", khach_hang.getMaKhachHang());
        contentValues.put("tenKhachHang", khach_hang.getTenKhachHang());
        contentValues.put("soDT", khach_hang.getSoDT());


        return sqLiteDatabase.update("qliKH", contentValues,
                "maKhachHang=?", new String[]{khach_hang.getMaKhachHang()});
    }
}
