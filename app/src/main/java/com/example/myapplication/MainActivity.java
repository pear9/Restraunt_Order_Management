package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//---------linking buttons from xml to new variable----
        ImageButton table1=findViewById(R.id.table1);
        ImageButton table2=findViewById(R.id.table2);
        ImageButton table3=findViewById(R.id.table3);
        ImageButton table4=findViewById(R.id.table4);
        ImageButton table5=findViewById(R.id.table5);
        TextView HOTELAPP=findViewById(R.id.HOTELAPP);


        table1.setOnClickListener(this);
        table2.setOnClickListener(this);
        table3.setOnClickListener(this);
        table4.setOnClickListener(this);
        table5.setOnClickListener(this);
        HOTELAPP.setOnClickListener(this);
        //--------animation
        Animation animation;
        animation = AnimationUtils.loadAnimation(this,
                R.anim.atg);
        table1.startAnimation(animation);
        table2.startAnimation(animation);
        table3.startAnimation(animation);
        table4.startAnimation(animation);
        table5.startAnimation(animation);
        HOTELAPP.startAnimation(animation);



        }
//------to check which button clicked---
    @Override
    public void onClick(View view) {


        switch (view.getId())
        {
            case R.id.table1:


                FirebaseDatabase db =FirebaseDatabase.getInstance();
                DatabaseReference myref =db.getReference("tables");
                myref.setValue("table no 1");


                Intent menu1=new Intent(this,Main2Activity.class);
                menu1.putExtra("tab1","table1");

                startActivity(menu1);
                break;

            case R.id.table2:
                Intent menu2=new Intent(this,Main2Activity.class);
                menu2.putExtra("tab1","table2");
                startActivity(menu2);
                break;

            case R.id.table3:
                Intent menu3=new Intent(this,Main2Activity.class);
                menu3.putExtra("tab1","table3");
                startActivity(menu3);
                break;

            case R.id.table4:
                Intent menu4=new Intent(this,Main2Activity.class);
                menu4.putExtra("tab1","table4");
                startActivity(menu4);
                break;



            case R.id.table5:
                Intent menu5=new Intent(this,Main2Activity.class);
                menu5.putExtra("tab1","table5");
                startActivity(menu5);
                break;

            case R.id.HOTELAPP:
                    Intent newadmin=new Intent(this,admin.class);
                    startActivity(newadmin);

            default:

        }
    }
    }

