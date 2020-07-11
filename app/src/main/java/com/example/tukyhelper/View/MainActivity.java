package com.example.tukyhelper.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.example.tukyhelper.Model.EssenceRoom.Essence;
import com.example.tukyhelper.Model.EssenceRoom.EssenceType;
import com.example.tukyhelper.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv_essence_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create tested Essences
        ArrayList<Essence> ess_list = new ArrayList<>();
        ess_list.add(new Essence(1, 1, "Home", "_", 0));
        ess_list.add(new Essence(2, 1, "Home2", "_", 0));
        ess_list.add(new Essence(4, 1, "Home3", "_", 0));

        // Set adapter to RecycleView
        rv_essence_list = (RecyclerView) findViewById(R.id.rv_essence_list);
        rv_essence_list.setLayoutManager(new GridLayoutManager(this, 3));
        EssenceRVAdapter adapter = new EssenceRVAdapter();
        adapter.setEssences(ess_list);
        rv_essence_list.setAdapter(adapter);

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