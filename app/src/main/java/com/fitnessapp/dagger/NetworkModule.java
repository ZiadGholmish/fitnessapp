package com.fitnessapp.dagger;


import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class NetworkModule {

    private final String BASE_URL_NAME = "BASE_URL_NAME";

//    @Provides
//    @Named(BASE_URL_NAME)
//    public String provideBaseUrl() {
//        return ApiConstants.BASE_URL;
//    }

    @Provides
    @Singleton
    Converter.Factory provideJsonConverter() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideDebugInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    OkHttpClient.Builder provideOkHttpClientBuilder(HttpLoggingInterceptor interceptor) {

        OkHttpClient.Builder clientBuilder = new OkHttpClient().newBuilder();
        clientBuilder.addInterceptor(interceptor);
        return clientBuilder;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Converter.Factory factory, OkHttpClient client, @Named(BASE_URL_NAME) String baseUrl) {

        return new Retrofit.Builder().
                addConverterFactory(factory).client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl).build();
    }

//    @Provides
//    @Singleton
//    APIInterface provideApiInterface(Retrofit retrofit) {
//        return retrofit.create(APIInterface.class);
//    }


}
