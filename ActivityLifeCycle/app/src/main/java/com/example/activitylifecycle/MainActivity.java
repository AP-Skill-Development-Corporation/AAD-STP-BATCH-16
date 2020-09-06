package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.tv1);
        textView.append("Oncreate()\n");
    }

    @Override
    protected void onStart() {
        super.onStart();
        textView.append("Onstart()\n");
    }

    @Override
    protected void onPause() {
        super.onPause();
        textView.append("Onpause()\n");
    }

    @Override
    protected void onResume() {
        super.onResume();
        textView.append("OnResume\n");
    }

    @Override
    protected void onStop() {
        super.onStop();
        textView.append("OnStop()\n");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        textView.append("OnRestart()\n");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        textView.append("OnDestroy()\n");
    }
}
