package com.gogo.haobutler.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gogo.haobutler.R;

/**
 * @author: 闫昊
 * @date: 2018/4/12
 * @function:
 */

public class ButlerFragment extends BaseFragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_butler_layout, container,false);
        initData();
        initView();
        return view;
    }

    private void initView() {

    }

    private void initData() {
    }
}
