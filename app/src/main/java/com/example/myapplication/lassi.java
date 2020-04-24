package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class lassi extends Fragment {
    private TextView Numb_blueberry, Numb_mango,Numb_straw,Numb_kiwi,Numb_masala,Numb_plain;
    private SeekBar BlueBerry, Mango,Strawberry,Kiwi,Masala,Plain;
    private int N_P,N_B, N_M,N_S,N_K,N_Ma,man;
    public lassi() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lassi, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){

        BlueBerry = getView().findViewById(R.id.seek_blueberry);
        Mango = getView().findViewById(R.id.seek_mango);
        Strawberry=getView().findViewById(R.id.seek_straw);
        Kiwi = getView().findViewById(R.id.seek_kiwi);
        Masala=getView().findViewById(R.id.seek_masala);
        Plain=getView().findViewById(R.id.seek_plain);

        Numb_blueberry = getView().findViewById(R.id.no_blueberry);
        Numb_mango = getView().findViewById(R.id.no_mango);
        Numb_straw = getView().findViewById(R.id.no_strawberry);
        Numb_kiwi = getView().findViewById(R.id.no_kiwi);
        Numb_masala=getView().findViewById(R.id.no_masala);
        Numb_plain=getView().findViewById(R.id.no_plain);


        Plain.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                N_P = progress;
                Numb_blueberry.setText(" " + N_P + " ");
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }





        });
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

            }
        });
        Strawberry.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                N_S = progress;

                Numb_straw.setText(" " + N_S + " ");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        Kiwi.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                N_K = progress;

                Numb_kiwi.setText(" " + N_K + " ");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        Masala.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                N_Ma = progress;

                Numb_masala.setText(" " + N_Ma + " ");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        }
    }

