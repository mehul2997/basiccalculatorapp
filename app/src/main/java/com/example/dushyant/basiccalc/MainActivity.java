package com.example.dushyant.basiccalc;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    TextView res_text;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.edt1);
        num2 = findViewById(R.id.edt2);
        res_text = findViewById(R.id.resultText);
        linearLayout = findViewById(R.id.background);

    }

    public void caclFunction(View v) {
        if (TextUtils.isEmpty(num1.getText().toString())) {
            num1.setError("Enter Number 1....");
            return;
        }


        if (TextUtils.isEmpty(num2.getText().toString())) {
            num2.setError("Enter Number 2....");
            return;
        }


        String str1 = num1.getText().toString();
        Double double1 = Double.parseDouble(str1);

        String str2 = num2.getText().toString();
        Double double2 = Double.parseDouble(str2);

        switch (v.getId()) {
            case R.id.add:
                Double add = double1 + double2;
                res_text.setText("" + add);
                break;


            case R.id.minus:
                Double minus = double1 - double2;
                res_text.setText("" + minus);
                break;


            case R.id.multiply:
                Double multiply = double1 * double2;
                res_text.setText(""+multiply);
                break;


            case R.id.div:
                if (double2 == 0.0) {
                    Snackbar snackbar = Snackbar.make(linearLayout,"Divide by zero error",Snackbar.LENGTH_LONG);
                    snackbar.show();
                    Toast.makeText(MainActivity.this, "Divide by Zero error", Toast.LENGTH_LONG).show();

                } else {
                    Double div = double1 / double2;
                    res_text.setText("" + div);
                }
                break;


        }

    }

}