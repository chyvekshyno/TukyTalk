package com.example.tukyhelper.View.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
        return MessageFragment.TITLES.length;
    }   //  I don't like it

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return MessageFragment.TITLES[position];
    }
}
