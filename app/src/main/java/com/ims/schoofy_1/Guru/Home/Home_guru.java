package com.ims.schoofy_1.Guru.Home;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ims.schoofy_1.Guru.Home.Mapel.Mapel_guru;
import com.ims.schoofy_1.Guru.Home.Wali_kelas.Wali_kelas;
import com.ims.schoofy_1.R;

public class Home_guru extends Fragment {

    Button walikelas, gurumapel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home_guru, container, false);

        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, new Mapel_guru());
        ft.commit();

        walikelas       = view.findViewById(R.id.walikelas);
        gurumapel       = view.findViewById(R.id.gurumapel);

        view.findViewById(R.id.walikelas).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame_layout, new Mapel_guru());
                ft.commit();
                Toast.makeText(getContext(), "walikelas", Toast.LENGTH_SHORT).show();
                gurumapel.setBackground(getResources().getDrawable(R.drawable.btn_rounded_kiri));
            }
        });

        view.findViewById(R.id.gurumapel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame_layout, new Wali_kelas());
                ft.commit();
                Toast.makeText(getContext(), "gurumapel", Toast.LENGTH_SHORT).show();
                walikelas.setBackground(getResources().getDrawable(R.drawable.btn_rounded_kanan));
            }
        });

        return view;
    }

}