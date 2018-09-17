package com.mine.test.fraagment.fragmentAdapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mine.test.fraagment.FirstFragment;

public class MineFragmentPagerAdapter extends FragmentPagerAdapter {

    private FirstFragment fragment;

    public MineFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        fragment = new FirstFragment();
        fragment.setContent("postion" + i);
        return fragment;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String name = "tag" + position;

        return name;
    }

    @Override
    public int getCount() {
        return 7;
    }
}
