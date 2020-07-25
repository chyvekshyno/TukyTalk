package com.example.tukyhelper.Model.Repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.tukyhelper.Model.EssenceDatabase;
import com.example.tukyhelper.Model.ParamRoom.EssenceParam;
import com.example.tukyhelper.Model.ParamRoom.EssenceParamDao;
import com.example.tukyhelper.Model.ParamRoom.EssenceParamWord;
import com.example.tukyhelper.Model.ParamRoom.EssenceParamWordDao;

import java.util.List;

public class ParamsRepository {
    //region Daos
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
        essParamDao.insert(param);
    }

    public  void update(EssenceParam param){
        essParamDao.update(param);
    }

    public  void delete(EssenceParam param){
        essParamDao.delete(param);
    }

    public LiveData<List<EssenceParam>> getAllParams(){
        return essParamDao.getAll();
    }

    public LiveData<List<EssenceParam>> getAllParamsByEssenceId(int id){
        return essParamDao.getByEssenceId(id);
    }

    //endregion

    //region EssenceParamWord API
    public  void insert(EssenceParamWord paramWord){
        essParamWordDao.insert(paramWord);
    }

    public  void update(EssenceParamWord paramWord){
        essParamWordDao.update(paramWord);
    }

    public  void delete(EssenceParamWord paramWord){
        essParamWordDao.delete(paramWord);
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

    //endregion

    //endregion
}
