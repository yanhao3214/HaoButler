package com.gogo.haobutler.ui;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;

import com.gogo.haobutler.R;
import com.gogo.haobutler.adapter.HomeFragmentPagerAdapter;
import com.gogo.haobutler.fragment.BaseFragment;
import com.gogo.haobutler.fragment.BasketballFragment;
import com.gogo.haobutler.fragment.ButlerFragment;
import com.gogo.haobutler.fragment.MineFragment;
import com.gogo.haobutler.fragment.MoocFragment;
import com.gogo.haobutler.fragment.WeChatFragment;
import com.gogo.haobutler.utils.L;
import com.gogo.haobutler.utils.ShareUtil;
import com.tencent.bugly.crashreport.CrashReport;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 闫昊
 * @date: 2018/4/12
 * @function: SharedPreferences封装
 */

public class MainActivity extends BaseActivity {
    private String[] titles;
    private List<BaseFragment> fragmentList;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private HomeFragmentPagerAdapter butlerAdapter;
    private FloatingActionButton btnSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
        initData();
        initView();
    }

    private void initData() {
        titles = getResources().getStringArray(R.array.viewPager_title);
        fragmentList = new ArrayList<>();
        fragmentList.add(new ButlerFragment());
        fragmentList.add(new WeChatFragment());
        fragmentList.add(new MoocFragment());
        fragmentList.add(new BasketballFragment());
        fragmentList.add(new MineFragment());
        butlerAdapter = new HomeFragmentPagerAdapter(
                getSupportFragmentManager(), titles, fragmentList);
        ShareUtil.putString(this,"name","闫昊");
        ShareUtil.clear(this);
        L.e(ShareUtil.getString(this,"name","富翁"));
    }

    private void initView() {
//        CrashReport.testJavaCrash();
        tabLayout = findViewById(R.id.table_layout_home);
        viewPager = findViewById(R.id.view_pager_home);
        btnSetting = findViewById(R.id.fab_setting);
        //ViewPager预加载
        viewPager.setOffscreenPageLimit(fragmentList.size());
        viewPager.setAdapter(butlerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
                L.e("onPageScrolled-------->position = " + position +
                        "  positionOffset = " + positionOffset +
                        "  positionOffsetPixels = " + positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                L.e("onPageSelected-------->position = " + position);
                btnSetting.setVisibility(position == 0 ? View.GONE : View.VISIBLE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                L.e("onPageScrollStateChanged-------->state = " + state);
            }
        });
        btnSetting.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_setting:
                startActivity(new Intent(this, SettingActivity.class));
                break;
            default:
                break;
        }
    }
}
