package com.example.tukyhelper.Model.EssenceRoom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EssenceDao {

    @Query("SELECT * FROM Essence")
    List<Essence> getAll();

    @Query("SELECT * FROM Essence WHERE id = :id")
    Essence getById(int id);

    @Insert
    void insert(Essence es);

    @Update
    void update(Essence es);

    @Delete
    void delete(Essence es);
}
