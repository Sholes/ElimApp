package com.hackathon.swatchcity.swatchcity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import java.util.ArrayList;
import java.util.HashMap;
import static com.hackathon.swatchcity.swatchcity.constants.FIRST_COLUMN;
import static com.hackathon.swatchcity.swatchcity.constants.SECOND_COLUMN;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
public class weddings extends AppCompatActivity {
    private ArrayList<HashMap<String, String>> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weddings);
        ListView mylist=(ListView)findViewById(R.id.listView1);
        drawer drawer=new drawer();
        list=new ArrayList<HashMap<String,String>>();
        for(int i=0;i<drawer.annname().length;i++){
            HashMap<String,String> temp10=new HashMap<String, String>();
            temp10.put(FIRST_COLUMN, drawer.annname()[i]);
            temp10.put(SECOND_COLUMN, drawer.annidate()[i]);

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
    }
    }
