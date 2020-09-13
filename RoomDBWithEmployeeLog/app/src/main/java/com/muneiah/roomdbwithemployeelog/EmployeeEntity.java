package com.muneiah.roomdbwithemployeelog;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "emp_table")
public class EmployeeEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    String id;
    @ColumnInfo(name = "enm_name")
    String name;

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
