package com.fitnessapp.domain.model;

import android.arch.persistence.room.ColumnInfo;

/**
 * Created by carriagecompany on 11/12/17.
 */

public class AppSettingsModel {

    double userWeight;

    int userAge;

    double caloriesFactor;

    public double getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(double userWeight) {
        this.userWeight = userWeight;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public double getCaloriesFactor() {
        return caloriesFactor;
    }

    public void setCaloriesFactor(double caloriesFactor) {
        this.caloriesFactor = caloriesFactor;
    }
}
