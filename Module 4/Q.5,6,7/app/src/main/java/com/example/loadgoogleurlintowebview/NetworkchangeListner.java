package com.example.loadgoogleurlintowebview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

import com.google.android.material.button.MaterialButton;

public class NetworkchangeListner extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (!internetC.onConnectedtointernet(context)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            View view = LayoutInflater.from(context).inflate(R.layout.no_internet_dailoge, null);
            builder.setView(view);

            MaterialButton returnbtn = view.findViewById(R.id.returnbtn_id);
            AlertDialog dialog = builder.create();
            dialog.show();
            builder.setCancelable(false);
            dialog.getWindow().setGravity(Gravity.CENTER);

            returnbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                    onReceive(context, intent);
                }
            });
        }
    }
}
