package com.example.tukyhelper.View.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tukyhelper.View.EssenceActivity;
import com.example.tukyhelper.View.Fragments.MessageFragment;

import java.util.ArrayList;

public class MessagePagerAdapter extends FragmentPagerAdapter {

    static final int PAGE_COUNT = 3;

    public MessagePagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return MessageFragment.getInstance(position);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }   //  I don't like it
}
