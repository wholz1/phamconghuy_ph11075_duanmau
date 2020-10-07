package com.example.assignment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment.Database.MySQLite;
import com.example.assignment.Database.SachDAO;
import com.example.assignment.Model.Sach;
import com.example.assignment.R;

import java.util.List;

public class SachAdapter extends BaseAdapter {
    private List<Sach> sachList;
    private Context context;

    public SachAdapter(List<Sach> sachList, Context context) {
        this.sachList = sachList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return sachList.size();
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
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ds_sach,
                viewGroup, false);

        TextView tvSach = view.findViewById(R.id.tvTenSach);

        tvSach.setText(sachList.get(i).maSach);

        view.findViewById(R.id.imgXoaSach).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SachDAO sachDAO = new SachDAO(new MySQLite(viewGroup.getContext()));
                String maSach = sachList.get(i).maSach;
                boolean ketQua = sachDAO.xoaSach(maSach);
                if (ketQua) {
                    Toast.makeText(viewGroup.getContext(), "Xoa Thanh Cong!!!",
                            Toast.LENGTH_SHORT).show();

                    sachList.remove(i);
                    notifyDataSetChanged();

                } else {
                    Toast.makeText(viewGroup.getContext(), "Xoa KHÔNG Thanh Cong!!!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
