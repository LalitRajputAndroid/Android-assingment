package com.example.englishdictionary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class myadapter extends RecyclerView.Adapter<myadapter.myview_holder> implements Filterable {

    ArrayList<modal> list;
    ArrayList<modal> bekup;

    public myadapter(ArrayList<modal> list) {
        this.list = list;
        bekup = new ArrayList<>(list);
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

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence Sequence) {

            ArrayList<modal> filtereddata = new ArrayList<>();

            if (Sequence.toString().isEmpty()){
                filtereddata.addAll(bekup);

            }else {
                for (modal obj : bekup){
                    if (obj.getWord().toString().toLowerCase().contains(Sequence.toString().toLowerCase()));

                    filtereddata.add(obj);
                }
            }
            FilterResults results = new FilterResults();
            results.values = filtereddata;
            return results;
        }

        @Override
        protected void publishResults(CharSequence Sequence, FilterResults results) {

            list.clear();
            list.addAll((ArrayList<modal>)results.values);
            notifyDataSetChanged();
        }
    };

    public class myview_holder extends RecyclerView.ViewHolder{

        MaterialTextView t1,t2;

        public myview_holder(@NonNull View itemView) {
            super(itemView);
            t1 =itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);
        }
    }
}
