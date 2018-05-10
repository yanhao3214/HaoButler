package com.gogo.haobutler.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.gogo.haobutler.R;

/**
 * @author: 闫昊
 * @date: 2018/4/15
 * @function: Activity基类
 * 1.统一的属性
 * 2.统一的接口
 * 3.统一的方法
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{
    public ActionBar actionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar = getSupportActionBar();
        actionBar.setElevation(0);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    /**
     * 为什么无效？？？
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
