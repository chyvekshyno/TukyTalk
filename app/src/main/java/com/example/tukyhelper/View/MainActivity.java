package com.example.tukyhelper.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tukyhelper.Model.EssenceRoom.Essence;
import com.example.tukyhelper.Model.EssenceRoom.EssenceType;
import com.example.tukyhelper.R;
import com.example.tukyhelper.ViewModel.EssenceViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv_essence_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try { this.getSupportActionBar().hide(); }
        catch (NullPointerException e){}


        setContentView(R.layout.activity_main);


        // Create tested Essences
//        ArrayList<Essence> ess_list = new ArrayList<>();
//        ess_list.add(new Essence(1, 1, "Home  ", "_", 0));
//        ess_list.add(new Essence(2, 1, "Car", "_", 0));
//        ess_list.add(new Essence(4, 1, "Car(2)", "_", 0));

        // Set adapter to RecycleView
        rv_essence_list = (RecyclerView) findViewById(R.id.rv_essence_list);
        rv_essence_list.setLayoutManager(new GridLayoutManager(this, 3));
        final EssenceRVAdapter adapter = new EssenceRVAdapter();
        rv_essence_list.setAdapter(adapter);

        EssenceViewModel essVM = ViewModelProviders.of(this).get(EssenceViewModel.class);
        essVM.getAllEssences().observe(this, new Observer<List<Essence>>(){
            @Override
            public void onChanged(List<Essence> essences) {
                adapter.setEssences(essences);
            }
        });

        // set onClick for fab
        FloatingActionButton fab_add = (FloatingActionButton) findViewById(R.id.fab_essence_add);
        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EssenceAddActivity.class);
                startActivity(intent);
            }
        });
    }
}