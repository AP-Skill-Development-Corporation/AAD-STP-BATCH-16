package com.facebook.implicitintent_b16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2,et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.edit1);
        et2 = findViewById(R.id.edit2);
        et3 = findViewById(R.id.edit3);
    }

    public void browser(View view) {
        String url = et1.getText().toString();
        Uri webpage = Uri.parse("https://www."+url);
        Intent intent = new Intent(Intent.ACTION_VIEW,webpage);
        startActivity(intent);
    }

    public void dial(View view) {
        String num = et2.getText().toString();
        Uri uri = Uri.parse("tel:"+num);
        Intent i = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(i);
    }

    public void send(View view) {
        String data = et3.getText().toString();
        if(data.equals("")){
            Toast.makeText(this, "fill the values", Toast.LENGTH_SHORT).show();
        }else
        {
            Intent intent = new Intent(this,SecondActivity.class);
            intent.putExtra("KEY",data);
            startActivity(intent);
        }
    }
}