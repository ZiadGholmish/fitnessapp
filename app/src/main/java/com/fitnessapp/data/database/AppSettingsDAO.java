package com.fitnessapp.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.fitnessapp.data.model.AppSettingsEntity;
import com.fitnessapp.data.model.StepEntity;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by carriagecompany on 11/12/17.
 */

@Dao
public interface AppSettingsDAO {

    @Query("SELECT * FROM settings LIMIT 1")
    public Flowable<AppSettingsEntity> getAppSettings();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(AppSettingsEntity appSettingsEntity);

    @Update
    public void update(AppSettingsEntity appSettingsEntity);

    @Query("DELETE FROM settings")
    public void resetAppSettings();
}
