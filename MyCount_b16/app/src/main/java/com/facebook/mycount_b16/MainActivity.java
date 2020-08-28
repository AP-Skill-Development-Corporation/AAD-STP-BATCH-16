package com.facebook.mycount_b16;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int count=0;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.text1);
    }

    public void mCount(View view) {
        count++;
        t1.setText(""+count);
    }

    public void mToast(View view) {
        /* Toast is aNotification message that popup for  a Specific
        * duration.*/
        Toast.makeText(this,"GoodEvening",Toast.LENGTH_LONG).show();
    }
}