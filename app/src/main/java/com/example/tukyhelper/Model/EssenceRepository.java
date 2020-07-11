package com.example.tukyhelper.Model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.tukyhelper.Model.EssenceRoom.Essence;
import com.example.tukyhelper.Model.EssenceRoom.EssenceDao;
import com.example.tukyhelper.Model.EssenceRoom.EssenceDatabase;

import java.util.List;

public class EssenceRepository {

    private LiveData<List<Essence>> essData;
    private EssenceDao essDao;

    public EssenceRepository(Application app) {
        EssenceDatabase essenceDb = EssenceDatabase.getDatabase(app);
        essDao = essenceDb.essenceDao();
        essData = essDao.getAll();
    }

    //  API

    public void insert(Essence ess){
        essDao.insert(ess);
    }

    public void delete(Essence ess){
        essDao.delete(ess);
    }

    public void update(Essence ess){
        essDao.update(ess);
    }

    public LiveData<List<Essence>> getAll(){
        return essData;
    }

}
