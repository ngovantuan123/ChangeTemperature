package com.tuangh.changetemperature;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.regex.Pattern;

public class DoiCquaF extends Fragment {
    EditText edtC;
    EditText edtF;
    Button btnChuyenDoiCtoF;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.ctof , container , false);
        edtC=v.findViewById(R.id.edtC1);
        edtF=v.findViewById(R.id.edtF1);
        btnChuyenDoiCtoF=v.findViewById(R.id.btnChuyenDoiCtoF);
        btnChuyenDoiCtoF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doiNhietDoCF();
            }
        });



        return v;
    }
    public void doiNhietDoCF() {
        if (Pattern.matches("(^\\d+$)|(^-\\d+$)", edtC.getText().toString())){
            double c1 = Double.parseDouble(edtC.getText().toString());
            double f1 = c1*1.8+32;
            edtF.setText(Double.toString(f1));
        }
        else {
            Toast.makeText(getActivity(), "Vui lòng nhập gia trị!", Toast.LENGTH_SHORT).show();
        }
    }
}
