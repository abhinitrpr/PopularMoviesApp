package com.example.android.popularmoviesapp.model;

import java.util.ArrayList;
import java.util.List;

public class Movies {

    private List<String> moviesName = null;
    private List<Integer> ids = null;
    private ArrayList<String> posterPath = null;
    private List<String> releaseDate = null;
    private List<Double> voteAverage = null;
    private List<String> plotSynopsis = null;

    /**
     * No args constructor for use in serialization
     */
    public Movies() {
    }

    public Movies(List<String> moviesName, List<Integer> ids, ArrayList<String> posterPath, List<String> releaseDate, List<Double> voteAverage, List<String> plotSynopsis) {
        this.moviesName = moviesName;
        this.ids = ids;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.voteAverage = voteAverage;
        this.plotSynopsis = plotSynopsis;
    }

    public List<String> getMoviesName() {
        return moviesName;
    }

    public void setMoviesName(List<String> moviesName) {
        this.moviesName = moviesName;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public ArrayList<String> getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(ArrayList<String> posterPath) {
        this.posterPath = posterPath;
    }

    public List<String> getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(List<String> releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Double> getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(List<Double> voteAverage) {
        this.voteAverage = voteAverage;
    }

    public List<String> getPlotSynopsis() {
        return plotSynopsis;
    }

    public void setPlotSynopsis(List<String> plotSynopsis) {
        this.plotSynopsis = plotSynopsis;
    }
}
