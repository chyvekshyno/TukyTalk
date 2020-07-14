package com.example.tukyhelper.Model.EssenceRoom;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EssenceTypeDao {

    @Query("SELECT * FROM essence_type")
    LiveData<List<EssenceType>> getAll();

    @Query("SELECT * FROM essence_type WHERE id = :id")
    LiveData<EssenceType> getById(int id);
}
