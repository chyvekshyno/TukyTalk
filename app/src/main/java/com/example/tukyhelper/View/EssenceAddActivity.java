package com.example.tukyhelper.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tukyhelper.R;

public class EssenceAddActivity extends AppCompatActivity {

    RecyclerView rv_esstype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try { this.getSupportActionBar().hide(); }
        catch (NullPointerException e){}

        setContentView(R.layout.activity_essence_add);

        // set gridlayout for recyclerview with essence types
        rv_esstype = (RecyclerView) findViewById(R.id.rv_esstype);
        rv_esstype.setLayoutManager(new GridLayoutManager(this, 4));

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
