package com.example.tukyhelper.Model.EssenceRoom;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EssenceDao {

    @Query("SELECT * FROM Essence")
    LiveData<List<Essence>> getAll();

    @Query("SELECT * FROM Essence WHERE id = :id")
    LiveData<Essence> getById(int id);

    @Insert
    void insert(Essence ess);

    @Update
    void update(Essence ess);

    @Delete
    void delete(Essence ess);
}
