package com.example.mymssqlserverdatabaseconnection.Models;

import net.sourceforge.jtds.jdbc.DateTime;

import java.sql.Time;
import java.time.*;
import java.time.format.*;

public class TheaterProduction {
    public int id_theater_production;
    public int id_genre;
    public int id_age_category;
    public String name;
    public String theater_name;
    public String description;
    public float rating;
    public Time duration;
    //@DateTimeFormat(pattern = "dd.MM.yyyy HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    //@JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    public DateTime start_time;
    public String director;

    private int name_length = 255;
    private int theater_name_length = 255;
    private int description_length = 1000;
    private int director_length = 255;
}
