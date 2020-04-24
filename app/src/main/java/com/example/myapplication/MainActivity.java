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
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity{

private String message;
        private EditText table;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//---------linking buttons from xml to new variable----
        ImageView table1= findViewById(R.id.imageView3);
       table= findViewById(R.id.editText);
        TextView HOTELAPP= findViewById(R.id.HOTELAPP);
        Button Done= findViewById(R.id.done);


        //--------animation
        Animation animation;
        animation = AnimationUtils.loadAnimation(this, R.anim.atg);
        table1.startAnimation(animation);
        HOTELAPP.startAnimation(animation);


        Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String name =table.getText().toString();
               if(name.matches("")){
                   Toast.makeText(MainActivity.this,"INPUT PLEASE",Toast.LENGTH_SHORT).show();
                   return;
               }
                int i =Integer.parseInt(name);
                if(i<21 & i>0){
                    Intent menu=new Intent(MainActivity.this,menucat.class);
                    menu.putExtra("tab1",name);
                            startActivity(menu);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"NO ANY TABLE",Toast.LENGTH_SHORT).show();
                }
            }
        });
        HOTELAPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newadmin = new Intent(MainActivity.this, admin.class);
                startActivity(newadmin);
            }
        });





        }

    }

