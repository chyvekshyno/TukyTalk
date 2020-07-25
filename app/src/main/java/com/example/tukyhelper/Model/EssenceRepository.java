package com.example.tukyhelper.Model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.tukyhelper.Model.EssenceRoom.Essence;
import com.example.tukyhelper.Model.EssenceRoom.EssenceDao;
import com.example.tukyhelper.Model.EssenceRoom.EssenceType;
import com.example.tukyhelper.Model.EssenceRoom.EssenceTypeDao;
import com.example.tukyhelper.Model.ParamRoom.EssenceParam;
import com.example.tukyhelper.Model.ParamRoom.EssenceParamDao;
import com.example.tukyhelper.Model.ParamRoom.EssenceParamWord;
import com.example.tukyhelper.Model.ParamRoom.EssenceParamWordDao;

import java.util.List;

public class EssenceRepository {

    //region Fields
    private LiveData<List<Essence>> essData;
    private final LiveData<List<EssenceType>> essTypeData;
    private LiveData<List<EssenceParam>> essParamData;
    private LiveData<List<EssenceParamWord>> essParamWordData;

    //region Daos
    private EssenceDao essDao;
    private EssenceTypeDao essTypeDao;
    private EssenceParamDao essParamDao;
    private EssenceParamWordDao essParamWordDao;
    //endregion
    //endregion

    public EssenceRepository(Application app) {
        EssenceDatabase essenceDb = EssenceDatabase.getDatabase(app);

        essDao = essenceDb.essenceDao();
        essTypeDao = essenceDb.essenceTypeDao();
        essParamDao = essenceDb.essenceParamDao();
        essParamWordDao = essenceDb.essenceParamWordDao();

        essData = essDao.getAll();
        essTypeData = essTypeDao.getAll();
        //essParamData = essParamDao.getAll();
        essParamWordData = essParamWordDao.getAll();
    }

    //region API

    //region  Essence API
    public void insert(Essence ess){
        essDao.insert(ess);
    }

    public void delete(Essence ess){
        essDao.delete(ess);
    }

    public void update(Essence ess){
        essDao.update(ess);
    }

    public LiveData<List<Essence>> getAllEssences(){
        return essData;
    }

    //endregion

    //region  EssenceType API
    public LiveData<List<EssenceType>> getAllTypes(){
        return essTypeData;
    }

    //endregion

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
        return essParamData;
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
        return essParamWordData;
    }

    //endregion

    //endregion
}
