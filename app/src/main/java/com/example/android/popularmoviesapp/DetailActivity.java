package com.example.android.popularmoviesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.popularmoviesapp.model.Movies;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    TextView movieName, releaseDate, ratings, plotSynopsis;
    ImageView imageView;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setTitle("Movie Details");

        movieName = findViewById(R.id.movie_name);
        releaseDate = findViewById(R.id.release_date);
        ratings = findViewById(R.id.ratings);
        plotSynopsis = findViewById(R.id.plotSynopsis);
        imageView = findViewById(R.id.imageView);

        Intent intent = getIntent();
        Movies moviesData = intent.getParcelableExtra("movieData");
//        String movie = "", release = "",plotSynopsisData ="", posterPath ="";
//        Double ratingData =0.0;
//        if(moviesData != null){
//            movie = moviesData.getMoviesName();
//             release = moviesData.getReleaseDate();
//             ratingData = moviesData.getVoteAverage();
//             plotSynopsisData = moviesData.getPlotSynopsis();
//             posterPath = moviesData.getPosterPath();
//        }
////        Log.i("movie",movie);
////        Log.i("releseDate",release);
////        Log.i("rating",ratingData.toString());
////        Log.i("plot",plotSynopsisData);
        if(moviesData != null){
            System.out.println(moviesData);
            movieName.setText(moviesData.getMoviesName());
            releaseDate.setText(String.format("%s",moviesData.getReleaseDate()));
            ratings.setText(String.format("%s",moviesData.getVoteAverage()));
            plotSynopsis.setText(moviesData.getPlotSynopsis());
            Picasso.get().load(moviesData.getPosterPath()).into(imageView);

        }



        //Log.i("message", release);


    }
}
