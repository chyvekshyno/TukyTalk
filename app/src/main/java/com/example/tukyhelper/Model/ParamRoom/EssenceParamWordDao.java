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

    @Query("SELECT * FROM PARAMS_DIC WHERE ESSENCE_TYPE_ID = :typeId")
    LiveData<List<EssenceParamWord>> getAllByEssenceTypeId(int typeId);

    @Query("SELECT * FROM PARAMS_DIC WHERE ESSENCE_TYPE_ID = :typeId ORDER BY `ORDER`")
    LiveData<List<EssenceParamWord>> getAllByEssenceTypeIdOrdered(int typeId);

    @Update
    void update(EssenceParamWord paramWord);

    @Insert
    void insert(EssenceParamWord paramWord);

    @Delete
    void delete(EssenceParamWord paramWord);
}
