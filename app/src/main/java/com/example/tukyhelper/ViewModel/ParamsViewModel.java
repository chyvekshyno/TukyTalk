package com.example.tukyhelper.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.tukyhelper.Model.ParamRoom.EssenceParam;
import com.example.tukyhelper.Model.ParamRoom.EssenceParamWord;
import com.example.tukyhelper.Model.Repositories.ParamsRepository;

import java.util.List;

public class ParamsViewModel extends AndroidViewModel {

    ParamsRepository repos;

    public ParamsViewModel(@NonNull Application app) {
        super(app);

        repos = new ParamsRepository(app);
    }

    //region API

    public LiveData<List<EssenceParam>> getAllParams(){
        return repos.getAllParams();
    }

    public LiveData<List<EssenceParam>> getAllByEssenceId(int id){
        return repos.getAllParamsByEssenceId(id);
    }

    public LiveData<List<EssenceParamWord>> getAllParamDic(){
        return repos.getAllParamDic();
    }

    public LiveData<List<EssenceParamWord>> getParamDicForEssenceType(int typeId){
        return repos.getParamDicForEssenceType(typeId);
    }

    public LiveData<List<EssenceParamWord>> getParamDicForEssenceTypeOrdered(int typeId){
        return repos.getParamDicForEssenceTypeOrdered(typeId);
    }
    //endregion
}
