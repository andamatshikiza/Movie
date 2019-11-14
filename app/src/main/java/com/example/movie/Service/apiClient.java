package com.example.movie.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static com.example.movie.Constant.BASE_URL;

public class apiClient {

    private static Retrofit retrofit = null;

    public static apiService getapiService() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
            return retrofit.create(apiService.class);
        }

}