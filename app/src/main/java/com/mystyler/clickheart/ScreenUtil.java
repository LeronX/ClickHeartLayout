package com.mystyler.clickheart;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class ScreenUtil {

    public static float getDensity(Context context){
        float scale = context.getResources().getDisplayMetrics().density;
        return scale;
    }

    public static int convertDiptoPix(Context context, int dip){
        float scale = getDensity(context);
        return (int) (dip * scale + 0.5f);
    }

    public static int convertPixtoDip(Context context, int pixel){
        float scale = getDensity(context);
        return (int)((pixel - 0.5f)/scale);
    }

    @SuppressWarnings("deprecation")
    @SuppressLint("NewApi")
    public static int getScreenWidthInDp(Context context) {
        int Measuredwidth = 0;
        Point size = new Point();
        WindowManager w = ((Activity)context).getWindowManager();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2)
        {
            w.getDefaultDisplay().getSize(size);

            Measuredwidth = size.x;
        } else {
            Display d = w.getDefaultDisplay();
            Measuredwidth = d.getWidth();
        }
        return Measuredwidth;
    }

    public static int getScreenWidthInPx(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int)(displayMetrics.widthPixels);
    }

    public static int getScreenHeightInPx(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int)(displayMetrics.heightPixels);
    }
}

