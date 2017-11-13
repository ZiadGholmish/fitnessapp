package com.fitnessapp.utils;

import android.text.TextUtils;
import android.widget.EditText;

import java.text.DecimalFormat;

/**
 * Created by carriagecompany on 11/12/17.
 */

public class StringUtils {

    public static DecimalFormat df = new DecimalFormat("######.##");

    public static String getText(EditText editText) {
        if (editText == null) {
            return "view is null check the code";
        }
        return editText.getText().toString().trim();
    }

    public static int getTextAsInt(EditText editText) {
        if (editText == null) {
            return -1;
        }
        return Integer.parseInt(editText.getText().toString().trim());
    }

}
