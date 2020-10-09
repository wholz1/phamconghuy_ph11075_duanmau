package com.example.assignment.Fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.assignment.Adapter.SachAdapter;
import com.example.assignment.Database.MySQLite;
import com.example.assignment.Database.SachDAO;
import com.example.assignment.Model.Sach;
import com.example.assignment.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;
import java.util.List;


public class Fragment_nhapSach extends Fragment {
    Button btnThemSach;
    MySQLite mySQLite;
    Fragment_QlSachTK fragment_qlSachTK;

    public Fragment_nhapSach() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nhap_sach, container, false);
        mySQLite = new MySQLite(getActivity());
        final TextInputLayout textInputLayoutMaSach = view.findViewById(R.id.inputMaSach);
        final TextInputLayout textInputLayoutTenSach = view.findViewById(R.id.inputTenSach);
        final TextInputLayout textInputLayoutGiaBan = view.findViewById(R.id.inputGiaBan);
        final TextInputLayout textInputLayoutTacGia = view.findViewById(R.id.inputTacGia);
        final TextInputLayout textInputLayoutNhaXB = view.findViewById(R.id.inputNhaXB);
        final TextInputLayout textInputLayoutTheLoai = view.findViewById(R.id.inputTheLoai);
        final TextInputLayout textInputLayoutSoLuong = view.findViewById(R.id.inputSoLuong);
        final TextInputLayout textInputLayoutNgayNhap = view.findViewById(R.id.inputNgayNhap);
        Calendar calendar = Calendar.getInstance();
        final int y = calendar.get(Calendar.YEAR);
        final int m = calendar.get(Calendar.MONTH);
        final int d = calendar.get(Calendar.DAY_OF_MONTH);
        textInputLayoutNgayNhap.getEditText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        textInputLayoutNgayNhap.getEditText().setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, y, m, d);
                datePickerDialog.show();
            }
        });
        btnThemSach = view.findViewById(R.id.btnNhapSach);
        btnThemSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sach sach = new Sach();
                sach.maSach = textInputLayoutMaSach.getEditText().getText().toString().trim();
                sach.tenSach = textInputLayoutTenSach.getEditText().getText().toString().trim();
                sach.giaSach = textInputLayoutGiaBan.getEditText().getText().toString().trim();
                sach.tacGia = textInputLayoutTacGia.getEditText().getText().toString().trim();
                sach.nhaXB = textInputLayoutNhaXB.getEditText().getText().toString().trim();
                sach.theLoai = textInputLayoutTheLoai.getEditText().getText().toString().trim();
                sach.soLuong = textInputLayoutSoLuong.getEditText().getText().toString().trim();
                sach.ngayNhap = textInputLayoutNgayNhap.getEditText().getText().toString().trim();

                SachDAO sachDAO = new SachDAO(mySQLite);
                boolean ketQua = sachDAO.themSach(sach);
                if (ketQua) {
                    Toast.makeText(getActivity(), "THANH CONG!!!", Toast.LENGTH_SHORT).show();

                    List<Sach> sachList = sachDAO.getAllSach();
                    SachAdapter sachAdapter = new SachAdapter(sachList, getActivity());
                    fragment_qlSachTK.listViewDSNS.setAdapter(sachAdapter);
                } else {
                    Toast.makeText(getActivity(), "KHONG THANH CONG!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}