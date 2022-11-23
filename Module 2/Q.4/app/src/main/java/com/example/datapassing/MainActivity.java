package com.example.datapassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    EditText E1,E2,E3;
    Button okbtn;
    TextView textView;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       textView = findViewById(R.id.age_id);
       seekBar = findViewById(R.id.seekbar_id);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView.setText("Age : "+String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        E1 = findViewById(R.id.name_edittext);
        E2 = findViewById(R.id.PhoneN_edittext);
        E3 = findViewById(R.id.Email_edittext);

        okbtn = findViewById(R.id.okbtn_id);

        okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = E1.getText().toString();
                String phone = E2.getText().toString();
                String email = E3.getText().toString();
                String Age = textView.getText().toString();

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("fast_Name",name);
                intent.putExtra("p_number",phone);
                intent.putExtra("E_address",email);
                intent.putExtra("S_age",Age);
                startActivity(intent);
            }
        });
    }
}