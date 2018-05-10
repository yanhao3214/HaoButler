package com.gogo.haobutler.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * @author: 闫昊
 * @date: 2018/4/15
 * @function:
 */

public class UtilTools {
    public static void setFont(Context context, TextView textView) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/FONT.TTF");
        textView.setTypeface(typeface);
    }
}
