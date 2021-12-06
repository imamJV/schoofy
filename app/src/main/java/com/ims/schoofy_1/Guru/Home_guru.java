package com.ims.schoofy_1.Guru;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ims.schoofy_1.Guru.Absensi.Absensi;
import com.ims.schoofy_1.Guru.Informasi.Informasi;
import com.ims.schoofy_1.Guru.Profil.Profile;
import com.ims.schoofy_1.Guru.Tugas.Tugas_guru;
import com.ims.schoofy_1.Ortu.Tagihan.Tagihan;
import com.ims.schoofy_1.R;

public class Home_guru extends AppCompatActivity {

    private static final String TAG = Home_guru.class.getSimpleName();
    private BottomNavigationView bottomNavigation;
    private Fragment fragment;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_guru);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        getSupportActionBar().hide();
        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigation.inflateMenu(R.menu.bottom_nav_guru);
        fragmentManager = getSupportFragmentManager();


        //Untuk inisialisasi fragment pertama kali
        fragmentManager.beginTransaction().replace(R.id.main_container, new Absensi()).commit();

        //Memberikan listener saat menu item di bottom navigation diklik
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.presensi:
                        fragment = new Absensi();
                        break;
                    case R.id.tugas:
                        fragment = new Tugas_guru();
                        break;
                    case R.id.home:
                        fragment = new com.ims.schoofy_1.Guru.Home.Home_guru();
                        break;
                    case R.id.informasi:
                        fragment = new Informasi();
                        break;
                    case R.id.profil:
                        fragment = new Profile();
                        break;
                }

                final FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_container, fragment).commit();
                return true;
            }
        });
    }
}