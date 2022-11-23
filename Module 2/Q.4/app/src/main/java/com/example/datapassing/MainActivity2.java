package com.example.datapassing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.textview.MaterialTextView;

public class MainActivity2 extends AppCompatActivity {

    TextView t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        t1 =findViewById(R.id.textv_1);
        t2 = findViewById(R.id.textv_2);
        t3 = findViewById(R.id.textv_3);
        t4 = findViewById(R.id.textv_4);

        String Name = getIntent().getStringExtra("fast_Name");
        String PhoneN = getIntent().getStringExtra("p_number");
        String EmailA = getIntent().getStringExtra("E_address");
        String Age = getIntent().getStringExtra("S_age");

        t1.setText(Name);
        t2.setText(PhoneN);
        t3.setText(EmailA);
        t4.setText(Age);

    }
}