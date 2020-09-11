package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText  email,pwd;

    SharedPreferences preferences;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences=getSharedPreferences("gopal",MODE_PRIVATE);

        email=findViewById(R.id.et1);

        pwd=findViewById(R.id.et2);

        textView=findViewById(R.id.tv);


        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
              String e=  email.getText().toString();

              String p=  pwd.getText().toString();

              SharedPreferences.Editor editor=preferences.edit();

              editor.putString("email",e);

              editor.putString("pwd",p);

              editor.apply();

                Toast.makeText(MainActivity.this, "data saved", Toast.LENGTH_SHORT).show();

            }
        });

        findViewById(R.id.retri).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

               String useremail= preferences.getString("email",null);

               String userpassword=  preferences.getString("pwd",null);

               textView.setText(""+useremail+"\n"+userpassword);
            }
        });

    }
}
