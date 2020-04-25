package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Chicken extends Fragment {

    public Chicken() {
        // Required empty public constructor
    }
    ListView chicken_list;
    String[]listchicken;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v= inflater.inflate(R.layout.fragment_chicken, container, false);
       chicken_list=v.findViewById(R.id.chicken_list);
       listchicken=getResources().getStringArray(R.array.Chicken);
       teaadapter cadapter= new teaadapter(getActivity(),listchicken);
       chicken_list.setAdapter(cadapter);
        return v;
    }
}
