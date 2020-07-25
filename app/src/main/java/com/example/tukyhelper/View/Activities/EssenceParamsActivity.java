package com.example.tukyhelper.View.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tukyhelper.R;

public class EssenceParamsActivity extends AppCompatActivity {

    RecyclerView rv_params;
    ImageButton ibt_back;
    ImageView iv_ess_icon;
    TextView tv_ess_name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_essence_params);

        setBackButton();

    }

    void setBackButton(){
        ibt_back = (ImageButton) findViewById(R.id.ibt_back);
        ibt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    void setRVParams(){
        rv_params = (RecyclerView) findViewById(R.id.rv_params);
        rv_params.setLayoutManager(new GridLayoutManager(this, 2));

    }
}
