package com.example.tukyhelper.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tukyhelper.Model.EssenceRoom.Essence;
import com.example.tukyhelper.R;
import com.example.tukyhelper.View.Adapters.EssenceRVAdapter;
import com.example.tukyhelper.ViewModel.EssenceViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv_essence_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Remove header
        try { this.getSupportActionBar().hide(); }
        catch (NullPointerException e){}

        setContentView(R.layout.activity_main);

        // Set adapter to RecycleView
        rv_essence_list = (RecyclerView) findViewById(R.id.rv_essence_list);
        rv_essence_list.setLayoutManager(new GridLayoutManager(this, 3));
        final EssenceRVAdapter adapter = new EssenceRVAdapter();
        rv_essence_list.setAdapter(adapter);

        EssenceViewModel essVM = ViewModelProviders.of(this).get(EssenceViewModel.class);
        essVM.getAllEssences().observe(this, new Observer<List<Essence>>(){
            @Override
            public void onChanged(List<Essence> essences) {
                adapter.setData(essences);
            }
        });

        // set onClick for fab
        FloatingActionButton fab_add = (FloatingActionButton) findViewById(R.id.fab_essence_add);
        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EssenceAddActivity.class);
                startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }
}