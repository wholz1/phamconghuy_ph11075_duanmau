package com.example.assignment.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.assignment.Model.Quan_Li_Nguoi_Dung;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungDAO {

    private MySQLite mySQLite;

    public NguoiDungDAO(MySQLite mySQLite) {
        this.mySQLite = mySQLite;
    }


    // add

    public boolean themNguoiDung(Quan_Li_Nguoi_Dung quan_li_nguoi_dung) {
        // xin quyen 1
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        // ghép cặp giá trị vào tên cột 2
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", quan_li_nguoi_dung.userName);
        contentValues.put("matKhauND", quan_li_nguoi_dung.matKhau);
        contentValues.put("tenND", quan_li_nguoi_dung.tenND);
        contentValues.put("soDT", quan_li_nguoi_dung.soDT);
        contentValues.put("email", quan_li_nguoi_dung.Email);
        // truy vấn 3
        long kq = sqLiteDatabase.insert("qLiND", null, contentValues);

        if (kq > 0) return true;
        else return false;

    }

    // update
    public boolean suaNguoiDung(Quan_Li_Nguoi_Dung quan_li_nguoi_dung) {
        // xin quyen 1
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        // ghép cặp giá trị vào tên cột 2
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", quan_li_nguoi_dung.userName);
        contentValues.put("matKhauND", quan_li_nguoi_dung.matKhau);
        contentValues.put("tenND", quan_li_nguoi_dung.tenND);
        contentValues.put("soDT", quan_li_nguoi_dung.soDT);
        contentValues.put("email", quan_li_nguoi_dung.Email);
        // truy vấn 3
        long kq = sqLiteDatabase.update("qLiND", contentValues, "userName=?",
                new String[]{quan_li_nguoi_dung.userName});

        if (kq > 0) return true;
        else return false;

    }

    // del
    public boolean xoaNguoiDung(String username) {
        // xin quyen 1
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();

        // truy vấn 3
        long kq = sqLiteDatabase.delete("qLiND", "userName=?",
                new String[]{username});

        if (kq > 0) return true;
        else return false;

    }

    // get all

    public List<Quan_Li_Nguoi_Dung> getAllNguoiDung() {
        List<Quan_Li_Nguoi_Dung> quanLiNguoiDungList = new ArrayList<>();
        String sql = "SELECT * FROM qLiND";
        Cursor cursor = mySQLite.getReadableDatabase().rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String username = cursor.getString(0);
                String password = cursor.getString(1);
                String name = cursor.getString(2);
                String std = cursor.getString(3);
                String email = cursor.getString(4);

                Quan_Li_Nguoi_Dung quan_li_nguoi_dung = new Quan_Li_Nguoi_Dung();
                quan_li_nguoi_dung.userName = username;
                quan_li_nguoi_dung.matKhau = password;
                quan_li_nguoi_dung.tenND = name;
                quan_li_nguoi_dung.soDT = std;
                quan_li_nguoi_dung.Email = email;

                quanLiNguoiDungList.add(quan_li_nguoi_dung);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return quanLiNguoiDungList;
    }


//    public List<Quan_Li_Nguoi_Dung> timKiemNguoiDUng(String TimUsername) {
//        List<NguoiDung> nguoiDungList = new ArrayList<>();
//        String sql = "SELECT * FROM USER WHERE username LIKE '%" + TimUsername + "%'";
//        Cursor cursor = mySqliteYYY.getReadableDatabase().rawQuery(sql, null);
//        if (cursor.getCount() > 0) {
//            cursor.moveToFirst();
//            while (!cursor.isAfterLast()) {
//                String username = cursor.getString(0);
//                String name = cursor.getString(1);
//                String password = cursor.getString(2);
//                String std = cursor.getString(3);
//
//                NguoiDung nguoiDung = new NguoiDung();
//                nguoiDung.username = username;
//                nguoiDung.ten = name;
//                nguoiDung.password = password;
//                nguoiDung.sdt = std;
//
//                nguoiDungList.add(nguoiDung);
//                cursor.moveToNext();
//            }
//        }
//
//        return nguoiDungList;
//    }


}
