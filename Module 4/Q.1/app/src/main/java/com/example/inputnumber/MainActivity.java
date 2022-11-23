package com.example.inputnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

//Create an application to take input number from user and print its reverse
//        number in TextView without button.
public class MainActivity extends AppCompatActivity {

    MaterialTextView textView;
    TextInputEditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textV_id);
        editText = findViewById(R.id.edittext_id);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                char c;
                String result = "";

                String number = editText.getText().toString();

                for (i=0 ;i<number.length();i++){
                    c = number.charAt(i);
                    result = c + result;
                }
                textView.setText("User Number - "+result);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        editText.addTextChangedListener(textWatcher);
    }
}