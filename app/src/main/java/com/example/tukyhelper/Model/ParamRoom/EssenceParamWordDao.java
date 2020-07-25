package com.example.tukyhelper.Model.ParamRoom;

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
    void update(EssenceParamWord paramWord);

    @Insert
    void insert(EssenceParamWord paramWord);

    @Delete
    void delete(EssenceParamWord paramWord);
}
