package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.content.ContentValues.TAG;
import static android.widget.Toast.LENGTH_SHORT;


/**
 * A simple {@link Fragment} subclass.
 */
public class Naan extends Fragment implements AdapterView.OnItemClickListener {

    ListView naan_list;
    String[] listnaan;
    MainActivity nantble=new MainActivity();
    private String str4=nantble.getName();;
    private String itemwrite="llloo";
    private int itemcode;
    private FileOutputStream[] fos1 = {null};
    private int itemno=29;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_lassi, container, false);
        ListView naan_list=v.findViewById(R.id.lassi_list);
        listnaan=getResources().getStringArray(R.array.Naan);
        teaadapter padapter = new teaadapter(getActivity(),listnaan);
        naan_list.setAdapter(padapter);
        naan_list.setOnItemClickListener(this);
        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position==0) {
            String nan = listnaan[position];
             lassidialogue(nan,position);
        }
        if(position==1){
            String nan = listnaan[position];
            lassidialogue(nan, position);
        }
        if(position==2){
            String nan = listnaan[position];
            lassidialogue(nan, position);
        }
        if(position==3){
            String nan = listnaan[position];
            lassidialogue(nan, position);
        }
        if(position==4){
            String nan = listnaan[position];
            lassidialogue(nan, position);
        }
        if(position==5){
            String nan = listnaan[position];
            lassidialogue(nan, position);
        }
        if(position==6){
            String nan = listnaan[position];
            lassidialogue(nan, position);
        }

    }



    private void lassidialogue(final String s, int position) {
        final AlertDialog.Builder alert =new AlertDialog.Builder(getActivity());
        View mview =getLayoutInflater().inflate(R.layout.alertdialogue,null);
        TextView item_name=mview.findViewById(R.id.alertTitle);
        item_name.setText(s);
        Button okbtn=mview.findViewById(R.id.okbtn);
        final Button cancelbtn=mview.findViewById(R.id.cancelbtn);
        final EditText text=mview.findViewById(R.id.quantity);
        item_name.setText(s);
        alert.setView(mview);
        final AlertDialog alertDialog =alert.create();
        alertDialog.setCanceledOnTouchOutside(false);
        itemcode=position+itemno;


        okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s2=text.getText().toString();
                if (s2.isEmpty()){
                    Toast.makeText(getActivity(),"It is empty" ,Toast.LENGTH_SHORT).show();

                }else {
                    int numberlassi = Integer.parseInt(s2);
                    int divide=numberlassi/10;

                    String file1="table"+str4;
                    String file = file1+".txt";
//
                    if (divide >=10){
                        Log.e(TAG,"entered");
                        Toast.makeText(getActivity(),"three", LENGTH_SHORT).show();
                        itemwrite = str4 + ","+itemcode+ "," + s + "," + numberlassi + "\n";}
                    else if(divide<10 & divide>0){
                        itemwrite = str4 + ","+itemcode+"," + s + "," +"0"+ numberlassi + "\n";
                    }
                    else
                        itemwrite = str4 + "," + itemcode + "," + s + "," + "00" + numberlassi + "\n";

                    try {Log.e(TAG,"entered");
                        fos1[0] =getActivity().openFileOutput(file, Context.MODE_APPEND);
                        fos1[0].write(itemwrite.getBytes());
                        Toast.makeText(getActivity(),"saved", LENGTH_SHORT).show();

                    } catch (FileNotFoundException e) {
                        Toast.makeText(getActivity(),"error ", LENGTH_SHORT).show();
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    finally {
                        if(fos1[0] != null){
                            try {
                                fos1[0].close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
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
