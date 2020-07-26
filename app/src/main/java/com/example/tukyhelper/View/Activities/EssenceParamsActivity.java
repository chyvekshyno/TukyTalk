package com.example.tukyhelper.View.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tukyhelper.Model.ParamRoom.EssenceParam;
import com.example.tukyhelper.Model.ParamRoom.EssenceParamWord;
import com.example.tukyhelper.R;
import com.example.tukyhelper.View.Adapters.ParamRVAdapter;
import com.example.tukyhelper.ViewModel.ParamsViewModel;

import java.util.List;

public class EssenceParamsActivity extends AppCompatActivity {

    final String KEY_ESSENCE_ID = "ESSENCE_ID";
    final String KEY_ESSENCE_TYPE_ID = "ESSENCE_TYPE_ID";
    int ESSENCE_ID;
    int ESSENCE_TYPE_ID;

    RecyclerView rv_params;
    ImageButton ibt_back;
    ImageView iv_ess_icon;
    TextView tv_ess_name;

    ParamsViewModel paramVM;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_essence_params);

        ESSENCE_ID = getIntent().getIntExtra(KEY_ESSENCE_ID, 0);
        ESSENCE_TYPE_ID = getIntent().getIntExtra(KEY_ESSENCE_TYPE_ID, 0);
        paramVM = ViewModelProviders.of(this).get(ParamsViewModel.class);

        setBackButton();
        setParamsRV();

        //Debug();
    }

    void setBackButton() {
        ibt_back = (ImageButton) findViewById(R.id.ibt_back);
        ibt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    void setParamsRV() {
        rv_params = (RecyclerView) findViewById(R.id.rv_params);
        rv_params.setLayoutManager(new LinearLayoutManager(this));

        ParamRVAdapter adapter = new ParamRVAdapter();
        rv_params.setAdapter(adapter);

        paramVM.getAllByEssenceId(ESSENCE_ID)
                .observe(this, adapter::setParams);

        paramVM.getParamDicForEssenceTypeOrdered(ESSENCE_TYPE_ID)
                .observe(this, adapter::setParamDic);
    }

}
