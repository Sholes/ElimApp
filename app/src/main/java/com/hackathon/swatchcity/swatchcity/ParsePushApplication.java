package com.hackathon.swatchcity.swatchcity;


import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.hackathon.swatchcity.swatchcity.Login;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParsePush;
import com.parse.SaveCallback;
import com.parse.http.ParseHttpRequest;


public class ParsePushApplication extends Application {
    private SharedPreferences settings;
    private SharedPreferences.Editor editor;

    @Override
    public void onCreate() {

        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        ConnectivityManager conMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        Parse.enableLocalDatastore(getApplicationContext());
        Parse.addParseNetworkInterceptor(new ParseLogInterceptor());
            Parse.initialize(this, "YDwQVycjQOAIfQHErUGSyQkAj2ilFT3zs0TEPrdX", "KaFmGh8Uxlte2tVw0eAYnHvrAXF0GW2pZyE3P5or");
            // notify user you are online




        WifiManager wifiManager = (WifiManager)getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();



        ParsePush.subscribeInBackground("", new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Log.d("com.parse.push", "successfully subscribed to the broadcast channel.");
                } else {
                    Log.e("com.parse.push", "failed to subscribe for push", e);
                }
            }
        });
        super.onCreate();
    }
}
