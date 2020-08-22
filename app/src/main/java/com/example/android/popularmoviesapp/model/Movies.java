package com.example.android.popularmoviesapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Movies implements Parcelable {

    private String moviesName;
    private Integer id;
    private String posterPath;
    private String releaseDate;
    private Double voteAverage;
    private String plotSynopsis;

    /**
     * Constructor for a movie object
     */
    public Movies() {
    }

    protected Movies(Parcel in) {
        moviesName = in.readString();
        id = in.readInt();
        posterPath = in.readString();
        releaseDate = in.readString();
        voteAverage = in.readDouble();
        plotSynopsis = in.readString();
    }


    /**
     * Gets the original title of the movie
     *
     * @return the name of the movie
     */

    public String getMoviesName() {
        return moviesName;
    }

    /**
     * Gets the id of the movie
     *
     * @return the ID of the movie
     */

    public Integer getId() {
        return id;
    }

    /**
     * Gets the path of the movie poster
     *
     * @return the posterPath of the movie
     */
    public String getPosterPath() {
        return posterPath;
    }

    /**
     * Gets the release date of the movie
     *
     * @return the releaseDate of the movie
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * Gets the average rating of the movie
     *
     * @return the voteAverage of the movie
     */
    public Double getVoteAverage() {
        return voteAverage;
    }

    /**
     * Gets the overview of the movie
     *
     * @return the plotSynopsis of the movie
     */
    public String getPlotSynopsis() {
        return plotSynopsis;
    }

    /**
     * Sets the name of the movie
     *
     * @param moviesName Original title of the movie
     */

    public void setMoviesName(String moviesName) {
        this.moviesName = moviesName;
    }

    /**
     * Sets the id of the movie
     *
     * @param id Original title of the movie
     */

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Sets the path of the movie poster
     *
     * @param posterPath Original title of the movie
     */
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    /**
     * Sets the release date of the movie
     *
     * @param releaseDate Original title of the movie
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * Sets the rating of the movie
     *
     * @param voteAverage Original title of the movie
     */
    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    /**
     * Sets the overview of the movie
     *
     * @param plotSynopsis Original title of the movie
     */
    public void setPlotSynopsis(String plotSynopsis) {
        this.plotSynopsis = plotSynopsis;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(moviesName);
        dest.writeInt(id);
        dest.writeString(posterPath);
        dest.writeString(releaseDate);
        dest.writeDouble(voteAverage);
        dest.writeString(plotSynopsis);


    }

    public static final Creator<Movies> CREATOR = new Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel in) {
            return new Movies(in);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };
}
