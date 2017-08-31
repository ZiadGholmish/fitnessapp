package com.fitnessapp.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.fitnessapp.data.model.StepEntity;


/**
 * Created by carriagecompany on 8/29/17.
 */

@Database(entities = {StepEntity.class}, version = 1)
public abstract class FitnessLocalDataBase extends RoomDatabase {
    public abstract StepDAO stepDAO();
}
