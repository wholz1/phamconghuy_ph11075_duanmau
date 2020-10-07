package com.example.assignment.Fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.assignment.Adapter.NguoiDungAdapter;
import com.example.assignment.Database.MySQLite;
import com.example.assignment.Database.NguoiDungDAO;
import com.example.assignment.Model.Quan_Li_Nguoi_Dung;
import com.example.assignment.R;

import java.util.List;

public class Fragment_QlUser extends Fragment {
    public static ListView listViewDSND;
    Button btnThemND, btnQuayLai;
    MySQLite mySQLite;


    public Fragment_QlUser() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment__ql_user, container, false);
        listViewDSND = view.findViewById(R.id.lvDsND);
        btnThemND = view.findViewById(R.id.btnThemND);

        mySQLite = new MySQLite(getActivity());

        btnThemND.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogThemND();

            }
        });
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO(mySQLite);
        List<Quan_Li_Nguoi_Dung> quanLiNguoiDungList = nguoiDungDAO.getAllNguoiDung();
        NguoiDungAdapter nguoiDungAdapter = new NguoiDungAdapter(quanLiNguoiDungList, getActivity());
        listViewDSND.setAdapter(nguoiDungAdapter);
        return view;
    }

    private void DialogThemND() {

        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_themnd);
        dialog.setTitle("                " + "Thêm người dùng");
        final EditText edtUser = dialog.findViewById(R.id.edtUserName);
        final EditText edtPass = dialog.findViewById(R.id.editTextTextPassword);
        final EditText edtTenND = dialog.findViewById(R.id.edtName);
        final EditText edtSDT = dialog.findViewById(R.id.edtPhone);
        final EditText edtEmail = dialog.findViewById(R.id.edtEmail);

        btnThemND = dialog.findViewById(R.id.btnThemND);
        btnQuayLai = dialog.findViewById(R.id.btnQuayLai);
        btnThemND.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quan_Li_Nguoi_Dung quan_li_nguoi_dung = new Quan_Li_Nguoi_Dung();
//                quan_li_nguoi_dung.userName = edtUser.getText().toString().trim();
//                quan_li_nguoi_dung.matKhau = edtPass.getText().toString().trim();
//                quan_li_nguoi_dung.tenND = edtTenND.getText().toString().trim();
//                quan_li_nguoi_dung.soDT = edtSDT.getText().toString().trim();
//                quan_li_nguoi_dung.Email = edtEmail.getText().toString().trim();
                quan_li_nguoi_dung.setUserName(edtUser.getText().toString().trim());
                quan_li_nguoi_dung.setMatKhau(edtPass.getText().toString().trim());
                quan_li_nguoi_dung.setTenND(edtTenND.getText().toString().trim());
                quan_li_nguoi_dung.setSoDT(edtSDT.getText().toString().trim());
                quan_li_nguoi_dung.setEmail(edtEmail.getText().toString().trim());

                checkEmpty(quan_li_nguoi_dung.getUserName(), edtUser);
                checkEmpty(quan_li_nguoi_dung.getMatKhau(), edtPass);
                checkEmpty(quan_li_nguoi_dung.getTenND(), edtTenND);
                checkEmpty(quan_li_nguoi_dung.getSoDT(), edtSDT);
                checkEmpty(quan_li_nguoi_dung.getEmail(), edtEmail);

                NguoiDungDAO nguoiDungDAO = new NguoiDungDAO(mySQLite);
                boolean ketQua = nguoiDungDAO.themNguoiDung(quan_li_nguoi_dung);
                if (ketQua) {

                    Toast.makeText(getActivity(), "THANH CONG!!!", Toast.LENGTH_SHORT).show();

                    List<Quan_Li_Nguoi_Dung> quanLiNguoiDungList = nguoiDungDAO.getAllNguoiDung();
                    NguoiDungAdapter nguoiDungAdapter = new NguoiDungAdapter(quanLiNguoiDungList, getActivity());
                    listViewDSND.setAdapter(nguoiDungAdapter);

                    dialog.dismiss();
                } else {
                    Toast.makeText(getActivity(), "KHONG THANH CONG!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void checkEmpty(String data, EditText edt) {
        if (data.isEmpty()) {
            edt.setError("Nhap du thong tin...");
            return;
        }
    }

}