package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button redbtn,bluebtn;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        redbtn = findViewById(R.id.redBtn_id);
        bluebtn = findViewById(R.id.blueBtn_id);
        linearLayout =findViewById(R.id.layout_id);

        redbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            linearLayout.setBackgroundResource(R.color.Red);
            }
        });

        bluebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                linearLayout.setBackgroundResource(R.color.Blue);
            }
        });
    }
}