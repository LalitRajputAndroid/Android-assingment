package com.example.englishdictionary;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myview_holder> implements Filterable {

    ArrayList<modal> list;
    ArrayList<modal> bekup;
    Context context;

    public myadapter(ArrayList<modal> list, Context context) {
        this.list = list;
        this.context = context;
        bekup=new ArrayList<>();
    }

    @NonNull
    public myview_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_row,parent,false);

        return new myview_holder(view);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull myview_holder holder, @SuppressLint("RecyclerView") int position) {
      holder.t1.setText(list.get(position).getWord());
      holder.t2.setText(list.get(position).getMeaning());

      holder.singlerow.setOnLongClickListener(view -> {

          AlertDialog.Builder alertbtn = new AlertDialog.Builder(context);
          alertbtn.setTitle("Delete");
          alertbtn.setMessage("Are you sure ");
          alertbtn.setIcon(R.drawable.ic_baseline_delete_24);
          alertbtn.setPositiveButton("Ok", (dialogInterface, i) -> {
              String w = holder.t1.getText().toString();
              String m = holder.t2.getText().toString();

              mydbhelper db = new mydbhelper(context);
              boolean re = db.deletedata(w,m);
              if (re==true) {
                  list.remove(position);
                  notifyDataSetChanged();
                  Toast.makeText(context, "deleted", Toast.LENGTH_SHORT).show();
              }else {
                  Toast.makeText(context, "not deleted", Toast.LENGTH_SHORT).show();
              }
          });
          alertbtn.show();
          return false;
      });

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
                    if (obj.getWord().toLowerCase().contains(Sequence.toString().toLowerCase()));

                    filtereddata.add(obj);
                }
            }
            FilterResults results = new FilterResults();
            results.values = filtereddata;
            return results;
        }

        @SuppressLint("NotifyDataSetChanged")
        @Override
        protected void publishResults(CharSequence Sequence, FilterResults results) {

            list.clear();
            list.addAll( (ArrayList<modal>)results.values);
            notifyDataSetChanged();
        }
    };

    public static class myview_holder extends RecyclerView.ViewHolder{

        MaterialTextView t1,t2;
        LinearLayout singlerow;

        public myview_holder(@NonNull View itemView) {
            super(itemView);
            t1 =itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);
            singlerow = itemView.findViewById(R.id.singlerow_id);
        }
    }
}
