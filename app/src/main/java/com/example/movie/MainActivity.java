package com.example.movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Display;
import android.widget.Adapter;

import com.example.movie.Model.MovieResponse;
import com.example.movie.Model.Result;
import com.example.movie.Service.apiService;
import com.example.movie.Service.apiClient;
import com.example.movie.adapter.MovieAdapter;
import com.example.movie.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.movie.Constant.APIKEY;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Result> movies;
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private MainViewModel mainViewModel;
  //  private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Popular Movies");
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        getMovies();

    }

    private void getMovies() {

        mainViewModel.getMovies().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {

                movies = (ArrayList<Result>)results;
                DisplayMovies();

            }
        });



    }

    private void DisplayMovies() {

        recyclerView = findViewById(R.id.rcyMovies);
        movieAdapter = new MovieAdapter(this,movies);

        if (this.getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        }else {
            recyclerView.setLayoutManager(new GridLayoutManager(this,4));

        }
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(movieAdapter);
        movieAdapter.notifyDataSetChanged();
    }
}
