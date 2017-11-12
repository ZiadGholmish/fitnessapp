package com.fitnessapp.presentation.views.home;

import java.util.List;

/**
 * Created by carriagecompany on 8/28/17.
 */

public interface HomeContract {

    interface View {
        void initDrawer();

        void showStepsCount(String stepsCount);

        void showKMCount(float kms);

        void applyProgress(float percentage);

        void showDiscounts();

        void showStepsRemaining(int stepsRemaining);

        void applyKMProgress(float percentage);

        void showKMRemaining(float kmRemaining);

        void showCaloriesRemaining(int calories);

        void applyCalories(float progress);

        void showCaloriesCount(int calories);
    }

    interface Actions {

        void setupGoogleClient();

        void connectToGoogle();
    }

}
