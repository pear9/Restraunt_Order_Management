package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Base64;

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

public class choice extends AppCompatActivity implements AsyncResponse {

    public EditText http1;
    String urlsend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        Button send=findViewById(R.id.send);
       http1 = findViewById(R.id.urltext);
        urlsend =http1.getText().toString();


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
            String encode =Base64.encodeToString(st.getBytes(),Base64.DEFAULT);
            HashMap<String,String>postData=new HashMap<String, String>();
            postData.put("text",encode);
            postData.put("image_name","kk.txt");

            PostResponseAsyncTask task =new PostResponseAsyncTask(choice.this, postData, new AsyncResponse() {
                @Override
                public void processFinish(String s) {
                    if(s.contains("upload success")){
                        Toast.makeText(choice.this,"Yahoo",Toast.LENGTH_SHORT).show();
                    }
                    else if(s.contains("upload failed")){
                        Toast.makeText(choice.this,"thukka",Toast.LENGTH_SHORT).show();
                    }
                }
            });

            task.execute(urlsend);
            task.setEachExceptionsHandler(new EachExceptionsHandler() {
                @Override
                public void handleIOException(IOException e) {
                    Toast.makeText(choice.this,"cannot connect server",Toast.LENGTH_SHORT).show();
                }

                @Override
                public void handleMalformedURLException(MalformedURLException e) {
                    Toast.makeText(choice.this,"url error",Toast.LENGTH_SHORT).show();
                }

                @Override
                public void handleProtocolException(ProtocolException e) {
                    Toast.makeText(choice.this,"protocol error",Toast.LENGTH_SHORT).show();
                }

                @Override
                public void handleUnsupportedEncodingException(UnsupportedEncodingException e) {
                    Toast.makeText(choice.this,"encoding server",Toast.LENGTH_SHORT).show();
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
            Toast.makeText(choice.this,"Yahoo",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(choice.this,"thukka",Toast.LENGTH_SHORT).show();
        }
    }
}
