package com.example.tukyhelper.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.tukyhelper.Model.EssenceRepository;
import com.example.tukyhelper.Model.EssenceRoom.EssenceType;
import com.example.tukyhelper.Model.EssenceRoom.EssenceTypeDao;

import java.util.List;

public class EssenceTypeViewModel extends AndroidViewModel {

    private final LiveData<List<EssenceType>> essTypeData;
    private EssenceTypeDao essTypeDao;

    public EssenceTypeViewModel(@NonNull Application app) {
        super(app);
        essTypeData = new EssenceRepository(app).getAllTypes();
    }

    public LiveData<List<EssenceType>> getAllTypes(){
        return essTypeData;
    }
}
