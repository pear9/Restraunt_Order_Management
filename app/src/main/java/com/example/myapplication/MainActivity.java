package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity{

private String message;

    public MainActivity() {

    }

    public String getName() {
        return name;
    }
    public String orderfile;
    private static String name;
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


        final FileOutputStream[] fos = {null};


        //--------animation
        Animation animation;
        animation = AnimationUtils.loadAnimation(this, R.anim.atg);
        table1.startAnimation(animation);
        HOTELAPP.startAnimation(animation);
        Log.d("haha","hhaah");

        Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               name =table.getText().toString();
               orderfile ="table"+name+".txt";
               if(name.matches("")){
                   Toast.makeText(MainActivity.this,"INPUT PLEASE", LENGTH_SHORT).show();
                   return;
               }
               int i =Integer.parseInt(name);
                if(i<50 & i>0 ){
///-----------------writing to file named table----------------------//

                    try {
                        fos[0] =openFileOutput(orderfile,MODE_PRIVATE);
                        Toast.makeText(MainActivity.this,"saved "+getFilesDir()+"/"+orderfile, LENGTH_SHORT).show();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } finally {
                        if(fos[0] != null){
                            try {
                                fos[0].flush();
                                fos[0].close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    Intent menu=new Intent(MainActivity.this,menucat.class);
                    menu.putExtra("tab1",name);
                    table.setText("");
                            startActivity(menu);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"NO ANY TABLE", LENGTH_SHORT).show();
                }
            }
        });
        HOTELAPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newadmin = new Intent(MainActivity.this,bluetooth.class);
                startActivity(newadmin);
            }
        });





        }

    }

