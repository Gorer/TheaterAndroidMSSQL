package com.example.mymssqlserverdatabaseconnection;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mymssqlserverdatabaseconnection.Adapters.MainAdapter;
import com.example.mymssqlserverdatabaseconnection.Models.Genre;
import com.example.mymssqlserverdatabaseconnection.Models.Item;
import com.example.mymssqlserverdatabaseconnection.Requests.Requests;
import com.example.mymssqlserverdatabaseconnection.ViewModels.MainViewModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainAdapter mainAdapter;
    private MainViewModel mainViewModel;
    //private RecyclerView textView;
    private EditText editTextSearch;
    private String tableName;// = "genres";
    private Spinner spinnerTables;
    private String searchText;// = "genres";
    private RecyclerView rcView;
    //private Requests requestsObject;

    //private Connection connection = null;
    //private ConnectionHelper connectionHelper;
    //String connectionResult = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        /*try {
            mainAdapter = new MainAdapter(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("caught");
        }*/

        editTextSearch = findViewById(R.id.editTextSearch);
        spinnerTables = findViewById(R.id.spinnerTables);
        initRecyclerView();
        /*rcView = findViewById(R.id.recyclerViewResult);
        rcView.setAdapter(mainAdapter);
        rcView.setLayoutManager(new LinearLayoutManager(this));*/
    }
    /*@Override
    public void onResume() {
        super.onResume();
        setRcView();
    }*/

    private void initRecyclerView() {
        rcView = findViewById(R.id.recyclerViewResult);
        rcView.setLayoutManager(new LinearLayoutManager(this));

        mainAdapter = new MainAdapter(this);
        rcView.setAdapter(mainAdapter);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        setRcView();
    }

    private void setRcView(){
        //rcView = findViewById(R.id.recyclerViewResult);
        //List<Genre> genres = mainViewModel.getGenresFromDb(tableName, searchText);
//getItemsFromDb
        List<Item> items = mainViewModel.getItemsFromDb(tableName, searchText);
        if (!items.isEmpty()){
            Log.d(TAG, "items != null");
            for (int i = 0; i < items.size(); i++)
            Log.d(TAG, items.get(i).getItemType());
            mainAdapter.updateAdapter(items);
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
        searchText = editTextSearch.getText().toString();
        setTableName();
        setRcView();
    }

    /*public void sqlButton(View view){
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
    }*/
}