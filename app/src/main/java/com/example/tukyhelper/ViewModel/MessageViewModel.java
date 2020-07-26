package com.example.tukyhelper.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.tukyhelper.Model.MessageRoom.EssenceMessage;
import com.example.tukyhelper.Model.Repositories.MessageRepository;

import java.util.List;

public class MessageViewModel extends AndroidViewModel {

    MessageRepository repos;

    public MessageViewModel(@NonNull Application app) {
        super(app);

        repos = new MessageRepository(app);
    }

    //region API

    public LiveData<List<EssenceMessage>> getAll(){
        return repos.getAll();
    }

    public LiveData<List<EssenceMessage>> getAllForEssence(int id){
        return repos.getAllForEssence(id);
    }

    public LiveData<List<EssenceMessage>> getImportantForEssence(int id){
        return repos.getImportantForEssence(id);
    }

    public LiveData<List<EssenceMessage>> getPropForEssence(int id){
        return repos.getPropForEssence(id);
    }

    public LiveData<List<EssenceMessage>> getAdvForEssence(int id){
        return repos.getAdvForEssence(id);
    }

    public void insert(EssenceMessage message){
        repos.insert(message);
    }

    public void update(EssenceMessage message){
        repos.insert(message);
    }

    public void delete(EssenceMessage message){
        repos.insert(message);
    }

    //endregion
}
