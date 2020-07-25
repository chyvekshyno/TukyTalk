package com.example.tukyhelper.View.Activities;

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

    EssenceViewModel essVM;
    final int REQUEST_CODE_CREATE = 1;

    public final String KEY_ESSENCE_ID = "ESSENCE_ID";
    public final String KEY_ESSENCE_TYPE_ID = "ESSENCE_TYPE_ID";

    //region Override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        essVM = ViewModelProviders.of(this).get(EssenceViewModel.class);

        setAddEssenceFAB();
        setEssenceRV();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CREATE && resultCode == RESULT_OK){

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    Essence essence = new Essence(data.getIntExtra("type", 1));
                    essence.setName(data.getStringExtra("name"));
                    essence.setIcon("iconpath");
                    essence.setNftCount(0);
                    essVM.insert(essence);
                }
            });
            t.start();
        }
    }

    //endregion

    //region Setup Methods

    void setEssenceRV(){
        RecyclerView  rv_essence_list = (RecyclerView) findViewById(R.id.rv_essence_list);
        rv_essence_list.setLayoutManager(new GridLayoutManager(this, 3));
        final EssenceRVAdapter adapter = new EssenceRVAdapter();
        rv_essence_list.setAdapter(adapter);

        essVM.getAllEssences().observe(this, adapter::setData);

        adapter.setOnEssenceClickListener((View v, int id, int typeId) -> {
            Intent intent = new Intent(MainActivity.this, EssenceActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_ESSENCE_ID, id);
            bundle.putInt(KEY_ESSENCE_TYPE_ID, typeId);
            startActivity(intent, bundle);
        });
    }

    void setAddEssenceFAB(){
        FloatingActionButton fab_add = (FloatingActionButton) findViewById(R.id.fab_essence_add);
        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EssenceAddActivity.class);
                startActivityForResult(intent, REQUEST_CODE_CREATE);
            }
        });
    }
    //endregion
}