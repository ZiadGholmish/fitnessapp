package com.fitnessapp.presentation.views.home;

import java.util.List;

/**
 * Created by carriagecompany on 8/28/17.
 */

public interface HomeContract {

    interface View {
        void initDrawer();

        void showStepsCount(String stepsCount);

        void applyProgress(float percentage);

        void showDiscounts();
    }

    interface Actions {

        void setupGoogleClient();

        void connectToGoogle();
    }

}
