package com.example.mymssqlserverdatabaseconnection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mymssqlserverdatabaseconnection.Adapters.MainAdapter;
import com.example.mymssqlserverdatabaseconnection.Models.Genre;
import com.example.mymssqlserverdatabaseconnection.Requests.Requests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainAdapter mainAdapter;
    private TextView textView;
    private EditText editTextSearch;
    private String tableName;
    private Spinner spinnerTables;
    private String searchText;
    private RecyclerView rcView;
    private Requests requestsObject;

    private Connection connection = null;
    private ConnectionHelper connectionHelper;
    String connectionResult = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.recyclerViewResult);
        editTextSearch = findViewById(R.id.editTextSearch);
        spinnerTables = findViewById(R.id.spinnerTables);
        connectionHelper = ConnectionHelper.getInstance();
        requestsObject = new Requests();
    }

    private void setRcView(String genre){
        rcView = findViewById(R.id.recyclerViewResult);
        List<Genre> genres = requestsObject.getGenresFromDb(genre);//.getFlightsFromDb(airport);
        if (genres != null){
            rcView.setAdapter(mainAdapter);
//                   mainViewModel.setDisplayList(noteList);
            mainAdapter.updateAdapter(genres);
        }
        rcView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void setTableName() {
        int position = spinnerTables.getSelectedItemPosition();
        tableName = getTableNameFromSpinner(position);
    }

    public String getTableNameFromSpinner(int position) {
        String[] tables = getResources().getStringArray(R.array.spinner_tables);
        return tables[position];
    }

    public void sqlButton(View view){
        connection = connectionHelper.connection();
        searchText = editTextSearch.getText().toString();
        setTableName();
        if (connection!=null) {
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(
                         Requests.SEARCH(tableName, searchText));
                while (resultSet.next()) {
                    textView.setText(resultSet.getString("theater_name"));
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