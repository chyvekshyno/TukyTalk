package com.example.tukyhelper.View;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
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

    ImageView iv_icon;
    EditText et_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try { this.getSupportActionBar().hide(); }
        catch (NullPointerException e){}

        setContentView(R.layout.activity_essence_add);

        iv_icon = (ImageView) findViewById(R.id.iv_addess_icon);
        et_name = (EditText) findViewById(R.id.et_addess_name);

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
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });

        // set onClick method for back btn
        Button bt_create = (Button) findViewById(R.id.bt_essence_create);
        bt_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("type", adapter.getLastSelectedId());
                intent.putExtra("name", et_name.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

}
