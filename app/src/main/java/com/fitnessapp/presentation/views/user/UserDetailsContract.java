package com.fitnessapp.presentation.views.user;

/**
 * Created by carriagecompany on 11/13/17.
 */

public interface UserDetailsContract {

    interface View {

        void showError(String message);

        void openTrackScreen();

        void closeScreen();
    }

    interface Actions {

        void saveUserSettings(String fullName, int age, int weight, int height, int gender);

        void checkAppSettings();
    }


}
