package com.example.tukyhelper.Model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.tukyhelper.Model.EssenceRoom.Essence;
import com.example.tukyhelper.Model.EssenceRoom.EssenceDao;
import com.example.tukyhelper.Model.EssenceRoom.EssenceDatabase;
import com.example.tukyhelper.Model.EssenceRoom.EssenceType;
import com.example.tukyhelper.Model.EssenceRoom.EssenceTypeDao;

import java.util.List;

public class EssenceRepository {

    private LiveData<List<Essence>> essData;
    private final LiveData<List<EssenceType>> essTypeData;
    private EssenceDao essDao;
    private EssenceTypeDao essTypeDao;

    public EssenceRepository(Application app) {
        EssenceDatabase essenceDb = EssenceDatabase.getDatabase(app);

        essDao = essenceDb.essenceDao();
        essTypeDao = essenceDb.essenceTypeDao();

        essData = essDao.getAll();
        essTypeData = essTypeDao.getAll();
    }

    //  Essence API
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

    //  EssenceType API
    public LiveData<List<EssenceType>> getAllTypes(){
        return essTypeData;
    }
}
