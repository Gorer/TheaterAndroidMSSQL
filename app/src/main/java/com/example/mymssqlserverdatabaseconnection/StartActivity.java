package com.example.mymssqlserverdatabaseconnection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StartActivity extends AppCompatActivity {

    private EditText editText;
    private RecyclerView recyclerViewResults;
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
        setContentView(R.layout.activity_start);

        spinnerTables = findViewById(R.id.spinnerTables);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_tables, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTables.setAdapter(adapter);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);
        editText = findViewById(R.id.editTextSearchStart);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Class.forName(Classes);
            connection = DriverManager.getConnection(url, username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // по умолчанию отображает постановки
    private void initRecyclerView() {
        recyclerViewResults = findViewById(R.id.recyclerViewResults);
        recyclerViewResults.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL);//декорации
        recyclerViewResults.addItemDecoration(dividerItemDecoration);
    }

    public void toFindButton() {
        String text = editText.getText().toString();
        if (connection!=null){
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from genres where name_genre=\'" + text + "\';");
                while (resultSet.next()){
                    //textView.setText(resultSet.getString("name_genre"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            //textView.setText("Connection is null");
        }
    }
}