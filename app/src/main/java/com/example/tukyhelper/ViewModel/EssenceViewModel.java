package com.example.tukyhelper.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.tukyhelper.Model.EssenceRepository;
import com.example.tukyhelper.Model.EssenceRoom.Essence;
import com.example.tukyhelper.Model.EssenceRoom.EssenceType;

import java.util.List;

public class EssenceViewModel extends AndroidViewModel {

    private EssenceRepository essRepos;
    private LiveData<List<Essence>> essData;

    public EssenceViewModel(@NonNull Application app) {
        super(app);
        essRepos = new EssenceRepository(app);
        essData = essRepos.getAllEssences();
    }

    public LiveData<List<Essence>> getAllEssences(){
        return essData;
    }

    public void insert(Essence ess) {
        essRepos.insert(ess);
    }
}
