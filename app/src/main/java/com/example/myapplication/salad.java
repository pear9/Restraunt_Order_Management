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
public class salad extends Fragment {

    public salad() {
        // Required empty public constructor
    }
    ListView salad_list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_salad, container, false);
        salad_list=v.findViewById(R.id.salad_list);
        String[] listsalad = getResources().getStringArray(R.array.Salad);
        teaadapter saladapter = new teaadapter(getActivity(), listsalad);
        salad_list.setAdapter(saladapter);
        return v;
    }
}
