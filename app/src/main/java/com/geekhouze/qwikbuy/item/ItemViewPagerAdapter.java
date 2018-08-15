package com.geekhouze.qwikbuy.item;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ItemViewPagerAdapter extends FragmentPagerAdapter{

    private final List<Fragment> itemFragmentList = new ArrayList<>();
    private final List<String> itemFragmentTitleList = new ArrayList<>();

    public ItemViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return itemFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return itemFragmentTitleList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return itemFragmentTitleList.get(position);
    }

    public void addFragment(Fragment fragment, String title){
        itemFragmentList.add(fragment);
        itemFragmentTitleList.add(title);
    }

}
