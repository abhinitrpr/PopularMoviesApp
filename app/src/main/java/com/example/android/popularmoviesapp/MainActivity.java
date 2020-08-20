package com.example.android.popularmoviesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.popularmoviesapp.model.Movies;
import com.example.android.popularmoviesapp.utilities.JsonUtils;
import com.example.android.popularmoviesapp.utilities.NetworkUtils;

import java.net.URL;
import java.util.ArrayList;

// 0. Make Changes in JSON, so that the data is received in the form Movies Array
// 1. Fetch in the form of Movies Array
// 2. How to get the poster path from Movies Array
// 3. Make changes in GripAdapter to get the poster paths
// 4. View all posters on MainActivity
//TODO 5. Set ClickListener on GridAdapter
//TODO 6. Transfer data from Main to Detail Activity using Parcelable
public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private GridViewAdapter gridViewAdapter;
    private TextView mErrorMessageDisplay;
    private ProgressBar mLoadingIndicator;
    private Movies[] mMovie = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mErrorMessageDisplay = findViewById(R.id.tv_error_message_display);
        mLoadingIndicator = findViewById(R.id.pb_loading_indicator);

        gridView = findViewById(R.id.gridView);
        gridViewAdapter = new GridViewAdapter(getApplicationContext());

        loadGridData("popular");

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("movieData", mMovie[position]);
//                intent.putExtra("releaseDate", releaseDate.get(position));
//                intent.putExtra("ratings", voteAverage.get(position));
//                intent.putExtra("id", ids.get(position));
//                intent.putExtra("plotSynopsis", plotSynopsis.get(position));
//                intent.putExtra("movieName", moviesName.get(position));

                startActivity(intent);
            }
        });


    }

    private void loadGridData(String sort_type) {
        // showWeatherDataView();

        if (sort_type.equals("popular")) {
            new FetchMovieTask().execute("popular");
        } else if (sort_type.equals("top_rated")) {

            new FetchMovieTask().execute("top_rated");

        }
    }

    private void showGridView() {
        mErrorMessageDisplay.setVisibility(View.INVISIBLE);
        gridView.setVisibility(View.VISIBLE);
    }

    private void showErrorMessage() {
        /* First, hide the currently visible data */
        gridView.setVisibility(View.INVISIBLE);
        /* Then, show the error */
        mErrorMessageDisplay.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.top_rated) {
            loadGridData("top_rated");
            setTitle("Top Rated Movies");
            return true;
        } else if (id == R.id.popular) {
            loadGridData("popular");
            setTitle("Popular Movies");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

//    public boolean isOnline() {
//        Runtime runtime = Runtime.getRuntime();
//        try {
//            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
//            int     exitValue = ipProcess.waitFor();
//            return (exitValue == 0);
//        }
//        catch (IOException e)          { e.printStackTrace(); }
//        catch (InterruptedException e) { e.printStackTrace(); }
//
//        return false;
//    }

    public class FetchMovieTask extends AsyncTask<String, Void, Movies[]> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mLoadingIndicator.setVisibility(View.VISIBLE);
        }

        @Override
        protected Movies[] doInBackground(String... params) {

            if (params.length == 0) {
                return null;
            }
            String path = params[0];

            URL moviesUrl = NetworkUtils.buildUrl(path);

            try {
                String jsonMoviesResponse = NetworkUtils.getResponseFromHttpUrl(moviesUrl);
                mMovie = JsonUtils.parseMoviesJson(jsonMoviesResponse);

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return mMovie;

        }

        @Override
        protected void onPostExecute(Movies[] movies) {
            mLoadingIndicator.setVisibility(View.INVISIBLE);
            if (movies != null) {
                mMovie = movies;
                showGridView();
                gridViewAdapter.setMoviesArray(mMovie);
                gridView.setAdapter(gridViewAdapter);
            } else {
                showErrorMessage();
            }
        }
    }
}
