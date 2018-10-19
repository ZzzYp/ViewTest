package com.mine.test.fraagment.fragmentAdapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mine.test.fraagment.FirstFragment;

import java.util.ArrayList;
import java.util.List;

public class MineFragmentPagerAdapter extends FragmentPagerAdapter {

    private FirstFragment fragment;
    private List<Fragment> fragmentList = new ArrayList<>();

    public MineFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        //fragment = new FirstFragment();
        //fragment.setContent("postion" + i);
        if (fragmentList.size() == 0)
            return null;

        return fragmentList.get(i);
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String name = "tag" + position;

        return name;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }


    public List<Fragment> getFragmentList() {
        return fragmentList;
    }

    public void setFragmentList(List<Fragment> fragmentList) {
        this.fragmentList = fragmentList;
    }
}
