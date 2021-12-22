package com.example.mymssqlserverdatabaseconnection.ViewModels;

import static android.content.ContentValues.TAG;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.mymssqlserverdatabaseconnection.ConnectionHelper;
import com.example.mymssqlserverdatabaseconnection.Models.Genre;
import com.example.mymssqlserverdatabaseconnection.Models.Item;
import com.example.mymssqlserverdatabaseconnection.Models.TheaterProduction;
import com.example.mymssqlserverdatabaseconnection.Requests.Requests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private ConnectionHelper connectionHelper;
    Connection connection;
    String connectionResult = "";

    public MainViewModel(@NonNull Application application) {
        super(application);
        connectionHelper = ConnectionHelper.getInstance();
    }



    public List<Item> getItemsFromDb(String tableName, String searchText) {
        List<Item> items = new ArrayList<>();
        try {
            connection = connectionHelper.connection();
            if (connection != null) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(Requests.SEARCH(tableName, searchText));
                while (resultSet.next()) {
                    Log.d(TAG, resultSet.getString(1));
                    switch (tableName) {
                        case "theater_production":
                            addTheaterProduction(items, resultSet);
                            break;
                        case "genres":
                            addGenre(items, resultSet);
                            break;
                    }
                }
            }
            else {
                connectionResult = "Check your connection";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    private void addGenre(List<Item> items, ResultSet resultSet) throws SQLException {
        Genre item = new Genre();
        Log.d(TAG, item.getItemType());
        item.setId_genre(resultSet.getInt("id_genre"));
        item.setName_genre(resultSet.getString("name_genre"));
        Log.d(TAG, item.getId_genre() + " | " + item.getName_genre());
        items.add(item);
    }

    private void addTheaterProduction(List<Item> items, ResultSet resultSet) throws SQLException {
        TheaterProduction item = new TheaterProduction();
        Log.d(TAG, item.getItemType());
        item.setName(resultSet.getString("name"));
        item.setTheater_name(resultSet.getString("theater_name"));
        item.setRating(resultSet.getInt("rating"));
        Log.d(TAG, item.getName() + " | " +
                item.getTheater_name() + " | " + item.getRating());
        items.add(item);
    }

    public List<Genre> getGenresFromDb(String tableName, String searchText) {
        List<Genre> genres = new ArrayList<>();
        try {
            connection = connectionHelper.connection();
            if (connection != null) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(Requests.SEARCH(tableName, searchText));
                while (resultSet.next()) {
                    Genre item = new Genre();
                    item.setId_genre(resultSet.getInt("id_genre"));
                    item.setName_genre(resultSet.getString("name_genre"));
                    Log.d(TAG, item.getId_genre() + item.getName_genre());
                    genres.add(item);
                }
            }
            else {
                connectionResult = "Check your connection";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return genres;
    }
}






















