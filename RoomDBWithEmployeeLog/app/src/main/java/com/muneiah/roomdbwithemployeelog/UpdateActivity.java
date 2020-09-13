package com.muneiah.roomdbwithemployeelog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    EditText name_update, id_update;
EmployeeEntity entity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        name_update = findViewById(R.id.et_empName_update);
        id_update = findViewById(R.id.et_empid_update);
        Intent myIntent=getIntent();
       String resultName= myIntent.getStringExtra("emp_name");
       String resultID= myIntent.getStringExtra("emp_id");
       name_update.setText(resultName);
       id_update.setText(resultID);
       id_update.setKeyListener(null);//disable the input from EditText


    }

    public void updateData(View view) {
        String myname=name_update.getText().toString();
        String myId=id_update.getText().toString();
        entity=new EmployeeEntity();
        entity.setName(myname);
        entity.setId(myId);
       // MainActivity.database.employeeDAO().update(entity);
        MainActivity.viewModel.update(entity);
        Toast.makeText(this, myname+" is Updated", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);

    }
}
