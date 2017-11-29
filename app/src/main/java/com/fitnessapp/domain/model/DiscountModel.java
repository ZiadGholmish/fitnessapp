package com.fitnessapp.domain.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by carriagecompany on 8/29/17.
 */

public class DiscountModel implements Parcelable {

    int id;

    String storeName;

    String storeLogo;

    String cardImage;

    String cardOverlayColor;

    String desc;

    String mealName;

    int percentage;

    double price;

    int stepCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.storeName);
        dest.writeString(this.storeLogo);
        dest.writeString(this.cardImage);
        dest.writeString(this.cardOverlayColor);
        dest.writeString(this.desc);
        dest.writeString(this.mealName);
        dest.writeInt(this.percentage);
        dest.writeDouble(this.price);
        dest.writeInt(this.stepCount);
    }

    public DiscountModel() {
    }

    protected DiscountModel(Parcel in) {
        this.id = in.readInt();
        this.storeName = in.readString();
        this.storeLogo = in.readString();
        this.cardImage = in.readString();
        this.cardOverlayColor = in.readString();
        this.desc = in.readString();
        this.mealName = in.readString();
        this.percentage = in.readInt();
        this.price = in.readDouble();
        this.stepCount = in.readInt();
    }

    public static final Creator<DiscountModel> CREATOR = new Creator<DiscountModel>() {
        @Override
        public DiscountModel createFromParcel(Parcel source) {
            return new DiscountModel(source);
        }

        @Override
        public DiscountModel[] newArray(int size) {
            return new DiscountModel[size];
        }
    };
}
