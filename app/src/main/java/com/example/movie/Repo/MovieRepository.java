package com.example.movie.Repo;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.movie.Model.MovieResponse;
import com.example.movie.Model.Result;
import com.example.movie.Service.apiClient;
import com.example.movie.Service.apiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.movie.Constant.APIKEY;

public class MovieRepository {

    private ArrayList<Result> movies = new ArrayList<>();
    private MutableLiveData<List<Result>> mutableLiveData = new MutableLiveData<>();

    public MovieRepository(Application application) {
    }

    public MutableLiveData<List<Result>> getMutableLiveData() {
        apiService service = apiClient.getapiService();

        Call<MovieResponse> call = service.getAllMovie(APIKEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                MovieResponse movieResponse = response.body();

                if (movieResponse!= null && movieResponse.getResults()!= null){
                    movies = (ArrayList<Result>)movieResponse.getResults();
                    mutableLiveData.setValue(movies);
                }
            }


            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}
