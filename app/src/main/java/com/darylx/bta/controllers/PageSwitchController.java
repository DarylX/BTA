package com.darylx.bta.controllers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.darylx.bta.views.CabinetView;

/**
 * Created by DarylX on 2/13/2015.
 */
public class PageSwitchController extends FragmentStatePagerAdapter {

    public PageSwitchController(FragmentManager fm){
        super(fm);

    }

    @Override
    public Fragment getItem(int i) {
        if(i == 1)
            return new CabinetView();
        else
            return new Fragment();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
