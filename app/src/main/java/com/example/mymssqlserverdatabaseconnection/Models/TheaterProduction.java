package com.example.mymssqlserverdatabaseconnection.Models;

import static android.content.ContentValues.TAG;

import android.util.Log;

import net.sourceforge.jtds.jdbc.DateTime;

import java.sql.Time;
import java.time.*;
import java.time.format.*;

public class TheaterProduction implements Item {
    private int id_theater_production;
    private int id_genre;
    private int id_age_category;
    private String name;
    private String theater_name;
    private String description;
    private float rating;
    private String duration;
    //private Time duration;
    //@DateTimeFormat(pattern = "dd.MM.yyyy HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    //@JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    //private DateTime start_time;
    private String start_time;
    private String director;

    private int name_length = 255;
    private int theater_name_length = 255;
    private int description_length = 1000;
    private int director_length = 255;
    private String type = "TheaterProduction";

    public int getId_theater_production() {
        return id_theater_production;
    }

    /*public void setId_theater_production(int id_theater_production) {
        this.id_theater_production = id_theater_production;
    }*/

    public int getId_genre() {
        return id_genre;
    }

    public void setId_genre(int id_genre) {
        this.id_genre = id_genre;
    }

    public int getId_age_category() {
        return id_age_category;
    }

    public void setId_age_category(int id_age_category) {
        this.id_age_category = id_age_category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTheater_name() {
        return theater_name;
    }

    public void setTheater_name(String theater_name) {
        this.theater_name = theater_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String getItemType() {
        Log.d(TAG, type);
        return type;
    }

}
