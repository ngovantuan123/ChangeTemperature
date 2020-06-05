package com.tuangh.changetemperature;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText edtC1;
    EditText edtF1;
    Button btnCtoF;
    Button btnFtoC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiFragment();
        btnCtoF=findViewById(R.id.btnFormDoiCquaF);
        btnFtoC=findViewById(R.id.btnFormDoiFQuaC);

        Button.OnClickListener doiFragmentonClick= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyChuyenForm(v);
            }
        };

        btnCtoF.setOnClickListener(doiFragmentonClick);
        btnFtoC.setOnClickListener(doiFragmentonClick);
    }
    public void xuLyChuyenForm(View view) {
        FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = null;

        switch (view.getId()) {
            case R.id.btnFormDoiCquaF:
                fragment = new DoiCquaF();
                break;
            case R.id.btnFormDoiFQuaC:
                fragment = new DoiFquaC();
                break;
        }
        fragmentTransaction.replace(R.id.frmContent, fragment);
        fragmentTransaction.commit();
    }
    private void intiFragment() {
        DoiCquaF doiCquaF = new DoiCquaF();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frmContent, doiCquaF);
        fragmentTransaction.commit();
    }




}
