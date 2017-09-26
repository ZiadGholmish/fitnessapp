package com.fitnessapp.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.fitnessapp.data.model.DiscountEntity;
import com.fitnessapp.data.model.StepEntity;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by carriagecompany on 9/26/17.
 */

@Dao
public interface DiscountDAO {

    @Query("SELECT * FROM discounts")
    public Flowable<List<DiscountEntity>> getAllDiscounts();

    @Query("SELECT * FROM discounts WHERE step_count BETWEEN 100 AND 1000")
    public Flowable<List<DiscountEntity>> getAvailableDiscounts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(DiscountEntity discountEntity);

    @Update
    public void update(DiscountEntity discountEntity);

    @Query("DELETE FROM discounts")
    public void resetCounter();

}
