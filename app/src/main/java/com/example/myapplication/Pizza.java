package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.io.LineNumberInputStream;


/**
 * A simple {@link Fragment} subclass.
 */
public class Pizza extends Fragment {

    public Pizza() {
        // Required empty public constructor
    }

    ListView pizza_list;
    String[] listpizza;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_pizza, container, false);
        pizza_list=v.findViewById(R.id.pizza_list);
        listpizza=getResources().getStringArray(R.array.Pizza);
        teaadapter padapter = new teaadapter(getActivity(),listpizza);
        pizza_list.setAdapter(padapter);
        return v;
    }
}
