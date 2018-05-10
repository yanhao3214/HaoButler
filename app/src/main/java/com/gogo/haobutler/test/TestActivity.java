package com.gogo.haobutler.test;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.gogo.haobutler.R;
import com.gogo.haobutler.adapter.HaoFragmentPagerAdapter;
import com.gogo.haobutler.fragment.BaseFragment;
import com.gogo.haobutler.fragment.BasketballFragment;
import com.gogo.haobutler.fragment.ButlerFragment;
import com.gogo.haobutler.fragment.MineFragment;
import com.gogo.haobutler.fragment.WeChatFragment;
import java.util.ArrayList;
import java.util.List;

/**
 * @author GPT-2964
 */
public class TestActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private ViewPager viewPager;
    private List<BaseFragment> fragmentList = new ArrayList<>();
    private HaoFragmentPagerAdapter haoFragmentPagerAdapter;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setTitle("我是Title");
        setContentView(R.layout.activity_test_layout);
        initData();
        initView();
    }

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

    private void initData() {
        fragmentList.add(new ButlerFragment());
        fragmentList.add(new WeChatFragment());
        fragmentList.add(new BasketballFragment());
        fragmentList.add(new MineFragment());
        haoFragmentPagerAdapter = new HaoFragmentPagerAdapter(getSupportFragmentManager(), fragmentList);
    }

    private void initView() {
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(haoFragmentPagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(this);
        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
        findViewById(R.id.btn_3).setOnClickListener(this);
        findViewById(R.id.btn_4).setOnClickListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                findViewById(R.id.btn_1).setBackgroundColor(Color.RED);
                break;
            case 1:
                findViewById(R.id.btn_2).setBackgroundColor(Color.BLUE);
                break;
            case 2:
                findViewById(R.id.btn_3).setBackgroundColor(Color.YELLOW);
                break;
            default:
                findViewById(R.id.btn_4).setBackgroundColor(Color.GRAY);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                viewPager.setCurrentItem(0);
                break;
            case R.id.btn_2:
                viewPager.setCurrentItem(1);
                break;
            case R.id.btn_3:
                viewPager.setCurrentItem(2);
                break;
            case R.id.btn_4:
                viewPager.setCurrentItem(3);
                break;
            default:
                break;
        }
    }
}
