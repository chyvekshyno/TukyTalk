package com.example.tukyhelper.View;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.tukyhelper.R;
import com.example.tukyhelper.View.Adapters.MessagePagerAdapter;

public class EssenceActivity extends AppCompatActivity {

    ViewPager pager;
    MessagePagerAdapter msg_pager_adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.essence_activity);

//        pager = (ViewPager) findViewById(R.id.pager_essence_msg);
//        msg_pager_adapter = new MessagePagerAdapter(getSupportFragmentManager());
//        pager.setAdapter(msg_pager_adapter);
    }
}
