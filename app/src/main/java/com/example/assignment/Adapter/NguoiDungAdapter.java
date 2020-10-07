package com.example.assignment.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment.Database.MySQLite;
import com.example.assignment.Database.NguoiDungDAO;
import com.example.assignment.Fragment.Fragment_QlUser;
import com.example.assignment.Model.Quan_Li_Nguoi_Dung;
import com.example.assignment.R;

import java.util.List;

public class NguoiDungAdapter extends BaseAdapter {
    private Context context;
    private List<Quan_Li_Nguoi_Dung> quanLiNguoiDungList;

    public NguoiDungAdapter(List<Quan_Li_Nguoi_Dung> quanLiNguoiDungList, Context context) {
        this.context = context;
        this.quanLiNguoiDungList = quanLiNguoiDungList;
    }

    @Override
    public int getCount() {
        return quanLiNguoiDungList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, final ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nguoi_dung,
                viewGroup, false);

        TextView tvName = view.findViewById(R.id.tvTenND);

        tvName.setText("Tài khoản người dùng: " + quanLiNguoiDungList.get(i).userName + "\n" + "Tên người dùng: " + quanLiNguoiDungList.get(i).tenND
                + "\n" + "Số điện thoại: " + quanLiNguoiDungList.get(i).soDT + "\nEmail: " + quanLiNguoiDungList.get(i).Email);


        view.findViewById(R.id.imgXoa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NguoiDungDAO nguoiDungDAO = new NguoiDungDAO(new MySQLite(viewGroup.getContext()));
                String userName = quanLiNguoiDungList.get(i).userName;
                boolean ketQua = nguoiDungDAO.xoaNguoiDung(userName);
                if (ketQua) {
                    Toast.makeText(viewGroup.getContext(), "Xoa Thanh Cong!!!",
                            Toast.LENGTH_SHORT).show();

                    quanLiNguoiDungList.remove(i);
                    notifyDataSetChanged();

                } else {
                    Toast.makeText(viewGroup.getContext(), "Xoa KHONG Thanh Cong!!!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        view.findViewById(R.id.imgSua).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View view1 = LayoutInflater.from(context).inflate(R.layout.dialog_suand, null);
                builder.setCancelable(false);
                builder.setTitle("                "+"Sửa người dùng");
                builder.setView(view1);
                Button btnCancelNguoiDung = view1.findViewById(R.id.btnQuayLaiSua);
                Button btnSuaNguoiDung = view1.findViewById(R.id.btnThemNDSua);

                final EditText edtSuaPass = view1.findViewById(R.id.editTextTextPasswordSua);
                final EditText edtSuaTenND = view1.findViewById(R.id.edtNameSua);
                final EditText edtSuaPhone = view1.findViewById(R.id.edtPhoneSua);
                final EditText edtSuaEmail = view1.findViewById(R.id.edtEmailSua);
                final AlertDialog alertDialog = builder.show();
                btnSuaNguoiDung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Quan_Li_Nguoi_Dung quan_li_nguoi_dung = new Quan_Li_Nguoi_Dung();
                        quan_li_nguoi_dung.setUserName(quanLiNguoiDungList.get(i).userName);
                        quan_li_nguoi_dung.setMatKhau(edtSuaPass.getText().toString().trim());
                        quan_li_nguoi_dung.setTenND(edtSuaTenND.getText().toString().trim());
                        quan_li_nguoi_dung.setSoDT(edtSuaPhone.getText().toString().trim());
                        quan_li_nguoi_dung.setEmail(edtSuaEmail.getText().toString().trim());
                        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO(new MySQLite(viewGroup.getContext()));
                        boolean ketQua = nguoiDungDAO.suaNguoiDung(quan_li_nguoi_dung);
                        if (ketQua) {
                            Toast.makeText(viewGroup.getContext(), "Sửa thành công !!!", Toast.LENGTH_SHORT).show();

                            List<Quan_Li_Nguoi_Dung> quanLiNguoiDungList = nguoiDungDAO.getAllNguoiDung();
                            NguoiDungAdapter nguoiDungAdapter = new NguoiDungAdapter(quanLiNguoiDungList, context);
                            Fragment_QlUser.listViewDSND.setAdapter(nguoiDungAdapter);
                        } else {
                            Toast.makeText(viewGroup.getContext(), "Sửa không thành công", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                btnCancelNguoiDung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
            }
        });
        return view;
    }
}
