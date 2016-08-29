package com.hackathon.swatchcity.swatchcity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.parse.Parse;
import com.parse.ParseUser;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        Thread thread=new Thread(){
            @Override
            public void run() {

                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                    if(ParseUser.getCurrentUser()==null)
                startActivity(new Intent(getApplicationContext(),Login.class));
                else
                        startActivity(new Intent(getApplicationContext(),drawer.class));

                Splash.this.finish();

            }


        };
        thread.start();



    }

}
