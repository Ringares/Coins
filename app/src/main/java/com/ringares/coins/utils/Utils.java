package com.ringares.coins.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.Toast;

import com.ringares.coins.Application.MyApplication;


/**
 * Created by ls
 * on 2015/6/29
 * Description
 */
public class Utils {
    public static Toast mToast;

    public static void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(MyApplication.context, "", Toast.LENGTH_SHORT);
        }
        mToast.setText(msg);
        mToast.show();
    }

    /**
     * dip2px
     */
    public static float dip2Pixel(float dip, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, displayMetrics);
    }

    public static void log(Object object, String log) {
        String className = object.getClass().toString();
        className = className.substring(className.lastIndexOf(".")+1);
        Log.e(className, log);
    }
}
