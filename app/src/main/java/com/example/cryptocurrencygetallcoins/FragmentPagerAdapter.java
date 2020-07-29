package com.example.cryptocurrencygetallcoins;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FragmentPagerAdapter extends FragmentStatePagerAdapter {
    public static final int NUM_PAGES = 2;

    public FragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                PageOne pageOne = new PageOne();
                return pageOne;
            case 1:
                PageTwo pageTwo = new PageTwo();
                return pageTwo;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
