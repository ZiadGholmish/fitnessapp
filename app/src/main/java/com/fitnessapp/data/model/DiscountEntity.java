package com.fitnessapp.data.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by carriagecompany on 8/29/17.
 */

@Entity(tableName = "discounts")
public class DiscountEntity {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "store_name")
    String storeName;

    @ColumnInfo(name = "store_logo")
    String storeLogo;

    @ColumnInfo(name = "card_image")
    String cardImage;

    @ColumnInfo(name = "card_overlay_color")
    String cardOverlayColor;

    @ColumnInfo(name = "desc")
    String desc;

    @ColumnInfo(name = "meal_name")
    String mealName;

    @ColumnInfo(name = "percentage")
    int percentage;

    @ColumnInfo(name = "price")
    double price;

    @ColumnInfo(name = "step_count")
    int stepCount;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreLogo() {
        return storeLogo;
    }

    public void setStoreLogo(String storeLogo) {
        this.storeLogo = storeLogo;
    }

    public String getCardImage() {
        return cardImage;
    }

    public void setCardImage(String cardImage) {
        this.cardImage = cardImage;
    }

    public String getCardOverlayColor() {
        return cardOverlayColor;
    }

    public void setCardOverlayColor(String cardOverlayColor) {
        this.cardOverlayColor = cardOverlayColor;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStepCount() {
        return stepCount;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }
}
