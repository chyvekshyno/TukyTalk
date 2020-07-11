package com.example.tukyhelper.Model.EssenceRoom;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {Essence.class}, version = 1)
public abstract class EssenceDatabase extends RoomDatabase {

    private static EssenceDatabase instance;
    public abstract EssenceDao essenceDao();

    public static synchronized EssenceDatabase getDatabase(Context context) {
        if (instance == null){
            instance = Room.databaseBuilder(context, EssenceDatabase.class, "essence_database")
                    .build();
        }
        return instance;
    }

}
