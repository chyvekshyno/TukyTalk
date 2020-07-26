package com.example.tukyhelper.Model.MessageRoom;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EssenceMessageDao {
    @Query("SELECT * FROM MESSAGES")
    LiveData<List<EssenceMessage>> getAll();

    @Query("SELECT * FROM MESSAGES WHERE ESSENCE_ID = :id")
    LiveData<List<EssenceMessage>> getAllForEssence(int id);

    @Query("SELECT * FROM MESSAGES WHERE ESSENCE_ID = :id AND TYPE = '1'")
    LiveData<List<EssenceMessage>> getImportantForEssence(int id);

    @Query("SELECT * FROM MESSAGES WHERE ESSENCE_ID = :id AND TYPE = '2'")
    LiveData<List<EssenceMessage>> getPropForEssence(int id);

    @Query("SELECT * FROM MESSAGES WHERE ESSENCE_ID = :id AND TYPE = '3'")
    LiveData<List<EssenceMessage>> getAdvForEssence(int id);

    @Insert
    void insert(EssenceMessage message);

    @Update
    void update(EssenceMessage message);

    @Delete
    void delete(EssenceMessage message);
}
