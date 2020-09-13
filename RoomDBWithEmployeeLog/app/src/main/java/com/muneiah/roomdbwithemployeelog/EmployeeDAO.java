package com.muneiah.roomdbwithemployeelog;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EmployeeDAO {
    @Insert
    public void insert(EmployeeEntity entity);
    @Update
    public void update(EmployeeEntity entity);

    @Delete
    public void delete(EmployeeEntity entity);
    @Query("SELECT * FROM emp_table")
    public LiveData<List<EmployeeEntity>> retriveLiveData();//for live data
    /*public List<EmployeeEntity> retrive();*///Normal Room Db
}
