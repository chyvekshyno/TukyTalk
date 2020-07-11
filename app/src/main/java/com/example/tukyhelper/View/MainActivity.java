package com.example.tukyhelper.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.tukyhelper.Model.EssenceRoom.Essence;
import com.example.tukyhelper.Model.EssenceRoom.EssenceType;
import com.example.tukyhelper.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Essence> ess_list = new ArrayList<>();
        ess_list.add(new Essence(1, 1, "Home", "_", 0));
        ess_list.add(new Essence(2, 1, "Home2", "_", 0));
        ess_list.add(new Essence(4, 1, "Home3", "_", 0));

        GridView essence_grid = (GridView)findViewById(R.id.gv_essence);
        EssenceGridAdapter es_grid_adapter = new EssenceGridAdapter(getApplicationContext(), ess_list);
        essence_grid.setAdapter(es_grid_adapter);
    }
}