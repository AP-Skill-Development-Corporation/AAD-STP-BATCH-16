package com.muneiah.roomdbwithemployeelog;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = EmployeeEntity.class,version = 1,exportSchema = false)
public abstract class EmployeeDatabase extends RoomDatabase {
    public abstract EmployeeDAO employeeDAO();
    //for Live Data
    static EmployeeDatabase database;
    public static synchronized EmployeeDatabase getDataBase(Context ctx){
        database= Room.databaseBuilder(ctx,EmployeeDatabase.class,"ap")
                .allowMainThreadQueries()
                .build();
        return database;
    }
}
