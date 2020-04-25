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
public class softdrink extends Fragment {

    public softdrink() {
        // Required empty public constructor
    }

    ListView sftdrinklist;
    String[] softdrink;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
   View sftdrinkview =inflater.inflate(R.layout.fragment_softdrink, container, false);
   softdrink=sftdrinkview.getResources().getStringArray(R.array.soft_drinks);
   sftdrinklist=sftdrinkview.findViewById(R.id.sftdrnklist);
    teaadapter sftadapter=new teaadapter(getActivity(),softdrink);
    sftdrinklist.setAdapter(sftadapter);

           return sftdrinkview;
    }
}


