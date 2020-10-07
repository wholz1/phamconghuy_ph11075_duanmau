package com.example.assignment.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.assignment.DanhSHDActivity2;
import com.example.assignment.R;
import com.example.assignment.TaoHDActivity2;


public class Fragment_QlHoaDon extends Fragment {
    ImageView imageViewTaoHD, imageViewDSHD;

    public Fragment_QlHoaDon() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__ql_hoa_don, container, false);
        imageViewTaoHD = view.findViewById(R.id.imageViewTaoHD);
        imageViewTaoHD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TaoHDActivity2.class);
                startActivity(intent);
            }
        });
        imageViewDSHD = view.findViewById(R.id.imageViewDSHoaDon);
        imageViewDSHD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DanhSHDActivity2.class);
                startActivity(intent);
            }
        });
        return view;
    }
}