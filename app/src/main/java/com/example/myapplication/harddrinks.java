package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class harddrinks extends Fragment implements AdapterView.OnItemClickListener {

    public harddrinks() {
        // Required empty public constructor
    }
        private String[] hdlist;
        private ListView Alcohol;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_lassi, container, false);
        Resources r=getResources();
        hdlist=r.getStringArray(R.array.harddrink);
        Alcohol=v.findViewById(R.id.lassi_list);
        hlistadapter ladapter = new hlistadapter(getActivity(), hdlist);
        Alcohol.setAdapter(ladapter);
        Alcohol.setOnItemClickListener(this);
        return v;
        }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position==0) {
            String s = hdlist[position];
                lassidialogue(s);
        }
        if(position==1){
            String s = hdlist[position];
            lassidialogue(s);
        }
        if(position==2){
            String s = hdlist[position];
            lassidialogue(s);
        }
        if(position==3){
            String s = hdlist[position];
            lassidialogue(s);
        }
        if(position==4){
            String s = hdlist[position];
            lassidialogue(s);
        }
        if(position==5){
            String s = hdlist[position];
            lassidialogue(s);
        }
        if(position==6){
            String s = hdlist[position];
            lassidialogue(s);
        }
        if(position==7){
            String s = hdlist[position];
            lassidialogue(s);
        }
        if(position==8){
            String s = hdlist[position];
            lassidialogue(s);
        }
        if(position==9){
            String s = hdlist[position];
            lassidialogue(s);
        }
        if(position==10){
            String s = hdlist[position];
            lassidialogue(s);
        }
        if(position==11){
            String s = hdlist[position];
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
class hlistadapter extends ArrayAdapter<String>
{
    Context context;
    String[] title;

    public hlistadapter(@NonNull Context c, String[] Menu) {
        super(c, R.layout.listfooditem,R.id.items,Menu);
        this.context=c;
        this.title=Menu;

    }

    class holder{


        TextView item;
        holder(View v){ item = v.findViewById(R.id.items);
        }

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        holder hold=null;
        if(row == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.listfooditem,parent,false);
            hold=new holder(row);
            row.setTag(hold);
        }

        else hold = (holder) row.getTag();


        hold.item.setText(title[position]);
        return row;
    }
}

