package com.fitnessapp.utils;

import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.fitnessapp.R;

/**
 * Created by carriagecompany on 11/13/17.
 */

public class ValidatorUtils {

    public static boolean checkEditTextValidation(EditText editText, final TextInputLayout inputLayout, NestedScrollView nestedScrollView) {


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                inputLayout.setError("");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        String nameValue = editText.getText().toString().trim();

        if (nameValue.isEmpty()) {

            inputLayout.setError(ResourcesUtil.getString(R.string.required_label));

            focusOnView(nestedScrollView, editText);

            return false;

        } else {

            inputLayout.setError("");
        }

        return true;
    }



    private static void focusOnView(final NestedScrollView nestedScrollView, final View view) {

        if (nestedScrollView != null) {

            nestedScrollView.post(new Runnable() {
                @Override
                public void run() {
                    nestedScrollView.smoothScrollTo(0, view.getBottom());
                    view.requestFocus();
                }
            });
        }
    }

}
