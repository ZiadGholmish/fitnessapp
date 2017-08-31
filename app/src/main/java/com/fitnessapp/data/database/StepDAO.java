package com.fitnessapp.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.fitnessapp.data.model.StepEntity;


import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by carriagecompany on 8/29/17.
 */

@Dao
public interface StepDAO {

    @Query("SELECT * FROM steps")
    public Flowable<List<StepEntity>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(StepEntity stepEntity);

    @Update
    public void update(StepEntity stepEntity);

    @Delete
    public void delete(StepEntity stepEntity);

}
