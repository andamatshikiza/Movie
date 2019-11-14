package com.example.movie.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.movie.Model.Result;
import com.example.movie.Repo.MovieRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private MovieRepository movieRepository;
    public MainViewModel(@NonNull Application application) {
        super(application);
        movieRepository = new MovieRepository(application);
    }
    public LiveData<List<Result>> getMovies(){

        return  movieRepository.getMutableLiveData();
    }
}
