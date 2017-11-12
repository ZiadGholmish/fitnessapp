package com.fitnessapp.data.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by carriagecompany on 11/12/17.
 */

@Entity(tableName = "settings")
public class AppSettingsEntity {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "user_weight")
    double userWeight;

    @ColumnInfo(name = "user_age")
    int userAge;

    @ColumnInfo(name = "calories_factor")
    double caloriesFactor;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

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