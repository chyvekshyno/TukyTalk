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
    private final LiveData<List<EssenceType>> essTypeData;

    public EssenceViewModel(@NonNull Application app) {
        super(app);
        essRepos = new EssenceRepository(app);
        essData = essRepos.getAllEssences();
        essTypeData = essRepos.getAllTypes();
    }

    public LiveData<List<Essence>> getAllEssences(){
        return essData;
    }

    public LiveData<List<EssenceType>> getAllTypes(){
        return essTypeData;
    }

    public void insert(Essence ess) {
        essRepos.insert(ess);
    }
}
