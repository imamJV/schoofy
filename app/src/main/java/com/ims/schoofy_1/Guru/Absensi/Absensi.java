package com.ims.schoofy_1.Guru.Absensi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.ims.schoofy_1.R;

public class Absensi extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    PagerAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_absensi, container, false);
        tabLayout               = view.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Karyawan"));
        tabLayout.addTab(tabLayout.newTab().setText("Pembeli"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager      = view.findViewById(R.id.pager);
        adapter        = new PagerAdapter(getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }
}