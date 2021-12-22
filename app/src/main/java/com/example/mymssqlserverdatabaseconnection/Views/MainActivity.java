package com.example.mymssqlserverdatabaseconnection.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mymssqlserverdatabaseconnection.R;

public class MainActivity extends AppCompatActivity {

    Button reg,sing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reg=findViewById(R.id.reg_main);
        sing=findViewById(R.id.sing_main);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Reg.class);
                startActivity(intent);
            }
        });
        sing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Sign.class);
                startActivity(intent);
            }
        });
    }
}