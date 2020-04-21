package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//---------linking buttons from xml to new variable----
        ImageView table1=findViewById(R.id.imageView3);
        EditText table_number=findViewById(R.id.table_number);
        TextView HOTELAPP=findViewById(R.id.HOTELAPP);
        Button Done=findViewById(R.id.done);

        table_number.setOnClickListener(this);
        Done.setOnClickListener(this);
        HOTELAPP.setOnClickListener(this);
        //--------animation
        Animation animation;
        animation = AnimationUtils.loadAnimation(this,
                R.anim.atg);
        table1.startAnimation(animation);
                HOTELAPP.startAnimation(animation);



        }
//------to check which button clicked---
    @Override
    public void onClick(View view) {


        switch (view.getId())
        {
            case R.id.done:
                Intent menu=new Intent(this,admin.class);
                startActivity(menu);



            case R.id.HOTELAPP:
                    Intent newadmin=new Intent(this,admin.class);
                    startActivity(newadmin);

            default:

        }
    }
    }

