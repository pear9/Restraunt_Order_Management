package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


import static android.widget.Toast.LENGTH_SHORT;

public class Main5Activity extends AppCompatActivity {
    MainActivity first=new MainActivity();
    String number=first.getName();
    int number1 =Integer.parseInt(number);
       String file34="table"+number1+".txt";
    String file43 ="output.txt";
    String file12=file34;

    EditText message;
    Button messenger1,messenger2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Log.d("oo", "iii");
        message = findViewById(R.id.message);
        messenger1 = findViewById(R.id.messenger);
        final Button messenger3=findViewById(R.id.messenger3);
        messenger2=findViewById(R.id.messenger2);
        messenger1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nr=new Intent(Main5Activity.this,choice.class);
                startActivity(nr);


                    }
                });
            }







    public void resolver(View v) throws IOException {
        ////reading from table.txt------///
        FileInputStream fis2 = null;
        fis2 = openFileInput(file34);
        InputStreamReader fir2 = new InputStreamReader(fis2);
        BufferedReader bir2 = new BufferedReader(fir2);


        FileOutputStream fos1 = null;
        fos1 = openFileOutput(file43, MODE_PRIVATE);


        String ch = "";


        List<String> tmp = new ArrayList<String>();

        while (ch != null) {
            ch = bir2.readLine();
            tmp.add(ch);

        }

        for (int i = tmp.size() - 2; i >= 0; i--) {
            fos1.write(tmp.get(i).getBytes());
            fos1.write("\n".getBytes());
        }
        fos1.flush();
        fos1.close();
        bir2.close();
        ////closed--------------///

        //--writing in table.txt----////

        //{ opening table.txt in private
        FileOutputStream fos2=null;
        fos2 = openFileOutput(file12, MODE_PRIVATE);

///}
///opening fle output-------/////
        FileInputStream fis3 = null;
        fis3 = openFileInput(file43);
        InputStreamReader fir3 = new InputStreamReader(fis3);
        BufferedReader bir3 = new BufferedReader(fir3);

        String line1 = null;
        line1 = bir3.readLine();



        while(line1 != null)
        {
            boolean flag = false;
            FileInputStream fis4 = null;
            fis4 = openFileInput(file12);
            InputStreamReader fir4 = new InputStreamReader(fis4);
            BufferedReader bir4 = new BufferedReader(fir4);
            
            String line2 = null;
            line2 = bir4.readLine();
            // loop for each line of output.txt
            while(line2 != null)
            {

                String line3= line1.substring(0,line1.length()-3);
                String line4= line2.substring(0,line2.length()-3);


                if(line3.equals(line4))
                {
                    flag = true;
                    break;
                }
                    line2 = bir4.readLine();

            }

            // if flag = false
            // write line of table.txt to output.txt
            if(!flag){
                String line5=line1.substring(line1.length()-3,line1.length());
                if(!(line5.equals("000"))){
                fos2.write(line1.getBytes());
                fos2.write("\n".getBytes());
                // flushing is important here
                fos2.flush();
            }}


            line1 = bir3.readLine();


        }

        // closing resources

        bir3.close();

        fos2.close();

        System.out.println("File operation performed successfully");
    }





}





