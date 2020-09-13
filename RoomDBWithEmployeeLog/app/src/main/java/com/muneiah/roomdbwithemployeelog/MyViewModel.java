package com.muneiah.roomdbwithemployeelog;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    EmployeeRepo employeeRepo;
    LiveData<List<EmployeeEntity>> listLiveData_model;
    public MyViewModel(@NonNull Application application) {
        super(application);
        employeeRepo=new EmployeeRepo(application);
        listLiveData_model=employeeRepo.getListLiveData();
    }
    public void insert(EmployeeEntity entity){
        employeeRepo.insert(entity);
    }
    public void update(EmployeeEntity entity){
        employeeRepo.update(entity);
    }
    public void delete(EmployeeEntity entity){
        employeeRepo.delete(entity);
    }
    public LiveData<List<EmployeeEntity>> getListLiveData_model(){
        return listLiveData_model;
    }
}
