package com.example.android.popularmoviesapp.utilities;

import com.example.android.popularmoviesapp.model.Movies;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Movies[] parseMoviesJson(String json) throws JSONException {

        try {
            JSONObject allResults = new JSONObject(json);
            JSONArray movieResults = allResults.getJSONArray("results");
            Movies[] moviesList = new Movies[movieResults.length()];
            for (int i =0 ; i< movieResults.length();i++){
                moviesList[i] = new Movies();
                JSONObject parsedResult = movieResults.getJSONObject(i);
                moviesList[i].setMoviesName(parsedResult.getString("title"));
                moviesList[i].setId(parsedResult.getInt("id"));
                moviesList[i].setPosterPath("http://image.tmdb.org/t/p/w185"+ parsedResult.getString("poster_path"));
                moviesList[i].setReleaseDate(parsedResult.getString("release_date"));
                moviesList[i].setVoteAverage(parsedResult.getDouble("vote_average"));
                moviesList[i].setPlotSynopsis(parsedResult.getString("overview"));
            }
            return moviesList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }



    }
}
