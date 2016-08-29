package com.hackathon.swatchcity.swatchcity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Birthday_info extends AppCompatActivity {
    TextView phonenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_info);
        TextView name = (TextView) findViewById(R.id.name);
        TextView birthdate = (TextView) findViewById(R.id.birthdate);
        TextView phonenumber = (TextView) findViewById(R.id.phonenumber);
        birthdays birthdays = new birthdays();
        drawer drawer = new drawer();
        String[] names = drawer.name();
        String[] DOB = drawer.DOB();
        String[] namephone=drawer.getNamephone();
        String[] phone=drawer.phonenumber();
        name.setText(names[birthdays.position()]);
        birthdate.setText(DOB[birthdays.position()]);

    }

    public void CALL(View view) {
        String phone = phonenumber.getText().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(intent);;

}
}
