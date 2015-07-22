package com.ringares.coins.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by ls
 * on 2015/7/22
 * Description
 */
public class IconFontTextView extends TextView {
    public static String PLUS = "\uf278";

    public IconFontTextView(Context context) {
        super(context);
        Init();
    }

    public IconFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Init();
    }

    public IconFontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Init();
    }

    private void Init(){
        /**加入网页链接字体*/
        Typeface tf= Typeface.createFromAsset(getResources().getAssets(),"MDIconFont.ttf");
        this.setTypeface(tf);
    }
}
