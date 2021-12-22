package com.example.mymssqlserverdatabaseconnection.Views;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mymssqlserverdatabaseconnection.R;

public class GenreDetailActivity extends AppCompatActivity {
    private TextView idGenre;
    private EditText nameGenre;
    private Button change;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre_detail);
        Log.d(TAG,"onCreate: called");

        idGenre = findViewById(R.id.textViewIdGenre);
        nameGenre = findViewById(R.id.editTextNameGenre);
        change = findViewById(R.id.buttonChangeGenre);
        //Получаем данные из Intent'а и проверяем на наличие id
        Intent intent = getIntent();
        if(intent != null && intent.hasExtra("id_genre")) {
            id = intent.getIntExtra("id_genre", -1);
        }
        else {
            finish();
        }

        id = intent.getIntExtra("id_genre",-1);
        String name_genre;
        name_genre = intent.getStringExtra("name_genre");
        idGenre.setText(id +"");
        nameGenre.setText(name_genre);
    }
}