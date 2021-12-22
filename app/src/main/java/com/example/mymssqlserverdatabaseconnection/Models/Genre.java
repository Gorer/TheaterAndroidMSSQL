package com.example.mymssqlserverdatabaseconnection.Models;

import static android.content.ContentValues.TAG;

import android.util.Log;

public class Genre implements Item {
    private int id_genre;
    private String name_genre;

    private int name_genre_length = 255;
    private String type = "Genre";

    public Genre(int id_genre, String name_genre) {
        this.id_genre = id_genre;
        this.name_genre = name_genre;
    }

    public Genre() {
    }

    public int getId_genre() {
        return id_genre;
    }

    public void setId_genre(int id_genre) {
        this.id_genre = id_genre;
    }

    public String getName_genre() {
        return name_genre;
    }

    public void setName_genre(String name_genre) {
        this.name_genre = name_genre;
    }

    public void setName_genre_length(int name_genre_length) {
        this.name_genre_length = name_genre_length;
    }

    @Override
    public String getItemType() {
        Log.d(TAG, type);
        return type;
    }

    /*@Override
    public long getIntType() {
        return 0;
    }*/
}
