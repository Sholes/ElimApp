package com.hackathon.swatchcity.swatchcity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static com.hackathon.swatchcity.swatchcity.constants.FIRST_COLUMN;
import static com.hackathon.swatchcity.swatchcity.constants.SECOND_COLUMN;

public class drawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static List<ParseObject> cachedquestions,cachednumbers,cachedanni;
    public static String[] name,DOB,number,namephone,selnam,seldate,annnam,anndate;
    public static  ArrayList<HashMap<String, String>> anniver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final List<String> questions = new ArrayList<>();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



       ParseQuery<ParseObject> query = ParseQuery.getQuery("birthdays");
        ParseQuery<ParseObject> query1 = ParseQuery.getQuery("phone");
        ParseQuery<ParseObject> query2 = ParseQuery.getQuery("anniversaries");


        query.setLimit(1000);

        try {
            List<ParseObject> objects = null; // Online ParseQuery results
            List<ParseObject> objects1 = null;
            List<ParseObject> objects2 = null;
            if(isNetworkAvailable()){
                objects = query.find();
                objects1=query1.find();
                objects2=query2.find();
                ParseObject.pinAllInBackground(objects);
                ParseObject.pinAllInBackground(objects1);
                ParseObject.pinAllInBackground(objects2);


            }
        } catch (com.parse.ParseException e) {
            e.printStackTrace();
        }


        query.fromLocalDatastore().findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, ParseException e) {
                int i = 0;
                if (e == null) {
                    Log.e("score", "Retrieved " + objects.size() + " scores");
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
                cachedquestions = objects;
                name = new String[1000];
                DOB = new String[1000];
                for (ParseObject parseObject : objects) {
                    name[i] = (new String(parseObject.get("Name").toString()));
                    DOB[i] = (new String(parseObject.get("DOB").toString()));
                    Log.i("what fetched", parseObject.get("DOB").toString());
                    i++;
                }
            }
        });


        query1.fromLocalDatastore().findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, ParseException e) {
                int i = 0;
                if (e == null) {
                    Log.e("score1", "Retrieved " + objects.size() + " scores");

                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
                cachednumbers = objects;
                namephone = new String[cachednumbers.size()];
                number = new String[cachednumbers.size()];
                for (ParseObject parseObject : objects) {
                    namephone[i] = (new String(parseObject.get("Name").toString()));
                    number[i] = (new String(parseObject.get("Number").toString()));
                    Log.i("what fetched", parseObject.get("Name").toString());
                    i++;
                }
            }
        });


        query2.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, ParseException e) {
                int i = 0;
                if (e == null) {
                    Log.e("score1", "Retrieved " + objects.size() + " scores");

                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
                cachedanni = objects;
                annnam = new String[cachedanni.size()];
                anndate = new String[cachedanni.size()];
                for (ParseObject parseObject : objects) {
                    annnam[i] = (new String(parseObject.get("Name").toString()));
                    anndate[i] = (new String(parseObject.get("wedding").toString()));
                    Log.i("what fetched", parseObject.get("Name").toString());
                    i++;
                }
            }});
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camara) {
            Intent intent11=new Intent(getApplicationContext(),devotion.class);
            startActivity(intent11);

            // Handle the camera action
        } else if (id == R.id.nav_birthdays) {
            Intent intent4=new Intent(getApplicationContext(),birthdays.class);
            startActivity(intent4);

        }  else if (id == R.id.nav_anniversaries) {
            Intent intent5=new Intent(getApplicationContext(),weddings.class);
            startActivity(intent5);

        } else if (id == R.id.nav_member) {
            Intent intent6=new Intent(getApplicationContext(),Birthday_info.class);
            startActivity(intent6);
        }
        else
        {
            Intent intent7=new Intent(getApplicationContext(),devotion.class);
            startActivity(intent7);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public String[] getNamephone(){
        return namephone;
    }
    public String[] name(){
        return name;
    }
    public String[] annname(){
        return annnam;
    }
    public String[] annidate(){
        return anndate;
    }
    public String[] phonenumber(){
        return number;
    }
   public static String[] DOB(){
    return DOB;}
    public String[] index(){

        String date = new SimpleDateFormat("MM-dd-yyyy").format(new Date());
        int month=Integer.parseInt(date.split("-")[0]);
        int day=Integer.parseInt(date.split("-")[1]);
        Log.e("month",""+day);
        int index[]=new int[233];
        String[] DOBused=DOB;
         seldate=new String[name.length];
        int j=0;
        for(int i=0;i<233;i++){
            int ind=Integer.parseInt(DOBused[i].split("/")[0]);
            int daytest=Integer.parseInt(DOBused[i].split("/")[1]);
            if(ind==month&&daytest>=day){
                seldate[j]=DOBused[i];
                j++;
        }}
        return seldate;
    }
    public String[] nameindex(){

        String date = new SimpleDateFormat("MM-dd-yyyy").format(new Date());
        int month=Integer.parseInt(date.split("-")[0]);
        int day=Integer.parseInt(date.split("-")[1]);
        Log.e("month",""+month);
        int index[]=new int[233];
        String[] DOBused=DOB;
        selnam=new String[name.length];
        int j=0;
        for(int i=0;i<233;i++){
            int ind=Integer.parseInt(DOBused[i].split("/")[0]);
            int daytest=Integer.parseInt(DOBused[i].split("/")[1]);
            if(ind==month&&daytest>=day){
                selnam[j]=name[i];
                j++;
            }}
        return selnam;
    }
public int entries(){
    String date = new SimpleDateFormat("MM-dd-yyyy").format(new Date());
    int month=Integer.parseInt(date.split("-")[0]);
    Log.e("month",""+month);
    int index=0;
    String[] DOBused=DOB;
    String selnam[]=new String[name.length];
    int j=0;
    for(int i=0;i<233;i++){
        int ind=Integer.parseInt(DOBused[i].split("/")[0]);
        if(ind==month){
            index++;
        }}
    return index;

}

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

}
