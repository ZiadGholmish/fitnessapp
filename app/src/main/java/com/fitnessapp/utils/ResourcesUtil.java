package com.fitnessapp.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import com.fitnessapp.app.App;

public class ResourcesUtil {

    private static Context context = App.getContext();

    public static Drawable getDrawableById(int resId) {
        return ContextCompat.getDrawable(context, resId);
    }

    public static String getString(int resId) {
        return context.getResources().getString(resId);
    }


}
