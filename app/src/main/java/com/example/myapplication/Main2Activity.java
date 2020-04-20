package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Bundle bin1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bin1 = getIntent().getExtras();
        String str1;


        str1 = bin1.getString("tab1");
        check(str1);
        TextView tableid;

        tableid = findViewById(R.id.ordertableno);
        tableid.setText("order for " + str1);


        Button drink = findViewById(R.id.drink_cat);

        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent drnk = new Intent(Main2Activity.this,drinks.class);
                startActivity(drnk);
            }
        });


    }

 public  void check(String str) {

     Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
 }}