package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
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
import java.util.Map;

import static com.android.volley.Request.*;

public class navigation_learning extends AppCompatActivity  {
        private String encoded,image_name;
        File file;
    TextView finalorder;
    StringBuilder sb;
    String st;
    MainActivity test =new MainActivity();
    String test1=test.getName();
    String file_s="table"+test1+".txt";
    String servername="server.txt";
    String servadd = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_learning);
        Button send=findViewById(R.id.button);
        finalorder=findViewById(R.id.final_orders);


        try{
            ////---------------Reading server file-----------------///////////
            FileInputStream fis01 = null;
            fis01 = openFileInput(servername);
            InputStreamReader fir01 = new InputStreamReader(fis01);
            BufferedReader bir01 = new BufferedReader(fir01);
            servadd = bir01.readLine();
            /////////----------------------------------------------/////////////////

            FileInputStream fis =null;
            fis =openFileInput(file_s);
            InputStreamReader isr =new InputStreamReader(fis);
            BufferedReader br =new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();

            String text;
            while((text=br.readLine())!=null){
                sb.append(text).append("\n");
            }
            st =sb.toString();
            finalorder.setText(sb.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
        public void load(View v) {


            new Encode_file().execute();
        }

    private class Encode_file extends AsyncTask<Void,Void,Void> {


        @Override
        protected Void doInBackground(Void... voids) {
            encoded=Base64.encodeToString(st.getBytes(),0);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            makeRequest();
        }
    }

    private void makeRequest() {
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest request =new StringRequest(Method.POST,servadd,
        new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("uploaded success")){
                    Toast.makeText(navigation_learning.this,"Order sent",Toast.LENGTH_SHORT).show();
                    Intent last=new Intent(getApplicationContext(),MainActivity.class);

                    startActivity(last);

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
    Toast.makeText(navigation_learning.this,"error",Toast.LENGTH_SHORT).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
               HashMap<String,String> map =new HashMap<>();
               map.put("text",encoded);
               map.put("image_name",file_s);
               return map;
            }
        } ;
        requestQueue.add(request);
    }
}
