package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class drinks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

    Button las= findViewById(R.id.lassi);
    Button admin= findViewById(R.id.button2);

    las.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent lassi1 = new Intent(drinks.this,lasi.class);

            startActivity(lassi1);
        }
    });





    }



}
