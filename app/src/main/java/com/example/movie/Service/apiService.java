package com.example.movie.Service;

import com.example.movie.Model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface apiService {

        @GET("movie/popular")
        Call<MovieResponse> getAllMovie(

                @Query("api_key") String api_key);
}
