package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class Main3Activity extends AppCompatActivity {
     ConstraintLayout lo;
    ImageView introim;
    TextView introtx;

    static int time=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        introim= findViewById(R.id.intro_im);
        introtx= findViewById(R.id.intro_tx);

        Animation animation;
        animation = AnimationUtils.loadAnimation(this,
                R.anim.atg);

        introim.startAnimation(animation);
        introtx.startAnimation(animation);

        //start animation and then go to next screen after 3 seonds

        new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
        Intent table = new Intent(Main3Activity.this,MainActivity.class);
        startActivity(table);
        Main3Activity.this.finish();
    }
},time);


            }


    }

