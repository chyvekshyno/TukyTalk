package com.example.tukyhelper.View.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.tukyhelper.View.Fragments.MessageFragment;

public class MessagePagerAdapter extends FragmentStatePagerAdapter {

    static final int PAGE_COUNT = 3;
    final int essenceId;

    public MessagePagerAdapter(@NonNull FragmentManager fm, int essenceId) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.essenceId = essenceId;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return MessageFragment.getInstance(position, essenceId);
    }

    @Override
    public int getCount() {
        return MessageFragment.TITLES.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return MessageFragment.TITLES[position];
    }
}
