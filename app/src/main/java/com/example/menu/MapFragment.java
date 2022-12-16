package com.example.menu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapFragment extends Fragment implements OnMapReadyCallback{

    public MapFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView =  inflater.inflate(R.layout.fragment_map, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapita);
        mapFragment.getMapAsync(this);
        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng colomos = new LatLng(20.707777777778, -103.39288888889);
        LatLng centinela = new LatLng(20.76700603972469,	-103.38028999384125);
        LatLng primavera = new LatLng(20.633125, -103.559825);
        LatLng barranca = new LatLng(20.706752, -103.275865);
        LatLng reina = new LatLng(20.634347, -103.240201);
        LatLng colima = new LatLng(19.573337, -103.627933);
        LatLng chupinaya = new LatLng(20.324835, -103.274817);
        LatLng canales = new LatLng(20.406531, -102.549798);
        LatLng chiquihuitillo  = new LatLng(20.340817, -102.830157);
        LatLng rio  = new LatLng(20.542431, -103.166521);

        googleMap.addMarker(new MarkerOptions().position(colomos).title("Bosque de Los Colomos"));
        googleMap.addMarker(new MarkerOptions().position(centinela).title("Bosque el Centinela"));
        googleMap.addMarker(new MarkerOptions().position(primavera).title("Bosque de la primavera"));
        googleMap.addMarker(new MarkerOptions().position(barranca).title("Barranca de Huentitán"));
        googleMap.addMarker(new MarkerOptions().position(reina).title("Cerro de la reina"));
        googleMap.addMarker(new MarkerOptions().position(colima).title("Parque Nacional Nevado de Colima"));
        googleMap.addMarker(new MarkerOptions().position(chupinaya).title("La Chupinaya"));
        googleMap.addMarker(new MarkerOptions().position(canales).title("Sierra Cóndiro-Canales"));
        googleMap.addMarker(new MarkerOptions().position(chiquihuitillo).title("Cerro Chiquihuitillo"));
        googleMap.addMarker(new MarkerOptions().position(rio).title("Barrancas de los Ríos Santiago y Verde"));

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(colomos, 7.1f));
    }
}