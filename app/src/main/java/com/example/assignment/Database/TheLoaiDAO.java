package com.example.assignment.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.assignment.Model.The_Loai;

import java.util.ArrayList;
import java.util.List;

public class TheLoaiDAO {

    private MySQLite mySQLite;

    public TheLoaiDAO(MySQLite mySQLite) {
        this.mySQLite = mySQLite;
    }

    public void xoaTheLoai(String id) {
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        sqLiteDatabase.delete("qliTL", "maTheLoai=?", new String[]{id});
    }

    public long themTheLoai(The_Loai the_loai) {
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("maTheLoai", the_loai.getMaTheLoai());
        contentValues.put("tenTheLoai", the_loai.getTenTheLoai());

        return sqLiteDatabase.insert("qliS", null, contentValues);
    }

    public List<The_Loai> getAllTheLoai() {
        List<The_Loai> theLoaiList = new ArrayList<>();
        String truyVan = "SELECT * FROM qliS";
        Cursor cursor = mySQLite.getWritableDatabase().rawQuery(truyVan, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                String maTheLoai = cursor.getString(cursor.getColumnIndex("maTheLoai"));
                String tenTheLoai = cursor.getString(cursor.getColumnIndex("tenTheLoai"));

                The_Loai the_loai = new The_Loai();
                the_loai.setMaTheLoai(maTheLoai);
                the_loai.setTenTheLoai(tenTheLoai);

                theLoaiList.add(the_loai);

                cursor.moveToNext();
            }
            cursor.close();
        }
        return theLoaiList;
    }

    public int suaTheLoai(The_Loai the_loai) {
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("maTheLoai", the_loai.getMaTheLoai());
        contentValues.put("tenTheLoai", the_loai.getTenTheLoai());

        return sqLiteDatabase.update("qliKH", contentValues,
                "maTheLoai=?", new String[]{the_loai.getMaTheLoai()});
    }
}


