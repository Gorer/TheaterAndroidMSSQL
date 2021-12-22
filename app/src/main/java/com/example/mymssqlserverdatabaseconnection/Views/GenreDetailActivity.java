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
        change = findViewById(R.id.buttonChange);
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
        //int id_genre;
        //String lastnameGenre;
        name_genre = intent.getStringExtra("name_genre");
        //id_genre = intent.getIntExtra();
        idGenre.setText(id +"");
        nameGenre.setText(name_genre);
        //quoteText.setText(intent.getStringExtra("quoteText"));
        //title.setText(intent.getStringExtra("title"));
        /*try {
            Picasso.get().load(intent.getStringExtra("image")).into(imageView);
            //imageView.setImageURI(Uri.parse(intent.getStringExtra("image")));
        }
        catch (NullPointerException e){

        }*/
    }
}