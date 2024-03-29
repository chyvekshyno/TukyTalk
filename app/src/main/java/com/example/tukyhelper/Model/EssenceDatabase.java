package com.example.tukyhelper.Model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tukyhelper.Model.EssenceRoom.Essence;
import com.example.tukyhelper.Model.EssenceRoom.EssenceDao;
import com.example.tukyhelper.Model.EssenceRoom.EssenceType;
import com.example.tukyhelper.Model.EssenceRoom.EssenceTypeDao;
import com.example.tukyhelper.Model.MessageRoom.EssenceMessage;
import com.example.tukyhelper.Model.MessageRoom.EssenceMessageDao;
import com.example.tukyhelper.Model.ParamRoom.EssenceParam;
import com.example.tukyhelper.Model.ParamRoom.EssenceParamDao;
import com.example.tukyhelper.Model.ParamRoom.EssenceParamWord;
import com.example.tukyhelper.Model.ParamRoom.EssenceParamWordDao;

@Database(entities = {Essence.class, EssenceType.class
        , EssenceParam.class, EssenceParamWord.class
        , EssenceMessage.class}, version = 1)
public abstract class EssenceDatabase extends RoomDatabase {

    public abstract EssenceDao essenceDao();
    public abstract EssenceTypeDao essenceTypeDao();
    public abstract EssenceParamDao essenceParamDao();
    public abstract EssenceParamWordDao essenceParamWordDao();
    public abstract EssenceMessageDao essenceMessageDao();
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
