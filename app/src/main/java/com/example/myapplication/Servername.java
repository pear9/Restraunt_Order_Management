package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import static android.text.TextUtils.isEmpty;

public class Servername extends AppCompatActivity {
    Button set;
    EditText address;
    String servername="server.txt";
    String servadd2= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        set = findViewById(R.id.setserver);
        address = findViewById(R.id.address);
        FileInputStream fis01 = null;
        try {
            fis01 = openFileInput(servername);
            InputStreamReader fir01 = new InputStreamReader(fis01);
            BufferedReader bir01 = new BufferedReader(fir01);
            servadd2 = bir01.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(servadd2.equals("")){
            address.setText("http://");
        }
        else {
            address.setText(servadd2);
        }

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FileOutputStream[] fos = {null};
                String serverfile = "server.txt";
                try {
                    fos[0] = openFileOutput(serverfile, Context.MODE_PRIVATE);
                    if (isEmpty((address.getText()))) {
                        toast("Empty is not allowed");
                    } else {
                        fos[0].write((address.getText().toString()).getBytes());
                        toast("Successfully Added");
                        Intent i3=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i3);
                    }

                } catch (FileNotFoundException e) {
                    toast("cannot write");
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fos[0].close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });



        }
        private void toast (String str){
            Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
        }
    }



