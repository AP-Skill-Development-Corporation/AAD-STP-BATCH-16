package com.facebook.serviceapp_b16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    /*A Service is a component  that is used to perform operations on the background
    * such as playingMusic,handle Network Connections etc...
    * It doesnot has any UI.
    * There can be  two forms of service
    * -Started
    * -Bound */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View view) {
        Intent i = new Intent(this,MyService.class);
        startService(i);
    }

    public void stop(View view) {
        Intent i = new Intent(this,MyService.class);
        stopService(i);
    }
}