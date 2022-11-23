package com.example.q2application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton addition,subtraction,multiplication,division;
    TextInputEditText num1,num2;
    MaterialTextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radiogroup_id);
        addition = findViewById(R.id.addition_id);
        subtraction = findViewById(R.id.subtraction_id);
        multiplication = findViewById(R.id.multiplication_id);
        division = findViewById(R.id.division_id);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        textView = findViewById(R.id.textV_id);
        String n1 = num1.getText().toString();
        String n2 = num2.getText().toString();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                String n1 = num1.getText().toString();
                String n2 = num2.getText().toString();

                int N1 = Integer.parseInt(n1);
                int N2 = Integer.parseInt(n2);

                String result = null;

                switch (i)
                {
                    case R.id.addition_id:
                        result = String.valueOf(N1+N2);
                        textView.setText("Result = "+result);
                        break;

                    case R.id.subtraction_id:
                        result = String.valueOf(N1-N2);
                        textView.setText("Result = "+result);
                        break;

                    case R.id.multiplication_id:
                        result = String.valueOf(N1*N2);
                        textView.setText("Result = "+result);
                        break;

                    case R.id.division_id:
                        if (N1>N2) {
                            result = String.valueOf((double) N1 / (double) N2);
                            textView.setText("Result = "+result);
                        }else {
                            result = String.valueOf(N1/N2);
                            textView.setText("Not divided "+result);
                        }
                        break;
                }


            }
        });
    }
}