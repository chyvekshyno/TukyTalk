package com.example.tukyhelper.View.CustomViews;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class NonSwipeViewPager extends ViewPager {


    public NonSwipeViewPager(@NonNull Context context) {
        super(context);
    }

    public NonSwipeViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
}
