package com.example.mymssqlserverdatabaseconnection.ViewModels;

import static android.content.ContentValues.TAG;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.mymssqlserverdatabaseconnection.ConnectionHelper;
import com.example.mymssqlserverdatabaseconnection.Models.Genre;
import com.example.mymssqlserverdatabaseconnection.Requests.Requests;

import java.sql.Connection;
import java.sql.ResultSet;
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






















