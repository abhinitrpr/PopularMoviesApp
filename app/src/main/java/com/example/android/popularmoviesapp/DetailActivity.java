package com.example.android.popularmoviesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    TextView movieName, releaseDate, ratings, plotSynopsis;
    ImageView imageView;
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

        String movie = intent.getStringExtra("movieName");
        String release = intent.getStringExtra("releaseDate");
        Double ratingData = intent.getDoubleExtra("ratings", 0);
        String plotSynopsisData = intent.getStringExtra("plotSynopsis");
        String posterPath = intent.getStringExtra("posterPath");

        Picasso.get().load(posterPath).into(imageView);
        movieName.setText(movie);
        releaseDate.setText(release);
        ratings.setText(ratingData.toString());
        plotSynopsis.setText(plotSynopsisData);


    }
}
