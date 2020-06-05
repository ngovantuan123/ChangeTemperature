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

public class DoiFquaC extends Fragment {
    EditText edtC;
    EditText edtF;
    Button btnChuyenDoiFtoC;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.ftoc , container , false);
        edtF=v.findViewById(R.id.edtF);
        edtC=v.findViewById(R.id.edtC);

        btnChuyenDoiFtoC=v.findViewById(R.id.btnChuyenDoiFtoC);
        btnChuyenDoiFtoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doiNhietDoFC();
            }
        });



        return v;
    }
    public void doiNhietDoFC() {
        if (Pattern.matches("(^\\d+$)|(^-\\d+$)", edtF.getText().toString())){
            double f1 = Double.parseDouble(edtF.getText().toString());
            double c1 = (f1-32)/1.8;
            edtC.setText(Double.toString(c1));
        }
        else {
            Toast.makeText(getActivity(), "Vui lòng nhập giá trị!", Toast.LENGTH_SHORT).show();
        }
    }
}
