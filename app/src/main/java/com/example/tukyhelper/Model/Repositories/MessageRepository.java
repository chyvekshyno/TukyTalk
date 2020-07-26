package com.example.tukyhelper.Model.Repositories;

import android.app.Application;
import android.app.ListActivity;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tukyhelper.Model.EssenceDatabase;
import com.example.tukyhelper.Model.MessageRoom.EssenceMessage;
import com.example.tukyhelper.Model.MessageRoom.EssenceMessageDao;

import java.util.List;

public class MessageRepository {

    EssenceMessageDao msgDao;

    public MessageRepository(Application app) {
        EssenceDatabase essenceDB = EssenceDatabase.getDatabase(app);
        msgDao = essenceDB.essenceMessageDao();
    }

    //region API

    LiveData<List<EssenceMessage>> getAll(){
        return msgDao.getAll();
    }

    LiveData<List<EssenceMessage>> getAllForEssence(int id){
        return msgDao.getAllForEssence(id);
    }

    LiveData<List<EssenceMessage>> getImportantForEssence(int id){
        return msgDao.getImportantForEssence(id);
    }

    LiveData<List<EssenceMessage>> getPropForEssence(int id){
        return msgDao.getPropForEssence(id);
    }

    LiveData<List<EssenceMessage>> getAdvForEssence(int id){
        return msgDao.getAdvForEssence(id);
    }

    void insert(EssenceMessage message){
        new MessageInsertAsyncTask().execute(message);
    }

    void update(EssenceMessage message){
        new MessageUpdateAsyncTask().execute(message);
    }

    void delete(EssenceMessage message){
        new MessageDeleteAsyncTask().execute(message);
    }

    //region AsyncTasks
    class MessageInsertAsyncTask extends AsyncTask<EssenceMessage, Void, Void>{

        @Override
        protected Void doInBackground(EssenceMessage... messages) {
            msgDao.insert(messages[0]);
            return null;
        }
    }

    class MessageUpdateAsyncTask extends AsyncTask<EssenceMessage, Void, Void>{

        @Override
        protected Void doInBackground(EssenceMessage... messages) {
            msgDao.update(messages[0]);
            return null;
        }
    }

    class MessageDeleteAsyncTask extends AsyncTask<EssenceMessage, Void, Void>{

        @Override
        protected Void doInBackground(EssenceMessage... messages) {
            msgDao.delete(messages[0]);
            return null;
        }
    }

    //endregion
    //endregion

}
