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
public class softdrink extends Fragment implements AdapterView.OnItemClickListener {

    public softdrink() {
        // Required empty public constructor
    }

    ListView sftdrinklist;
    String[] softdrink;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
   View sftdrinkview =inflater.inflate(R.layout.fragment_lassi, container, false);
   softdrink=sftdrinkview.getResources().getStringArray(R.array.soft_drinks);
   sftdrinklist=sftdrinkview.findViewById(R.id.lassi_list);
    teaadapter sftadapter=new teaadapter(getActivity(),softdrink);
    sftdrinklist.setAdapter(sftadapter);
    sftdrinklist.setOnItemClickListener(this);

           return sftdrinkview;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position==0) {
            String s = softdrink[position];
            lassidialogue(s);
        }
        if(position==1){
            String s = softdrink[position];
            lassidialogue(s);
        }
        if(position==2){
            String s = softdrink[position];
            lassidialogue(s);
        }
        if(position==3){
            String s = softdrink[position];
            lassidialogue(s);
        }
        if(position==4){
            String s = softdrink[position];
            lassidialogue(s);
        }
        if(position==5){
            String s = softdrink[position];
            lassidialogue(s);
        } if(position==6){
            String s = softdrink[position];
            lassidialogue(s);
        }
        if(position==7){
            String s = softdrink[position];
            lassidialogue(s);
        }

    }



    private void lassidialogue(String s) {
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

        okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=text.getText().toString();
                if (s1.isEmpty()){
                    Toast.makeText(getActivity(),"It is empty" ,Toast.LENGTH_SHORT).show();

                }else {
                    int numberlassi = Integer.parseInt(s1);
                    alertDialog.dismiss();
                }


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


