package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton redbtn,bluebtn,orangebtn,blackbtn;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.linearlayout_id);
        radioGroup = findViewById(R.id.radiogroup_id);
        redbtn = findViewById(R.id.redbtn_id);
        bluebtn = findViewById(R.id.bluebtn_id);
        orangebtn = findViewById(R.id.orangebtn_id);
        blackbtn = findViewById(R.id.blackbtn_id);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){

                    case R.id.redbtn_id:
                    {
                        layout.setBackgroundColor(Color.RED);
                        break;
                    }
                    case R.id.bluebtn_id:
                    {
                        layout.setBackgroundColor(Color.BLUE);
                        break;
                    }
                    case R.id.orangebtn_id:
                    {
                        layout.setBackgroundColor(R.color.orange);
                        break;
                    }
                    case R.id.blackbtn_id:
                    {
                        layout.setBackgroundColor(Color.BLACK);
                        break;
                    }
                }
            }
        });
    }
}