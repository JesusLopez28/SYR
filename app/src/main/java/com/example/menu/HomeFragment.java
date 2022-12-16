package com.example.menu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment {

    Button verUno, verDos, verTres, siguiente;
    private String urlUno = "https://semadet.jalisco.gob.mx/prensa/noticia/1684";
    private String urlDos = "https://semadet.jalisco.gob.mx/prensa/noticia/1661";
    private String urlTres = "https://semadet.jalisco.gob.mx/prensa/noticia/1654";

    public HomeFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Bundle args = new Bundle();
        verUno = (Button) view.findViewById(R.id.btn_verUno);
        verDos = (Button) view.findViewById(R.id.btn_verDos);
        verTres = (Button) view.findViewById(R.id.btn_verTres);
        siguiente = (Button) view.findViewById(R.id.siguienteNoticias);

        verUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri link = Uri.parse(urlUno);
                Intent i = new Intent(Intent.ACTION_VIEW,link);
                startActivity(i);
            }
        });

        verDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri link = Uri.parse(urlDos);
                Intent i = new Intent(Intent.ACTION_VIEW,link);
                startActivity(i);
            }
        });

        verTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri link = Uri.parse(urlTres);
                Intent i = new Intent(Intent.ACTION_VIEW,link);
                startActivity(i);
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NoticiasFragment fr = new NoticiasFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fr).commit();
            }
        });

        return view;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false);
    }
}