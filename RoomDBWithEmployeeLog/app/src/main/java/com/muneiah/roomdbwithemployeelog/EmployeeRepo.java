package com.muneiah.roomdbwithemployeelog;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class EmployeeRepo {
    EmployeeDatabase employeeDb;
    LiveData<List<EmployeeEntity>> listLiveData;

    public EmployeeRepo(Application app) {
        employeeDb = EmployeeDatabase.getDataBase(app);
        listLiveData = employeeDb.employeeDAO().retriveLiveData();
    }

    //Insert background task
    public class MyAsyncTaskForInsert extends AsyncTask<EmployeeEntity, Void, Void> {

        @Override
        protected Void doInBackground(EmployeeEntity... employeeEntities) {
            employeeDb.employeeDAO().insert(employeeEntities[0]);
            return null;
        }
    }

    //update background task
    public class MyAsyncTaskForUpdate extends AsyncTask<EmployeeEntity, Void, Void> {

        @Override
        protected Void doInBackground(EmployeeEntity... employeeEntities) {
            employeeDb.employeeDAO().update(employeeEntities[0]);
            return null;
        }
    }

    //delete background task
    public class MyAsyncTaskForDelete extends AsyncTask<EmployeeEntity, Void, Void> {

        @Override
        protected Void doInBackground(EmployeeEntity... employeeEntities) {
            employeeDb.employeeDAO().delete(employeeEntities[0]);
            return null;
        }
    }

    public void insert(EmployeeEntity entity) {
        new MyAsyncTaskForInsert().execute(entity);
    }

    public void delete(EmployeeEntity entity) {
        new MyAsyncTaskForDelete().execute(entity);
    }

    public void update(EmployeeEntity entity) {
        new MyAsyncTaskForUpdate().execute(entity);
    }

    public LiveData<List<EmployeeEntity>> getListLiveData() {
        return listLiveData;
    }
}
