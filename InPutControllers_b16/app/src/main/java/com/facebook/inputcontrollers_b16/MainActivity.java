package com.facebook.inputcontrollers_b16;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb1,rb2;
    CheckBox cb1,cb2,cb3;
    Switch aSwitch;
    LinearLayout linearLayout;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.sp1);
        aSwitch = findViewById(R.id.switch1);
        linearLayout = findViewById(R.id.linear1);

        cb1 = findViewById(R.id.check1);
        cb2 = findViewById(R.id.check2);
        cb3=findViewById(R.id.check3);
        rg=findViewById(R.id.rg1);
        rb1 = findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
        ArrayList<String>  weeks = new ArrayList<>();
        weeks.add("Sunday");
        weeks.add("MonDay");
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,weeks);
        spinner.setAdapter(adapter);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.rb1:
                        Toast.makeText(MainActivity.this, "You Selected Male",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb2:
                        Toast.makeText(MainActivity.this, "You Selected FeMale",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }


    public void selectSmile(View view) {
        Toast.makeText(this, "You Selected Smile", Toast.LENGTH_SHORT).show();
    }

    public void save(View view) {
        if(cb1.isChecked()&&cb2.isChecked()&&cb3.isChecked()){
            Toast.makeText(this, ""+cb1.getText()+","+cb2.getText()+","+cb3.getText(), Toast.LENGTH_SHORT).show();
        }
    }

    public void aSwitchclick(View view) {
        if(aSwitch.isChecked()){
            linearLayout.setBackgroundColor(Color.YELLOW);

        }else{
            linearLayout.setBackgroundColor(Color.GREEN);
        }
    }
}