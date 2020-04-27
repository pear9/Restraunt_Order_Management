package com.example.myapplication;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Chicken extends Fragment implements AdapterView.OnItemClickListener {

    public Chicken() {
        // Required empty public constructor
    }
    ListView chicken_list;
    String[]listchicken;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v= inflater.inflate(R.layout.fragment_lassi, container, false);
       chicken_list=v.findViewById(R.id.lassi_list);
       listchicken=getResources().getStringArray(R.array.Chicken);
       teaadapter cadapter= new teaadapter(getActivity(),listchicken);
       chicken_list.setAdapter(cadapter);
       chicken_list.setOnItemClickListener(this);
        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position==0) {
            int c1=1;
            String s = listchicken[position];
            lassidialogue(s,c1);
        }
        if(position==1){
            int c2=2;
            String s = listchicken[position];
            lassidialogue(s, c2);
        }
        if(position==2){
            int c3=2;
            String s = listchicken[position];
            lassidialogue(s, c3);
        }
        if(position==3){
            int c4=4;
            String s = listchicken[position];
            lassidialogue(s, c4);
        }
        if(position==4){
            int c5=5;
            String s = listchicken[position];
            lassidialogue(s, c5);
        }
        if(position==5){
            int c6=6;
            String s = listchicken[position];
            lassidialogue(s, c6);
        }
        if(position==6){
            int c7=7;
            String s = listchicken[position];
            lassidialogue(s, c7);
        }
        if(position==7){
            int c8=8;
            String s = listchicken[position];
            lassidialogue(s, c8);
        }
        if(position==8){
            int c9=9;
            String s = listchicken[position];
            lassidialogue(s, c9);
        }
        if(position==9){
            int c10=10;
            String s = listchicken[position];
            lassidialogue(s, c10);
        }
        if(position==10){
            int c11=11;
            String s = listchicken[position];
            lassidialogue(s, c11);
        }



    }



    private void lassidialogue(String s, final int c1) {
        final AlertDialog.Builder alert =new AlertDialog.Builder(getActivity());
        View mview =getLayoutInflater().inflate(R.layout.alertdialogue,null);
        TextView item_name=mview.findViewById(R.id.alertTitle);
        item_name.setText(s);
        Button okbtn=mview.findViewById(R.id.okbtn);
        Button cancelbtn=mview.findViewById(R.id.cancelbtn);
        final EditText text=mview.findViewById(R.id.quantity);
        item_name.setText(s);
        alert.setView(mview);
        final AlertDialog alertDialog =alert.create();
        alertDialog.setCanceledOnTouchOutside(false);
        final int itemcode=c1;

        okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=text.getText().toString();
                int numberlassi =Integer.parseInt(s1);
                Datacollector chicken=new Datacollector();
                              alertDialog.dismiss();


            }
        });
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }
}
