package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
//    ArrayList<String> arrayList = new ArrayList<>();
    String[] name = new String[]{"lalit","gaurav","nirav","jaynik","subham","rajan","rakesh",
            "lalit","gaurav","nirav","jaynik","subham","rajan","rakesh","lalit","gaurav","nirav","jaynik","subham","rajan","rakesh",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview_id);

//        arrayList.add("lalit");
//        arrayList.add("gaurav");
//        arrayList.add("nirav");
//        arrayList.add("jaynik");
//        arrayList.add("subham");
//        arrayList.add("rajan");
//        arrayList.add("Dhruve");
//        arrayList.add("rakesh");
//        arrayList.add("bhim");
//        arrayList.add("pintu");
//        arrayList.add("prahlad");
//        arrayList.add("lalit");
//        arrayList.add("gaurav");
//        arrayList.add("nirav");
//        arrayList.add("jaynik");
//        arrayList.add("subham");
//        arrayList.add("rajan");
//        arrayList.add("Dhruve");
//        arrayList.add("rakesh");
//        arrayList.add("bhim");
//        arrayList.add("pintu");
//        arrayList.add("prahlad");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,name);
        listView.setAdapter(adapter);

    }
}