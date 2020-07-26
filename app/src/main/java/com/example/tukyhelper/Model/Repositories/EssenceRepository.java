package com.example.tukyhelper.Model.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.tukyhelper.Model.EssenceDatabase;
import com.example.tukyhelper.Model.EssenceRoom.Essence;
import com.example.tukyhelper.Model.EssenceRoom.EssenceDao;
import com.example.tukyhelper.Model.EssenceRoom.EssenceType;
import com.example.tukyhelper.Model.EssenceRoom.EssenceTypeDao;

import java.util.List;

public class EssenceRepository {

    //region Fields
    private LiveData<List<Essence>> essData;
    private final LiveData<List<EssenceType>> essTypeData;

    //region Daos
    private EssenceDao essDao;
    private EssenceTypeDao essTypeDao;
    //endregion
    //endregion

    public EssenceRepository(Application app) {
        EssenceDatabase essenceDb = EssenceDatabase.getDatabase(app);

        essDao = essenceDb.essenceDao();
        essTypeDao = essenceDb.essenceTypeDao();

        essData = essDao.getAll();
        essTypeData = essTypeDao.getAll();
    }

    //region API

    //region  Essence API
    public void insert(Essence ess){
        new EssenceInsertAsyncTask().execute(ess);
    }

    public void delete(Essence ess){
        new EssenceDeleteAsyncTask().execute(ess);
    }

    public void update(Essence ess){
        new EssenceUpdateAsyncTask().execute(ess);
    }

    public LiveData<List<Essence>> getAllEssences(){
        return essData;
    }


    //region AsyncTasks
    class EssenceInsertAsyncTask extends AsyncTask<Essence, Void, Void>{

        @Override
        protected Void doInBackground(Essence... essences) {
            essDao.insert(essences[0]);
            return null;
        }
    }

    class EssenceDeleteAsyncTask extends AsyncTask<Essence, Void, Void>{

        @Override
        protected Void doInBackground(Essence... essences) {
            essDao.delete(essences[0]);
            return null;
        }
    }

    class EssenceUpdateAsyncTask extends AsyncTask<Essence, Void, Void>{

        @Override
        protected Void doInBackground(Essence... essences) {
            essDao.update(essences[0]);
            return null;
        }
    }

    //endregion
    //endregion

    //region  EssenceType API
    public LiveData<List<EssenceType>> getAllTypes(){
        return essTypeData;
    }

    //endregion
    //endregion
}
