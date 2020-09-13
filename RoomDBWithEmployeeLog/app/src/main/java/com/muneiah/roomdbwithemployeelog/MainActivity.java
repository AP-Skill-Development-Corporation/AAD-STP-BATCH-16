package com.muneiah.roomdbwithemployeelog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText empName,empId;
RecyclerView rec;
EmployeeAdapter adapter;
static EmployeeDatabase database;
EmployeeEntity entity;
List<EmployeeEntity> entityList;
static MyViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        empId=findViewById(R.id.et_empid);
        empName=findViewById(R.id.et_empName);
        rec=findViewById(R.id.recycler);
      /*  database= Room.databaseBuilder(this,EmployeeDatabase.class,"ap")
                .allowMainThreadQueries()
                .build();*/
  //for Live data
        viewModel=new ViewModelProvider(this).get(MyViewModel.class);
        viewModel.getListLiveData_model().observe(this, new Observer<List<EmployeeEntity>>() {
            @Override
            public void onChanged(List<EmployeeEntity> employeeEntities) {
            adapter=new EmployeeAdapter(MainActivity.this,employeeEntities);
            rec.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            rec.setAdapter(adapter);
            }
        });
    }

    public void saveData(View view) {
        String my_id=empId.getText().toString();
        String my_name=empName.getText().toString();
        entity=new EmployeeEntity();
        entity.setId(my_id);
        entity.setName(my_name);
        //database.employeeDAO().insert(entity);
        //for live data
        viewModel.insert(entity);
        Toast.makeText(this, "Succsessfully inserted  "+my_name, Toast.LENGTH_SHORT).show();
    }

    /*public void RetriveData(View view) {
        entityList=database.employeeDAO().retrive();
        adapter=new EmployeeAdapter(this,entityList);
        rec.setLayoutManager(new LinearLayoutManager(this));
        rec.setAdapter(adapter);
    }*/
}
