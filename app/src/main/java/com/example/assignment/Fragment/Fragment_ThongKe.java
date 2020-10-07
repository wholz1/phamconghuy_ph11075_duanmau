package com.example.assignment.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.assignment.R;
import com.example.assignment.ViewPagerEEE;
import com.google.android.material.tabs.TabLayout;


public class Fragment_ThongKe extends Fragment {
    public ViewPager viewPager;
    public ViewPagerEEE viewPagerEEE;
    public TabLayout tabLayoutPh11075;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__thong_ke, container, false);
        viewPager = view.findViewById(R.id.viewPagerPH11075);
        tabLayoutPh11075 = view.findViewById(R.id.tabLayoutPH11075);
        tabLayoutPh11075.setupWithViewPager(viewPager);
        addTab(viewPager);

        return view;
    }

    public void addTab(ViewPager viewPager) {
        viewPagerEEE = new ViewPagerEEE(getChildFragmentManager());
        viewPagerEEE.addFrag(new FragmentTKBanChay(), "Thống kê sản phẩm.");
        viewPagerEEE.addFrag(new FragmentBanIt(), "Cái gì đó.");
        viewPager.setAdapter(viewPagerEEE);
    }


}