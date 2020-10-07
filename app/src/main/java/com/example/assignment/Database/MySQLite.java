package com.example.assignment.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLite extends SQLiteOpenHelper {


    public MySQLite(Context context) {
        super(context, "qls.sql", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String hoaDon = "CREATE TABLE hoaDon (maHoaDon nvarchar(10) primary key not null,"
//                + " ngayTao nvarchar(100), idKhachHang nvarchar(10), idNguoiDung nvarchar(10), idSach nvarchar(10), soLuong int, donGia int)";
//
//        String khachHang = "CREATE TABLE khachHang (maKhachHang nvarchar(10)  primary key not null,"
//                + " tenKhachHang nvarchar(50), soDt navarchar(11))";

        String qLiND = "CREATE TABLE qLiND (userName char(10) primary key"
                + ",matKhauND varchar,tenND varchar(50)" +
                ",soDT char,email char)";

        String qLiS = "CREATE TABLE qLiS (maSach char(10)  primary key"
                + ",tenSach varchar(100),soLuong varchar,ngayNhap varchar(100),tacGia varchar(50)" +
                ",giaSach varchar,nhaXuatBan varchar(100),idTheLoai varchar(50))";

//        String theLoai = "CREATE TABLE theLoai (maTheloai nvarchar(50) primary key,"
//                + " tenTheLoai nvarchar(50))";

//        db.execSQL(hoaDon);
//        db.execSQL(khachHang);
        db.execSQL(qLiND);
        db.execSQL(qLiS);
//        db.execSQL(theLoai);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
