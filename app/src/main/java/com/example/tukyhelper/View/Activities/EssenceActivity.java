package com.example.tukyhelper.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.tukyhelper.Model.ParamRoom.EssenceParam;
import com.example.tukyhelper.R;
import com.example.tukyhelper.View.Adapters.MessagePagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class EssenceActivity extends AppCompatActivity {

    ViewPager pager;
    ImageButton ibt_home;
    ImageButton ibt_ess_icon;
    MessagePagerAdapter msg_pager_adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_essence);

        setHomeButton();
        setEssenceIconButton();
        setMessagePager();
    }

    void setHomeButton(){
        ibt_home = (ImageButton) findViewById(R.id.ibt_essence_home);
        ibt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    void setEssenceIconButton(){
        ibt_ess_icon = (ImageButton) findViewById(R.id.ibt_essence_icon);
        ibt_ess_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EssenceActivity.this, EssenceParamsActivity.class);
                startActivity(intent);
            }
        });
    }

    void setMessagePager(){
        pager = (ViewPager) findViewById(R.id.pager_essence_msg);
        msg_pager_adapter = new MessagePagerAdapter(getSupportFragmentManager());
        pager.setAdapter(msg_pager_adapter);

        // setup tabs
        ((TabLayout) findViewById(R.id.tabl_essence_msg)).setupWithViewPager(pager);
    }
}