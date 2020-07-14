package com.example.tukyhelper.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Adapter;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tukyhelper.Model.EssenceRoom.EssenceType;
import com.example.tukyhelper.R;
import com.example.tukyhelper.View.Adapters.EssenceTypeRVAdapter;
import com.example.tukyhelper.ViewModel.EssenceTypeViewModel;

import java.util.List;

public class EssenceAddActivity extends AppCompatActivity {

    RecyclerView rv_esstype;
    EssenceTypeViewModel essTypeVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try { this.getSupportActionBar().hide(); }
        catch (NullPointerException e){}

        setContentView(R.layout.activity_essence_add);

        // set gridlayout for recyclerview with essence types
        rv_esstype = (RecyclerView) findViewById(R.id.rv_esstype);
        rv_esstype.setLayoutManager(new GridLayoutManager(this, 3));

        // setup adapter
        final EssenceTypeRVAdapter adapter = new EssenceTypeRVAdapter();
        rv_esstype.setAdapter(adapter);

        // subscribe adapter for viewmodel data
        essTypeVM = ViewModelProviders.of(this).get(EssenceTypeViewModel.class);
        essTypeVM.getAllTypes().observe(this, new Observer<List<EssenceType>>() {
            @Override
            public void onChanged(List<EssenceType> essenceTypes) {
                adapter.setData(essenceTypes);
            }
        });

        // set onClick method for back btn
        ImageButton ibt_back = (ImageButton) findViewById(R.id.imbtn_addess_back);
        ibt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EssenceAddActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
