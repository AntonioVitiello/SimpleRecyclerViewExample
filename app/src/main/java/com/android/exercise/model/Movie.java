package com.android.exercise.model;

/**
 * Created by antlap on 19/10/2017.
 */

public class Movie {
    private String mTitle;
    private String mAuthor;

    private Movie(){}

    public Movie(Builder builder){
        mTitle = builder._title;
        mAuthor = builder._author;
    }

    public static class Builder {
        private String _title;
        private String _author;

        public Builder(){
        }

        public Builder setTitle(String movieTitle){
            _title = movieTitle;
            return this;
        }

        public Builder setAuthor(String movieAuthor){
            _author = movieAuthor;
            return this;
        }

        public Movie create(){
            return new Movie(this);
        }
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }
}
