package com.example.android.popularmoviesapp.utilities;

import com.example.android.popularmoviesapp.model.Movies;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Movies parseMoviesJson(String json) {

        try {
            List<String> parsedMoviesName = new ArrayList<>();
            List<Integer> parsedIds = new ArrayList<>();
            List<String> parsedPosterPath = new ArrayList<>();
            List<String> parsedReleasedDate = new ArrayList<>();
            List<Double> parsedVoteAverage = new ArrayList<>();
            List<String> parsedPlotSynopsis = new ArrayList<>();
            JSONObject allResults = new JSONObject(json);
            JSONArray movieResults = allResults.getJSONArray("results");
            for (int i =0 ; i< movieResults.length();i++){
                JSONObject parsedResult = movieResults.getJSONObject(i);
                parsedMoviesName.add(parsedResult.getString("title"));
                parsedIds.add(parsedResult.getInt("id"));
                parsedPosterPath.add(parsedResult.getString("poster_path"));
                parsedReleasedDate.add(parsedResult.getString("release_date"));
                parsedVoteAverage.add(parsedResult.getDouble("vote_average"));
                parsedPlotSynopsis.add(parsedResult.getString("overview"));

            }


            Movies moviesList = new Movies(parsedMoviesName,parsedIds,parsedPosterPath, parsedReleasedDate, parsedVoteAverage, parsedPlotSynopsis);

            return moviesList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }



    }
}
