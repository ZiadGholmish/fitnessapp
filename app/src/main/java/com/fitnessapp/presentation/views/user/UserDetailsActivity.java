package com.fitnessapp.presentation.views.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.fitnessapp.R;
import com.fitnessapp.app.App;
import com.fitnessapp.presentation.views.home.HomeActivity;
import com.fitnessapp.presentation.views.home.HomeContract;
import com.fitnessapp.utils.StringUtils;
import com.fitnessapp.utils.ValidatorUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserDetailsActivity extends AppCompatActivity implements UserDetailsContract.View {

    @BindView(R.id.user_name_edit)
    EditText userNameEdit;
    @BindView(R.id.user_name_text_input)

    TextInputLayout userNameTextInput;
    @BindView(R.id.user_age_edit)

    EditText userAgeEdit;
    @BindView(R.id.user_age_text_input)
    TextInputLayout userAgeTextInput;

    @BindView(R.id.user_height_edit)
    EditText userHeightEdit;

    @BindView(R.id.user_height_text_input)
    TextInputLayout userHeightTextInput;

    @BindView(R.id.user_weight_edit)
    EditText userWeightEdit;

    @BindView(R.id.user_weigth_text_input)
    TextInputLayout userWeigthTextInput;

    @BindView(R.id.male)
    RadioButton male;

    @BindView(R.id.female)
    RadioButton female;

    @BindView(R.id.start_tracking_btn)
    Button startTrackingBtn;

    @BindView(R.id.gender)
    RadioGroup gender;

    @Inject
    UserDetailsPresenter userDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        ButterKnife.bind(this);
        ((App) getApplicationContext()).getApplicationComponent().inject(this);
        userDetailsPresenter.attachView(this);
        userDetailsPresenter.checkAppSettings();
    }

    @OnClick(R.id.start_tracking_btn)
    void saveAppSettings() {

        if (ValidatorUtils.checkEditTextValidation(userNameEdit, userNameTextInput, null)
                && ValidatorUtils.checkEditTextValidation(userAgeEdit, userAgeTextInput, null)
                && ValidatorUtils.checkEditTextValidation(userHeightEdit, userHeightTextInput, null)
                && ValidatorUtils.checkEditTextValidation(userWeightEdit, userWeigthTextInput, null)) {

            userDetailsPresenter.saveUserSettings(StringUtils.getText(userNameEdit),
                    StringUtils.getTextAsInt(userAgeEdit),
                    StringUtils.getTextAsInt(userWeightEdit),
                    StringUtils.getTextAsInt(userHeightEdit), male.isChecked() ? 1 : 0);
        }

    }

    @Override
    public void closeScreen() {
        finish();
    }

    @Override
    public void openTrackScreen() {
        Intent intent = new Intent(UserDetailsActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void showError(String message) {
        Log.e("the app settings", "the app settings did not save correctly");
    }
}
