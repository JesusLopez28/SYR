package com.example.menu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class NoticiasFragment extends Fragment {
    Button verCuatro, verCinco, verSeis;
    Button atrasNoticias;
    private String urlCuatro = "https://semadet.jalisco.gob.mx/prensa/noticia/1628";
    private String urlCinco = "https://semadet.jalisco.gob.mx/prensa/noticia/1624";
    private String urlSeis = "https://semadet.jalisco.gob.mx/prensa/noticia/1620";

    public NoticiasFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_noticias, container, false);

        atrasNoticias = view.findViewById(R.id.atrasNoticas);
        atrasNoticias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeFragment fr = new HomeFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fr).commit();
            }
        });

        verCuatro = (Button) view.findViewById(R.id.btn_verCuatro);
        verCinco = (Button) view.findViewById(R.id.btn_verCinco);
        verSeis = (Button) view.findViewById(R.id.btn_verSeis);

        verCuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri link = Uri.parse(urlCuatro);
                Intent i = new Intent(Intent.ACTION_VIEW,link);
                startActivity(i);
            }
        });

        verCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri link = Uri.parse(urlCinco);
                Intent i = new Intent(Intent.ACTION_VIEW,link);
                startActivity(i);
            }
        });

        verSeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri link = Uri.parse(urlSeis);
                Intent i = new Intent(Intent.ACTION_VIEW,link);
                startActivity(i);
            }
        });
        return view;
    }
}