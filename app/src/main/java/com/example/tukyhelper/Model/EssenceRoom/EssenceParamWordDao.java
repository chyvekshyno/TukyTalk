package com.example.tukyhelper.Model.EssenceRoom;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EssenceParamWordDao {

    @Query("SELECT * FROM PARAMS_DIC")
    LiveData<List<EssenceParamWord>> getAll();

    @Update
    void update();

    @Insert
    void insert();

    @Delete
    void delete();
}
