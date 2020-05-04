package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.EachExceptionsHandler;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.HashMap;

public class navigation_learning extends AppCompatActivity implements AsyncResponse {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_learning);
        Button send=findViewById(R.id.send);



    }
        public void load(View v){
            FileInputStream fis =null;
            try{
                fis =openFileInput("table12.txt");
                InputStreamReader isr =new InputStreamReader(fis);
                BufferedReader br =new BufferedReader(isr);
                StringBuilder sb = new StringBuilder();
                String text;
                while((text=br.readLine())!=null){
                    sb.append(text).append("\n");
                }
                String st =sb.toString();
                HashMap<String,String>postData=new HashMap<String, String>();
                postData.put("image",st);

                PostResponseAsyncTask task =new PostResponseAsyncTask(navigation_learning.this, postData, new AsyncResponse() {
                    @Override
                    public void processFinish(String s) {

                    }
                });
                task.execute("http://192.168.1.8/test/new_save.php");
                task.setEachExceptionsHandler(new EachExceptionsHandler() {
                    @Override
                    public void handleIOException(IOException e) {
                        Toast.makeText(navigation_learning.this,"cannot server",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void handleMalformedURLException(MalformedURLException e) {
                        Toast.makeText(navigation_learning.this,"url error",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void handleProtocolException(ProtocolException e) {
                        Toast.makeText(navigation_learning.this,"protocol server",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void handleUnsupportedEncodingException(UnsupportedEncodingException e) {
                        Toast.makeText(navigation_learning.this,"encoding server",Toast.LENGTH_SHORT).show();
                    }
                });

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                if(fis!=null){
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    @Override
    public void processFinish(String s) {
        if(s.contains("upload success")){
            Toast.makeText(navigation_learning.this,"Yahoo",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(navigation_learning.this,"thukka",Toast.LENGTH_SHORT).show();
        }
    }
}
