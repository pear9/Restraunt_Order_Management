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
public class Soup extends Fragment {

    public Soup() {
        // Required empty public constructor
    }
    ListView soup_list;
    String[] listsoup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_soup, container, false);
        soup_list=v.findViewById(R.id.soup_list);
        listsoup=getResources().getStringArray(R.array.Soup);
        teaadapter sadapter=new teaadapter(getActivity(),listsoup);
        soup_list.setAdapter(sadapter);
        return v;
    }
}
