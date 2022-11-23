package com.example.englishdictionary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    EditText getword, getmeaning;
    MaterialTextView ok, cancel;
    RecyclerView recyclerView;
    ArrayList<modal> list;
    ArrayList<modal> searchlist;
    mydbhelper db;
    android.widget.SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toobar_id);
        toolbar.setTitle("Dictionary");
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recyclerV_id);
        searchView = findViewById(R.id.searchV_id);
        searchView.clearFocus();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = new mydbhelper(this);
        Cursor cursor = db.getdata();
        list = new ArrayList<>();

        while (cursor.moveToNext()) {

            modal modal = new modal(cursor.getString(1), cursor.getString(2));
            list.add(modal);
        }

        myadapter myadapter = new myadapter(list);
        recyclerView.setAdapter(myadapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        new MenuInflater(this).inflate(R.menu.menu_item, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addword_id: {
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.addword_alertdialog, null);
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).setView(view).create();
                dialog.show();

                db = new mydbhelper(this);
                getword = view.findViewById(R.id.getword_id);
                getmeaning = view.findViewById(R.id.getmeaning_id);
                ok = view.findViewById(R.id.okbtn_id);
                cancel = view.findViewById(R.id.cencelbtn_id);

                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String word = getword.getText().toString();
                        String meaning = getmeaning.getText().toString();

                        if (word.isEmpty() || meaning.isEmpty()) {
                            Toast.makeText(MainActivity.this, "Fill the field", Toast.LENGTH_SHORT).show();
                        } else {

                            boolean i = db.insertdata(word, meaning);
                            if (i == true) {

                                Toast.makeText(MainActivity.this, "Data add", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity.this,MainActivity.class));
                                finish();
                            } else {

                                Toast.makeText(MainActivity.this, "no data", Toast.LENGTH_SHORT).show();
                            }

                        }
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this,MainActivity.class));
                    }
                });

            }
            case R.id.history_id: {

//                String word = getword.getText().toString();
//                String meaning = getmeaning.getText().toString();
//
//                db = new mydbhelper(MainActivity.this);
//                boolean i = db.deletedata(word,meaning);
//                if (i==true){
//                    Toast.makeText(this, "detele data", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(this, "no", Toast.LENGTH_SHORT).show();
//                }

            }
            case R.id.settings_id: {

            }
        }
        return super.onOptionsItemSelected(item);
    }

}