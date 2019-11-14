package com.example.movie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie.Model.Result;
import com.example.movie.R;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {


private Context context;
private ArrayList<Result> movieList;

    public MovieAdapter(Context context, ArrayList<Result> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.moviehan,parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        holder.title.setText(movieList.get(position).getOriginalTitle());
        holder.rate.setText((Double.toString(movieList.get(position).getVoteAverage())));
        String path = "https://image.tmdb.org/t/p/w500"+movieList.get(position).getPosterPath();

        Glide.with(context)
                .load(path)
                .placeholder(R.drawable.loadingg)
                .into(holder.movieImg);
       /// holder.movieImg
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public  class  MovieViewHolder extends RecyclerView.ViewHolder{

        public TextView rate,title;
        public ImageView movieImg;
        public MovieViewHolder(View itemview){
            super(itemview);

            rate = (TextView) itemview.findViewById(R.id.rating);
            title = (TextView) itemview.findViewById(R.id.title);
            movieImg= (ImageView) itemview.findViewById(R.id.imgMovie);

        }
    }
}
