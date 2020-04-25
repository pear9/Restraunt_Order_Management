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
public class Naan extends Fragment {

    public Naan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_naan, container, false);
        ListView naan_list=v.findViewById(R.id.naan_list);
        String[] listnaan=getResources().getStringArray(R.array.Naan);
        teaadapter padapter = new teaadapter(getActivity(),listnaan);
        naan_list.setAdapter(padapter);
        return v;
    }
}
