package com.example.tukyhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Essence> ess_list = new ArrayList<>();
        ess_list.add(new Essence(EssenceType.Home, "Home", "_", 0));
        ess_list.add(new Essence(EssenceType.Home, "Home2", "_", 0));
        ess_list.add(new Essence(EssenceType.Home, "Home3", "_", 0));

        GridView essence_grid = (GridView)findViewById(R.id.gv_essence);
        EssenceGridAdapter es_grid_adapter = new EssenceGridAdapter(getApplicationContext(), ess_list);
        essence_grid.setAdapter(es_grid_adapter);
    }
}