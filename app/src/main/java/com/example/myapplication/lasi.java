package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class lasi extends AppCompatActivity {
    private TextView Numb_blueberry, Numb_mango;
    private SeekBar BlueBerry, Mango;
    private int N_B, N_M, man;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lasi);

        DisplayMetrics dml = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dml);

        int width = dml.widthPixels;
        int height = dml.heightPixels;

        getWindow().setLayout((int) (width * .7), (int) (height * .8));


        BlueBerry = (SeekBar) findViewById(R.id.seek_blueberry);
        Mango = (SeekBar) findViewById(R.id.seek_mango);
        Numb_blueberry = (TextView) findViewById(R.id.no_blueberry);
        Numb_mango = (TextView) findViewById(R.id.no_mango);

        BlueBerry.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                N_B = progress;
                Numb_blueberry.setText(" " + N_B + " ");
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                recordB(N_B);
            }


        });


        Mango.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                N_M = progress;

                Numb_mango.setText(" " + N_M + " ");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            recordM(N_M);
            }
        });}


        public int recordM( int n_m){
            order_drink mango;
            mango = new order_drink();
            mango.setMango_lassi(n_m);
            man = mango.getMango_lassi();
            Toast.makeText(this, man, Toast.LENGTH_SHORT).show();
            return 0;

        }


        public int recordB( int n_m)
        {
            order_drink blueberry;
            blueberry = new order_drink();
            blueberry.setBlueberry_lassi(n_m);
            int blu = blueberry.getBlueberry_lassi();
            Toast.makeText(this, blu, Toast.LENGTH_SHORT).show();
            return 0;
        }


    }
