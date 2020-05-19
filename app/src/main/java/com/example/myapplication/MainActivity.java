package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.text.TextUtils.isEmpty;
import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

private String message;
    String servername1="server.txt";
    String servadd1= null;
    final FileOutputStream[] fos = {null};
    Spinner s1;
    private String tablesel="Table";
    public MainActivity() {

    }

    public String getName() {
        return name;
    }
    public String orderfile;
    private static String name;
        private EditText table;
    List<String> categories = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s1=findViewById(R.id.s2);

        SharedPreferences pref=getSharedPreferences("pref",MODE_PRIVATE);
        boolean first =pref.getBoolean("first",true);

        //---first time writing the server.txt file----///////////
        if (first){
            FileOutputStream[] fos = {null};
            String serverfile = "server.txt";
            try {
                fos[0] = openFileOutput(serverfile, Context.MODE_PRIVATE);
                    fos[0].write("http://192.168.1.8/save.php".getBytes());
                }
             catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos[0].close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Intent s2=new Intent(getApplicationContext(),Servername.class);
            SharedPreferences.Editor editor =pref.edit();
            editor.putBoolean("first",false);
            editor.apply();
            startActivity(s2);
        }
        ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this, R.array.menu1,android.R.layout.simple_spinner_item);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(dataAdapter);
        s1.setOnItemSelectedListener(this);

///----------------------------------------------------------------------/////
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
        Log.d("haha","hhaah");

        Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               init();
            }
        });
        HOTELAPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newadmin = new Intent(MainActivity.this,settings.class);
                startActivity(newadmin);
            }
        });





        }

    private void init() {
        name = table.getText().toString();
        if (name.matches("")) {
            Toast.makeText(MainActivity.this, "INPUT PLEASE", LENGTH_SHORT).show();
            return;
        }
        int i = Integer.parseInt(name);
        if (tablesel != "takeout")
        {




            if (i < 21 & i > 0) {
///-----------------writing to file named table----------------------//
                orderfile = "table" + name + ".txt";
                try {
                    fos[0] = openFileOutput(orderfile, MODE_PRIVATE);
                    Toast.makeText(MainActivity.this, "saved " + getFilesDir() + "/" + orderfile, LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    if (fos[0] != null) {
                        try {
                            fos[0].flush();
                            fos[0].close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                Intent menu = new Intent(MainActivity.this, menucat.class);
                menu.putExtra("tab1", name);
                table.setText("");
                startActivity(menu);
            } else {
                Toast.makeText(MainActivity.this, "NO ANY TABLE", LENGTH_SHORT).show();
            }
        } else {


            if (i <6 & i > 0) {
///-----------------writing to file named table----------------------//
                i=i+20;
                name= String.valueOf(i);
                orderfile = "table" +i+ ".txt";
                try {
                    fos[0] = openFileOutput(orderfile, MODE_PRIVATE);
                    Toast.makeText(MainActivity.this, "saved " + getFilesDir() + "/" + orderfile, LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    if (fos[0] != null) {
                        try {
                            fos[0].flush();
                            fos[0].close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                Intent menu = new Intent(MainActivity.this, menucat.class);
                menu.putExtra("tab1", name);
                table.setText("");
                startActivity(menu);
            } else {
                Toast.makeText(MainActivity.this, "NO More Than Five Take-outs", LENGTH_SHORT).show();
            }
        }

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String str=parent.getItemAtPosition(position).toString();
        if (str.equals("Take-out")){
            tablesel="takeout";
            Toast.makeText(MainActivity.this, "Take-outs", LENGTH_SHORT).show();


        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

