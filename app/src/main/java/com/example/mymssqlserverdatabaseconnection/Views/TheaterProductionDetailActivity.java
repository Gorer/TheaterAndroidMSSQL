package com.example.mymssqlserverdatabaseconnection.Views;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mymssqlserverdatabaseconnection.ConnectionHelper;
import com.example.mymssqlserverdatabaseconnection.R;
import com.example.mymssqlserverdatabaseconnection.Requests.Requests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TheaterProductionDetailActivity extends AppCompatActivity {
    private ConnectionHelper connectionHelper;
    Connection connection;

    private TextView textViewIdTheaterProduction;
    private EditText editTextIdGenreThPr, editTextIdAgeCategoryThPr;
    private EditText editTextNameThPr, editTextNameTheaterThPr, editTextDescriptionThPr;
    private EditText editTextRatingThPr, editTextDurationThPr, editTextStartTimeThPr;
    private EditText editTextDirectorThPr;
    private Button change;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theater_production_detail);
        Log.d(TAG,"onCreate: called");

        findViews();
        //Получаем данные из Intent'а и проверяем на наличие id
        Intent intent = getIntent();
        if(intent != null && intent.hasExtra("id_theater_production")) {
            id = intent.getIntExtra("id_theater_production", -1);
        }
        else {
            finish();
        }
        getAndSetDataFromIntent(intent);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    connectionHelper = ConnectionHelper.getInstance();
                    connection = connectionHelper.connection();
                    if (connection != null) {
                        String tableName = "theater_production";
                        String fields[];

                        Statement st = connection.createStatement();
                        st.executeUpdate(Requests.UPDATE(tableName,"id_genre",
                                Integer.parseInt(editTextIdGenreThPr.getText().toString()),
                                Integer.parseInt(textViewIdTheaterProduction.getText().toString())));
                        st.executeUpdate(Requests.UPDATE(tableName,"id_age_category",
                                Integer.parseInt(editTextIdAgeCategoryThPr.getText().toString()),
                                Integer.parseInt(textViewIdTheaterProduction.getText().toString())));
                        st.executeUpdate(Requests.UPDATE(tableName,"name",
                                editTextNameThPr.getText().toString(),
                                Integer.parseInt(textViewIdTheaterProduction.getText().toString())));
                        st.executeUpdate(Requests.UPDATE(tableName,"theater_name",
                                editTextNameTheaterThPr.getText().toString(),
                                Integer.parseInt(textViewIdTheaterProduction.getText().toString())));
                        st.executeUpdate(Requests.UPDATE(tableName,"description",
                                editTextDescriptionThPr.getText().toString(),
                                Integer.parseInt(textViewIdTheaterProduction.getText().toString())));
                        st.executeUpdate(Requests.UPDATE(tableName,"rating",
                                Float.parseFloat(editTextRatingThPr.getText().toString()),
                                Integer.parseInt(textViewIdTheaterProduction.getText().toString())));
                        st.executeUpdate(Requests.UPDATE(tableName,"duration",
                                editTextDurationThPr.getText().toString(),
                                Integer.parseInt(textViewIdTheaterProduction.getText().toString())));
                        st.executeUpdate(Requests.UPDATE(tableName,"start_time",
                                editTextStartTimeThPr.getText().toString(),
                                Integer.parseInt(textViewIdTheaterProduction.getText().toString())));
                        st.executeUpdate(Requests.UPDATE(tableName,"director",
                                editTextDirectorThPr.getText().toString(),
                                Integer.parseInt(textViewIdTheaterProduction.getText().toString())));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void findViews() {
        textViewIdTheaterProduction = findViewById(R.id.textViewIdTheaterProduction);
        editTextIdGenreThPr = findViewById(R.id.editTextIdGenreThPr);
        editTextIdAgeCategoryThPr = findViewById(R.id.editTextIdAgeCategoryThPr);
        editTextNameThPr = findViewById(R.id.editTextNameThPr);
        editTextNameTheaterThPr = findViewById(R.id.editTextNameTheaterThPr);
        editTextDescriptionThPr = findViewById(R.id.editTextDescriptionThPr);
        editTextRatingThPr = findViewById(R.id.editTextRatingThPr);
        editTextDurationThPr = findViewById(R.id.editTextDurationThPr);
        editTextStartTimeThPr = findViewById(R.id.editTextStartTimeThPr);
        editTextDirectorThPr = findViewById(R.id.editTextDirectorThPr);
        change = findViewById(R.id.buttonChangeThPr);
    }

    private void getAndSetDataFromIntent(Intent intent) {
        id = intent.getIntExtra("id_theater_production",-1);
        int id_genre, id_age_category;
        float rating;
        String name, name_theater, description, duration, start_time, director;
        id_genre = intent.getIntExtra("id_genre",-1);
        id_age_category = intent.getIntExtra("id_age_category",-1);
        name = intent.getStringExtra("name");
        name_theater = intent.getStringExtra("theater_name");
        description = intent.getStringExtra("description");
        rating = intent.getFloatExtra("rating", -1.0f);
        duration = intent.getStringExtra("duration");
        start_time = intent.getStringExtra("start_time");
        director = intent.getStringExtra("director");

        textViewIdTheaterProduction.setText(Integer.toString(id));
        editTextIdGenreThPr.setText(Integer.toString(id_genre));
        editTextIdAgeCategoryThPr.setText(Integer.toString(id_age_category));
        editTextNameThPr.setText(name);
        editTextNameTheaterThPr.setText(name_theater);
        editTextDescriptionThPr.setText(description);
        editTextRatingThPr.setText(Float.toString(rating));
        editTextDurationThPr.setText(duration);
        editTextStartTimeThPr.setText(start_time);
        editTextDirectorThPr.setText(director);
    }
}