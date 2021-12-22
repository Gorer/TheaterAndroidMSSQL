package com.example.mymssqlserverdatabaseconnection.Views;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mymssqlserverdatabaseconnection.ConnectionHelper;
import com.example.mymssqlserverdatabaseconnection.R;

import java.sql.Connection;
import java.sql.Statement;

public class Reg extends AppCompatActivity {


    Connection connect;
    String connectionResult="";
    EditText fio_field,phone_field,pass_field;
    Button reg_field;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        fio_field=findViewById(R.id.fio_reg);
        phone_field=findViewById(R.id.phone_reg);
        pass_field=findViewById(R.id.pass_reg);
        reg_field=findViewById(R.id.reg_reg);

        reg_field.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InsertIntoDataBase();
            }
        });
    }

    public void InsertIntoDataBase(){
        String fio=fio_field.getText().toString();
        String phone=phone_field.getText().toString();
        String pass=pass_field.getText().toString();

        try{
            ConnectionHelper connectionHelper = ConnectionHelper.getInstance();
            connect = connectionHelper.connection();
            if(connect != null){
                String query = "insert into clients (fio,phone,pass) values ('"+fio+"',"+phone+","+pass+")";
                Statement st=connect.createStatement();


                System.out.println("result"+ st.executeUpdate(query));
                finish();
            }
            else {
                connectionResult="Check Connection";
            }
        }
        catch (Exception e){
            Toast.makeText(this, connectionResult, Toast.LENGTH_SHORT).show();
            Log.e("errоооor here 3 : ", e.getMessage());
        }
    }
}