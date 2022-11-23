package com.example.englishdictionary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class myadapter extends RecyclerView.Adapter<myadapter.myview_holder> {

    ArrayList<modal> list;
    public myadapter(ArrayList<modal> list) {
        this.list = list;
    }

    public myview_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_row,parent,false);

        return new myview_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myview_holder holder, int position) {
      holder.t1.setText(list.get(position).getWord());
      holder.t2.setText(list.get(position).getMeaning());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myview_holder extends RecyclerView.ViewHolder{

        MaterialTextView t1,t2;

        public myview_holder(@NonNull View itemView) {
            super(itemView);
            t1 =itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);
        }
    }
}
