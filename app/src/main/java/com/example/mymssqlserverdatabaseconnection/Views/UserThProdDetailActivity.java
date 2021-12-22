package com.example.mymssqlserverdatabaseconnection.Views;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView;

import com.example.mymssqlserverdatabaseconnection.ConnectionHelper;
import com.example.mymssqlserverdatabaseconnection.R;
import com.example.mymssqlserverdatabaseconnection.Requests.Requests;

import java.sql.Connection;
import java.sql.Statement;

public class UserThProdDetailActivity extends AppCompatActivity {
    private ConnectionHelper connectionHelper;
    Connection connection;

    private TextView textViewIdGenreThPr, textViewIdAgeCategoryThPr;
    private TextView textViewNameThPr, textViewNameTheaterThPr, textViewDescriptionThPr;
    private TextView textViewRatingThPr, textViewDurationThPr, textViewStartTimeThPr;
    private TextView textViewDirectorThPr;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_th_prod_detail);
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
    }

    private void findViews() {
        textViewIdGenreThPr = findViewById(R.id.textViewIdGenreThPr);
        textViewIdAgeCategoryThPr = findViewById(R.id.textViewIdAgeCategoryThPr);
        textViewNameThPr = findViewById(R.id.textViewNameThPr);
        textViewNameTheaterThPr = findViewById(R.id.textViewNameTheaterThPr);
        textViewDescriptionThPr = findViewById(R.id.textViewDescriptionThPr);
        textViewRatingThPr = findViewById(R.id.textViewRatingThPr);
        textViewDurationThPr = findViewById(R.id.textViewDurationThPr);
        textViewStartTimeThPr = findViewById(R.id.textViewStartTimeThPr);
        textViewDirectorThPr = findViewById(R.id.textViewDirectorThPr);
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

        textViewIdGenreThPr.setText(Integer.toString(id_genre));
        textViewIdAgeCategoryThPr.setText(Integer.toString(id_age_category));
        textViewNameThPr.setText(name);
        textViewNameTheaterThPr.setText(name_theater);
        textViewDescriptionThPr.setText(description);
        textViewRatingThPr.setText(Float.toString(rating));
        textViewDurationThPr.setText(duration);
        textViewStartTimeThPr.setText(start_time);
        textViewDirectorThPr.setText(director);
    }
}