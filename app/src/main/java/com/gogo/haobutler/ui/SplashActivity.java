package com.gogo.haobutler.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.gogo.haobutler.R;
import com.gogo.haobutler.utils.ShareUtil;
import com.gogo.haobutler.utils.UtilTools;

import static com.gogo.haobutler.utils.Consts.HANDLER_SPLASH;
import static com.gogo.haobutler.utils.Consts.IS_FIRST_RUNNING;
import static com.gogo.haobutler.utils.Consts.SPLASH_TIME;

/**
 * @author: 闫昊
 * @date: 2018/4/15
 * @function: Splash页面
 * 1.展示公司、个人Logo
 * 2.广告
 * 3.初始化数据
 * 4.自定义字体
 */

public class SplashActivity extends AppCompatActivity {
    private TextView tvSplash;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case HANDLER_SPLASH:
                    Intent intent = new Intent(SplashActivity.this,
                            isFirst() ? GuideActivity.class : LoginActivity.class);
                    startActivity(intent);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_splash_layout);
        initView();
    }

    private void initView() {
        tvSplash = findViewById(R.id.tv_splash);
        handler.sendEmptyMessageDelayed(HANDLER_SPLASH, SPLASH_TIME);
        //设置字体，不成功：华为定制系统的原因
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/FONT.TTF");
        tvSplash.setTypeface(typeface);
//        UtilTools.setFont(this,tvSplash);
    }

    /**
     * 判断程序是否是第一次运行
     * @return
     */
    private boolean isFirst() {
        Boolean first = ShareUtil.getBoolean(this, IS_FIRST_RUNNING, true);
        if (first) {
            ShareUtil.putBoolean(this, IS_FIRST_RUNNING, false);
        }
        return first;
    }

}
