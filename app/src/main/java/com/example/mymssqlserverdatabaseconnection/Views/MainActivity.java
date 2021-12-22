package com.example.mymssqlserverdatabaseconnection.Views;

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

import com.example.mymssqlserverdatabaseconnection.Adapters.MainAdapter;
import com.example.mymssqlserverdatabaseconnection.Models.Genre;
import com.example.mymssqlserverdatabaseconnection.Models.Item;
import com.example.mymssqlserverdatabaseconnection.Models.TheaterProduction;
import com.example.mymssqlserverdatabaseconnection.R;
import com.example.mymssqlserverdatabaseconnection.ViewModels.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainAdapter mainAdapter;
    private MainViewModel mainViewModel;
    private EditText editTextSearch;
    private String tableName;
    private Spinner spinnerTables;
    private String searchText;
    private RecyclerView rcView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextSearch = findViewById(R.id.editTextSearch);
        spinnerTables = findViewById(R.id.spinnerTables);
        initRecyclerView();
    }

    private void initRecyclerView() {
        rcView = findViewById(R.id.recyclerViewResult);
        rcView.setLayoutManager(new LinearLayoutManager(this));

        mainAdapter = new MainAdapter(this);
        rcView.setAdapter(mainAdapter);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        setRcView();

        mainAdapter.setOnItemClickListener(new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Item item) {
                switch (item.getItemType()) {
                    /*case "TheaterProduction":
                        Intent intent = new Intent(MainActivity.this, TheaterProductionDetailActivity.class);
                        TheaterProduction theaterProduction = (TheaterProduction) item;
                        intent.putExtra("id", theaterProduction.getId_theater_production());
                        intent.putExtra("itemText", theaterProduction.getId_genre());
                        intent.putExtra("nameAuthor", theaterProduction.getId_age_category());
                        intent.putExtra("lastnameAuthor", theaterProduction.getName());
                        intent.putExtra("image", theaterProduction.getTheater_name());
                        intent.putExtra("title", theaterProduction.getDescription());
                        intent.putExtra("title", theaterProduction.getRating());
                        intent.putExtra("title", theaterProduction.getDuration());
                        intent.putExtra("title", theaterProduction.getStart_time());
                        intent.putExtra("title", theaterProduction.getDirector());
                        startActivity(intent);
                        break;*/
                    case "Genre":
                        Intent intent = new Intent(MainActivity.this, GenreDetailActivity.class);
                        Genre genre = (Genre) item;
                        Log.d(TAG, genre.getId_genre() + "");
                        intent.putExtra("id_genre", genre.getId_genre());
                        intent.putExtra("name_genre", genre.getName_genre());
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    private void setRcView(){
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
}