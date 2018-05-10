package com.gogo.haobutler.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.gogo.haobutler.fragment.BaseFragment;

import java.util.List;

/**
 * @author: 闫昊
 * @date: 2018/4/12
 * @function:
 */

public class HaoFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> fragmentList;

    public HaoFragmentPagerAdapter(FragmentManager fm, List<BaseFragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
