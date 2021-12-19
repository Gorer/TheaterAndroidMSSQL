package com.example.mymssqlserverdatabaseconnection;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;

import androidx.core.app.ActivityCompat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionHelper {
    public static String ip = "192.168.0.29";
    public static String port = "1433";
    public static String Classes = "net.sourceforge.jtds.jdbc.Driver";
    public static String database = "Theater_DB";
    public static String username = "theater_admin";
    public static String password = "25456585";
    public static String url = "jdbc:jtds:sqlserver://"+ip+":"+port+"/"+database;

    private Connection connection = null;

    public ConnectionHelper(Connection connection) {
        this.connection = connection;
        //ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);
        //textView = findViewById(R.id.textView);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Class.forName(Classes);
            connection = DriverManager.getConnection(url, username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    //private toFind() {
    //    ResultSet resultSet = statement.executeQuery("Select * from genres where name_genre=\'" + text + "\';");
    //}

}
