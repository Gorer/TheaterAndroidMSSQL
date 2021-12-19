package com.example.mymssqlserverdatabaseconnection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editTextSearch;
    private String tableName;
    private Spinner spinnerTables;

    private static String ip = "192.168.0.29";
    private static String port = "1433";
    private static String Classes = "net.sourceforge.jtds.jdbc.Driver";
    private static String database = "Theater_DB";
    private static String username = "theater_admin";
    private static String password = "25456585";
    private static String url = "jdbc:jtds:sqlserver://"+ip+":"+port+"/"+database;

    private Connection connection = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET},
                PackageManager.PERMISSION_GRANTED);
        textView = findViewById(R.id.textViewResult);
        editTextSearch = findViewById(R.id.editTextSearch);
        spinnerTables = findViewById(R.id.spinnerTables);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Class.forName(Classes);
            connection = DriverManager.getConnection(url, username,password);
            textView.setText("SUCCESS");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            textView.setText("ERROR");
        } catch (SQLException e) {
            e.printStackTrace();
            textView.setText("FAILURE");
        }
    }
/// отсюда
    public void setTableName() {
        int position = spinnerTables.getSelectedItemPosition();
        tableName = getTableNameFromSpinner(position);;
    }

    public String getTableNameFromSpinner(int position) {
        String[] tables = getResources().getStringArray(R.array.spinner_tables);
        return tables[position];
    }

    public void sqlButton(View view){
        String text = editTextSearch.getText().toString();
        setTableName();
        if (connection!=null){
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(
                        "Select * from " + tableName + " where name_genre>=\'" + text + "\';");
                ////// До сюда
                while (resultSet.next()) {
                    textView.setText(resultSet.getString("name_genre"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            textView.setText("Connection is null");
        }
    }
}