package com.hackathon.swatchcity.swatchcity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import static com.hackathon.swatchcity.swatchcity.constants.FIRST_COLUMN;
import static com.hackathon.swatchcity.swatchcity.constants.SECOND_COLUMN;

public class birthdays extends AppCompatActivity {
    String[]name;
    static int position1;
    private ArrayList<HashMap<String, String>> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawer drawer=new drawer();
        setContentView(R.layout.activity_birthdays);
        name=drawer.name();
        ListView mylist=(ListView)findViewById(R.id.listView);
        list=new ArrayList<HashMap<String,String>>();
        String[] names = drawer.name();
        String[] DOB = drawer.DOB();
        String[] namephone=drawer.getNamephone();
        String[] phone=drawer.phonenumber();
        String[] selected=drawer.nameindex();
        String[] dateselec=drawer.index();
        for(int i=0;i<drawer.entries();i++){
        HashMap<String,String> temp10=new HashMap<String, String>();
        temp10.put(FIRST_COLUMN, selected[i]);
        temp10.put(SECOND_COLUMN, dateselec[i]);

        list.add(temp10);}


        ListViewAdapters adapter=new ListViewAdapters(this, list);
        mylist.setAdapter(adapter);

        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id)
            {
                int pos=position+1;
                //Toast.makeText(MainActivity.this, Integer.toString(pos)+" Clicked", Toast.LENGTH_SHORT).show();
            }

        });

       // String[] myStringArray = {"Rev Ravi David", "Mrs Elizabeth Ravi", "Evangeline Ravi", "Grace.Kotian", "Yeshoda.Kotian","Rev Ravi David", "Mrs Elizabeth Ravi", "Evangeline Ravi", "Grace.Kotian", "Yeshoda.Kotian", "Mohan.Kari", "Usha.Kari", "Steffi.Kari", "Renold.Kotian", "Marina.Kotian", "Sharon.Kotian"};
//        ArrayAdapter<String> myAdapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,selected);
//
//        mylist.setAdapter(myAdapter);
//        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });
    }


    public int position(){
        return position1;
    }


    }

