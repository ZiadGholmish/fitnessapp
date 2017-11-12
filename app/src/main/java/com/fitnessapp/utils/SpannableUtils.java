package com.fitnessapp.utils;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;

/**
 * Created by carriagecompany on 11/12/17.
 */

public class SpannableUtils {


    public static String formatValueWithLabel(String number, String label) {

        SpannableString spannableString = new SpannableString(label);
        spannableString.setSpan(new RelativeSizeSpan(0.7f), 0, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        SpannableString spannableNubmer = new SpannableString(number);
        spannableNubmer.setSpan(new RelativeSizeSpan(5f), 0, spannableNubmer.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return TextUtils.concat(spannableNubmer, "\n", spannableString).toString();
    }


}
