package com.example.tukyhelper.Model.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.tukyhelper.Model.EssenceDatabase;
import com.example.tukyhelper.Model.ParamRoom.EssenceParam;
import com.example.tukyhelper.Model.ParamRoom.EssenceParamDao;
import com.example.tukyhelper.Model.ParamRoom.EssenceParamWord;
import com.example.tukyhelper.Model.ParamRoom.EssenceParamWordDao;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class ParamsRepository {

    //region Dao
    private EssenceParamDao essParamDao;
    private EssenceParamWordDao essParamWordDao;
    //endregion
    //endregion

    public ParamsRepository(Application app) {
        EssenceDatabase essenceDb = EssenceDatabase.getDatabase(app);

        essParamDao = essenceDb.essenceParamDao();
        essParamWordDao = essenceDb.essenceParamWordDao();
    }

    //region API

    //region EssenceParam API
    public  void insert(EssenceParam param){
        new ParamInsertAsyncTask().execute(param);
    }

    public  void update(EssenceParam param){
        new ParamUpdateAsyncTask().execute(param);
    }

    public  void delete(EssenceParam param){
        new ParamDeleteAsyncTask().execute(param);
    }

    public LiveData<List<EssenceParam>> getAllParams(){
        return essParamDao.getAll();
    }

    public LiveData<List<EssenceParam>> getAllParamsByEssenceId(int id){
        return essParamDao.getByEssenceId(id);
    }

    //region AsyncTasks

    class ParamInsertAsyncTask extends AsyncTask<EssenceParam, Void, Void>{

        @Override
        protected Void doInBackground(EssenceParam... essenceParams) {
            essParamDao.insert(essenceParams[0]);
            return null;
        }
    }

    class ParamUpdateAsyncTask extends AsyncTask<EssenceParam, Void, Void>{

        @Override
        protected Void doInBackground(EssenceParam... essenceParams) {
            essParamDao.update(essenceParams[0]);
            return null;
        }
    }

    class ParamDeleteAsyncTask extends AsyncTask<EssenceParam, Void, Void>{

        @Override
        protected Void doInBackground(EssenceParam... essenceParams) {
            essParamDao.delete(essenceParams[0]);
            return null;
        }
    }

    //endregion
    //endregion

    //region EssenceParamWord API
    public  void insert(EssenceParamWord paramWord){
        new ParamWordInsertAsyncTask().execute(paramWord);
    }

    public  void update(EssenceParamWord paramWord){
        new ParamWordUpdateAsyncTask().execute(paramWord);
    }

    public  void delete(EssenceParamWord paramWord){
        new ParamWordDeleteAsyncTask().execute(paramWord);;
    }

    public LiveData<List<EssenceParamWord>> getAllParamDic(){
        return essParamWordDao.getAll();
    }

    public LiveData<List<EssenceParamWord>> getParamDicForEssenceType(int typeId){
        return essParamWordDao.getAllByEssenceTypeId(typeId);
    }

    public LiveData<List<EssenceParamWord>> getParamDicForEssenceTypeOrdered(int typeId){
        return essParamWordDao.getAllByEssenceTypeIdOrdered(typeId);
    }


    //region AsyncTasks

    class ParamWordInsertAsyncTask extends AsyncTask<EssenceParamWord, Void, Void>{

        @Override
        protected Void doInBackground(EssenceParamWord... essenceParamWords) {
            essParamWordDao.insert(essenceParamWords[0]);
            return null;
        }
    }

    class ParamWordUpdateAsyncTask extends AsyncTask<EssenceParamWord, Void, Void>{

        @Override
        protected Void doInBackground(EssenceParamWord... essenceParamWords) {
            essParamWordDao.update(essenceParamWords[0]);
            return null;
        }
    }

    class ParamWordDeleteAsyncTask extends AsyncTask<EssenceParamWord, Void, Void>{

        @Override
        protected Void doInBackground(EssenceParamWord... essenceParamWords) {
            essParamWordDao.delete(essenceParamWords[0]);
            return null;
        }
    }
    //endregion
    //endregion
    //endregion
}
