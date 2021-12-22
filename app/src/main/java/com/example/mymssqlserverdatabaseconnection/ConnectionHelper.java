package com.example.mymssqlserverdatabaseconnection;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

import androidx.core.app.ActivityCompat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionHelper {
    private static ConnectionHelper instance;

    private ConnectionHelper() {

    }

    public static ConnectionHelper getInstance() {
        if (instance == null)
            instance = new ConnectionHelper();
        return instance;
    }

    String username, password, ip, port, database, classes, url;

    public Connection connection(){
        ip = "192.168.1.76";//"192.168.0.29";
        username = "theater_admin";
        password = "25456585";
        database = "Theater_DB";
        port = "1433";
        classes = "net.sourceforge.jtds.jdbc.Driver";
        url = "jdbc:jtds:sqlserver://"+ip+":"+port+"/"+database;

        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);

        Connection connection = null;

        try{
            Class.forName(classes);
            connection = DriverManager.getConnection(url, username,password);
        }
        catch (Exception e) {
            Log.e("Error: ", e.getMessage());
        }

        return connection;
    }
}
