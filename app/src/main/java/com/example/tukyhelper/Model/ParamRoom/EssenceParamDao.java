package com.example.tukyhelper.Model.ParamRoom;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EssenceParamDao {

    @Query("SELECT * FROM ESSENCE_PARAMS")
    LiveData<List<EssenceParam>> getAll();

    @Query("SELECT * FROM ESSENCE_PARAMS WHERE ID = :id")
    LiveData<List<EssenceParam>> getByEssenceId(int id);

    @Update
    void update(EssenceParam param);

    @Insert
    void insert(EssenceParam param);

    @Delete
    void delete(int id);
}
