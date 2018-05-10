package com.gogo.haobutler.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gogo.haobutler.R;

/**
 * @author: 闫昊
 * @date: 2018/4/12
 * @function:
 */

public class MineFragment extends BaseFragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mine_layout, container, false);
        return view;
    }
}
