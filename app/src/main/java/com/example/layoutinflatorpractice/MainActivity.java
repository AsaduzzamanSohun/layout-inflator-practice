package com.example.layoutinflatorpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout myLayout;
    Button bangladeshBtn, appDevBtn, remove;
    LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLayout = findViewById(R.id.myLayout);
        bangladeshBtn = findViewById(R.id.bangladesh_btn);
        appDevBtn = findViewById(R.id.app_dev_btn);
        remove = findViewById(R.id.remove);

        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        bangladeshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myLayout.removeAllViews();
                layoutInflater.inflate(R.layout.bd_layout, myLayout);
                remove.setEnabled(true);

            }
        });

        appDevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myLayout.removeAllViews();
                layoutInflater.inflate(R.layout.app_layout, myLayout);
                remove.setEnabled(true);

            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myLayout.removeAllViews();
                remove.setEnabled(false);

            }
        });

    }


    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setIcon(R.drawable.alert)
                .setMessage("Are you sure want to exit?")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finishAndRemoveTask();

                    }
                }).show();

    }
}