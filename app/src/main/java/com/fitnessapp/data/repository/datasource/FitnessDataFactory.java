package com.fitnessapp.data.repository.datasource;

import javax.inject.Inject;

/**
 * Created by carriagecompany on 8/6/17.
 */

public class FitnessDataFactory {


    @Inject
    FitnessDataFactory() {
    }

    /**
     * Create {@link FitnessDataStore}
     */
    public CloudFitnessDataStore create() {
        return new CloudFitnessDataStore();
    }


}
