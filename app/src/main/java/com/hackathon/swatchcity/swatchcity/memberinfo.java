package com.hackathon.swatchcity.swatchcity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.audiofx.Equalizer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class memberinfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberinfo);
        String[] myStringArray = {"Shirley.Kotian", "Snita.Kotian", "Sydney.Kotian", "Grace.Kotian", "Yeshoda.Kotian", "Mohan.Kari", "Usha.Kari", "Steffi.Kari", "Renold.Kotian", "Marina.Kotian", "Sharon.Kotian"};
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myStringArray);
        ListView mylist = (ListView) findViewById(R.id.listView);
        mylist.setAdapter(myAdapter);


    }
}