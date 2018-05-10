package com.gogo.haobutler.entity;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author: 闫昊
 * @date: 2018/5/8
 * @function:
 */
public class MoocBean {
    private String icon;
    private String title;
    private String content;

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
