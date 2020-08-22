package com.example.android.popularmoviesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.android.popularmoviesapp.model.Movies;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private Movies[] mMovies;

    public GridViewAdapter(Context context) {
        this.context = context;

    }

    @Override
    public int getCount() {
        return mMovies.length;
    }

    @Override
    public Movies getItem(int position) {
        return mMovies[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){

            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_view,parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.grid_item_image);

        Picasso.get()
                .load(mMovies[position].getPosterPath())
                .into(imageView);

        return convertView;
    }

    public void setMoviesArray(Movies[] movies){
        mMovies = movies;
        notifyDataSetChanged();
    }
}
