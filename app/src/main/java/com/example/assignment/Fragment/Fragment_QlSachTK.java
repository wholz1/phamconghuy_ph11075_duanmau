package com.example.assignment.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.assignment.Adapter.SachAdapter;
import com.example.assignment.Database.MySQLite;
import com.example.assignment.Database.SachDAO;
import com.example.assignment.Model.Sach;
import com.example.assignment.R;

import java.util.List;

public class Fragment_QlSachTK extends Fragment {
    public static ListView listViewDSNS;
    public MySQLite mySQLite;

    public Fragment_QlSachTK() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__ql_sach_t_k, container, false);
        listViewDSNS = view.findViewById(R.id.lvDSNhapSach);
        mySQLite = new MySQLite(getActivity());
        SachDAO sachDAO = new SachDAO(mySQLite);
        List<Sach> sachList = sachDAO.getAllSach();
        SachAdapter sachAdapter = new SachAdapter(sachList, getActivity());
        listViewDSNS.setAdapter(sachAdapter);
        return view;
    }
}