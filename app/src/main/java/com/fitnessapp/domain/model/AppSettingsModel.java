package com.fitnessapp.domain.model;

import android.arch.persistence.room.ColumnInfo;

/**
 * Created by carriagecompany on 11/12/17.
 */

public class AppSettingsModel {

    int userWeight;

    int userAge;

    double caloriesFactor;

    int gender;

    int height;

    public int getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(int userWeight) {
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
