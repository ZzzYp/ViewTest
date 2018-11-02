package com.mine.test.fragment.fragmentAdapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mine.test.fragment.FirstFragment;

import java.util.ArrayList;
import java.util.List;

public class MineFragmentPagerAdapter extends FragmentPagerAdapter {

    private FirstFragment fragment;
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> tagNamesList = new ArrayList<>();

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
        if (null == tagNamesList) {
            return "null";
        }
        if (tagNamesList.size() >= position) {
            return tagNamesList.get(position);
        }
        //String name = "tag" + position;

        return "tag";
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

    public List<String> getTagNamesList() {
        return tagNamesList;
    }

    public void setTagNamesList(List<String> tagNamesList) {
        this.tagNamesList = tagNamesList;
    }
}
