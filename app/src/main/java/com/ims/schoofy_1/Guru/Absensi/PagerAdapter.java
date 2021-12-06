package com.ims.schoofy_1.Guru.Absensi;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.ims.schoofy_1.Guru.Home.Mapel.Mapel_guru;
import com.ims.schoofy_1.Guru.Home.Wali_kelas.Wali_kelas;


public class PagerAdapter extends FragmentStatePagerAdapter {

    private int number_tabs;

    public PagerAdapter(FragmentManager fm, int number_tabs) {
        super(fm);
        this.number_tabs = number_tabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Mapel_guru();
            case 1:
                return new Wali_kelas();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return number_tabs;
    }

}