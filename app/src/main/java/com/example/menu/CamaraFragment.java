package com.example.menu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class CamaraFragment extends Fragment {
    Button btn_q, btn_l;
    TextView l;
    String url;

    public CamaraFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_camara, container, false);
        l = view.findViewById(R.id.link);
        btn_q = (Button) view.findViewById(R.id.qr_button);
        btn_l = (Button) view.findViewById(R.id.link_button);

        btn_q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                escanear();
            }
        });

        btn_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        return view;
    }

    public void escanear(){
        IntentIntegrator intent = IntentIntegrator.forSupportFragment(CamaraFragment.this);
        intent.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        intent.setPrompt("ESCANEAR CODIGO QR");
        intent.setCameraId(0);
        intent.setBeepEnabled(false);
        intent.setBarcodeImageEnabled(false);
        intent.initiateScan();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        String res = result.getContents().toString();
        url = result.getContents().toString();
        SpannableString mitextoU = new SpannableString(res);
        mitextoU.setSpan(new UnderlineSpan(), 0, mitextoU.length(), 0);

        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(getContext(), "Cancelaste el escaneo", Toast.LENGTH_SHORT).show();
            } else {
                l.setText(mitextoU);
                habilitarBtn();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void habilitarBtn() {
        btn_l.setEnabled(true);
    }


}