package com.example.tukyhelper.Model.MessageRoom;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MessageDao {
    @Query("SELECT * FROM MESSAGES")
    LiveData<List<Message>> getAll();

    @Query("SELECT * FROM MESSAGES WHERE ESSENCE_ID = :id")
    LiveData<List<Message>> getAllForEssence(int id);

    @Query("SELECT * FROM MESSAGES WHERE ESSENCE_ID = :id AND TYPE = '1'")
    LiveData<List<Message>> getImportantForEssence(int id);

    @Query("SELECT * FROM MESSAGES WHERE ESSENCE_ID = :id AND TYPE = '2'")
    LiveData<List<Message>> getPropForEssence(int id);

    @Query("SELECT * FROM MESSAGES WHERE ESSENCE_ID = :id AND TYPE = '3'")
    LiveData<List<Message>> getAdvForEssence(int id);

    @Insert
    void insert();

    @Update
    void update();

    @Delete
    void delete();
}
