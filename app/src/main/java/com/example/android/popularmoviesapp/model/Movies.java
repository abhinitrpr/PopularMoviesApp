package com.example.android.popularmoviesapp.model;

import java.util.List;

public class Movies {

    private List<String> moviesName;
    private List<Integer> ids;
    private List<String> posterPath;
    private List<String> releaseDate;
    private List<Double> voteAverage;
    private List<String> plotSynopsis = null;

    /**
     * No args constructor for use in serialization
     */
    public Movies() {
    }

    public Movies(List<String> moviesName, List<Integer> ids, List<String> posterPath, List<String> releaseDate, List<Double> voteAverage, List<String> plotSynopsis) {
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

    public List<String> getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(List<String> posterPath) {
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

    public void setPlotSynopsis(List<String> ingredients) {
        this.plotSynopsis = plotSynopsis;
    }
}
