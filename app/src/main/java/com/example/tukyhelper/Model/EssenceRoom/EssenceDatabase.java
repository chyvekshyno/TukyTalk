package com.example.tukyhelper.Model.EssenceRoom;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Essence.class, EssenceType.class}, version = 1)
public abstract class EssenceDatabase extends RoomDatabase {

    public abstract EssenceDao essenceDao();
    public abstract EssenceTypeDao essenceTypeDao();
    private static EssenceDatabase instance;

    public static synchronized EssenceDatabase getDatabase(Context context) {
        if (instance == null){
            instance = Room.databaseBuilder(context, EssenceDatabase.class, "Essence.db")
                    .createFromAsset("database/Essence.db")
                    .build();
        }
        return instance;
    }

}
