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
import com.example.mymssqlserverdatabaseconnection.Models.Item;
import com.example.mymssqlserverdatabaseconnection.Models.TheaterProduction;
import com.example.mymssqlserverdatabaseconnection.R;
import com.example.mymssqlserverdatabaseconnection.ViewModels.MainViewModel;

import java.util.List;

public class UserActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_user);

        editTextSearch = findViewById(R.id.editTextUserSearch);
        spinnerTables = findViewById(R.id.spinnerUserTables);
        initRecyclerView();
    }

    private void initRecyclerView() {
        rcView = findViewById(R.id.recyclerViewUserResult);
        rcView.setLayoutManager(new LinearLayoutManager(this));

        mainAdapter = new MainAdapter(this);
        rcView.setAdapter(mainAdapter);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        setRcView();

        mainAdapter.setOnItemClickListener(new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Item item) {
                Intent intent = new Intent(UserActivity.this, UserThProdDetailActivity.class);
                TheaterProduction theaterProduction = (TheaterProduction) item;
                Log.d(TAG, theaterProduction.getId_theater_production() +
                        " " + theaterProduction.getName());
                intent.putExtra("id_theater_production", theaterProduction.getId_theater_production());
                intent.putExtra("id_genre", theaterProduction.getId_genre());
                intent.putExtra("id_age_category", theaterProduction.getId_age_category());
                intent.putExtra("name", theaterProduction.getName());
                intent.putExtra("theater_name", theaterProduction.getTheater_name());
                intent.putExtra("description", theaterProduction.getDescription());
                intent.putExtra("rating", theaterProduction.getRating());
                intent.putExtra("duration", theaterProduction.getDuration());
                intent.putExtra("start_time", theaterProduction.getStart_time());
                intent.putExtra("director", theaterProduction.getDirector());
                startActivity(intent);
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
        String[] tables = getResources().getStringArray(R.array.user_spinner_tables);
        return tables[position];
    }

    public void sqlButton(View view){
        searchText = editTextSearch.getText().toString();
        setTableName();
        setRcView();
    }
}