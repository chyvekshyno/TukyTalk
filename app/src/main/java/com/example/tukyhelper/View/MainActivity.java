package com.example.tukyhelper.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridView;

import com.example.tukyhelper.Model.EssenceRoom.Essence;
import com.example.tukyhelper.Model.EssenceRoom.EssenceType;
import com.example.tukyhelper.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv_essence_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Essence> ess_list = new ArrayList<>();
        ess_list.add(new Essence(1, 1, "Home", "_", 0));
        ess_list.add(new Essence(2, 1, "Home2", "_", 0));
        ess_list.add(new Essence(4, 1, "Home3", "_", 0));

        rv_essence_list = (RecyclerView) findViewById(R.id.rv_essence_list);
        rv_essence_list.setLayoutManager(new GridLayoutManager(this, 3));
        EssenceRVAdapter adapter = new EssenceRVAdapter();
        adapter.setEssences(ess_list);
        rv_essence_list.setAdapter(adapter);
    }
}