package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class lassi extends Fragment {

    public lassi() {
        // Required empty public constructor
    }
    String[] lassilist;

    ListView lassi_list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View lassi_view=inflater.inflate(R.layout.fragment_lassi, container, false);
        lassilist=getResources().getStringArray(R.array.lassi);
        lassi_list=lassi_view.findViewById(R.id.lassi_list);
        teaadapter tadapter = new teaadapter(getActivity(),lassilist);
        lassi_list.setAdapter(tadapter);
        return lassi_view;

    }



        }


