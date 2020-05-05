package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Context;
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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.widget.Toast.LENGTH_SHORT;


/**
 * A simple {@link Fragment} subclass.
 */
public class tea extends Fragment implements AdapterView.OnItemClickListener{

    public tea() {
        // Required empty public constructor
    }

    String[] tealist;
    ListView list_tea;
    MainActivity tableno=new MainActivity();
    String str4=tableno.getName();
    MainActivity tea2table=new MainActivity();
    private String file=tea2table.orderfile;
    private int itemcode;
    private int itemno=72;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_lassi, container, false);
        list_tea=v.findViewById(R.id.lassi_list);
        tealist=getResources().getStringArray(R.array.tea);
        teaadapter tadapter = new teaadapter(getActivity(),tealist);
        list_tea.setAdapter(tadapter);
        list_tea.setOnItemClickListener(this);
        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position==0) {
            String s = tealist[position];
            dialogue(s, position);
        }
        if(position==1){
            String s = tealist[position];
            dialogue(s, position);
        }
        if(position==2){
            String s = tealist[position];
            dialogue(s, position);
        }
        if(position==3){
            String s = tealist[position];
            dialogue(s, position);
        }
        if(position==4){
            String s = tealist[position];
            dialogue(s,position);
        }
        if(position==5){
            String s = tealist[position];
            dialogue(s, position);
        }
        }



    void dialogue(final String s, int position) {
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
        itemcode=position+itemno;
        okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1=text.getText().toString();
                if (s1.isEmpty()){
                    Toast.makeText(getActivity(),"It is empty" ,Toast.LENGTH_SHORT).show();

                }else {
                    int numberlassi = Integer.parseInt(s1);
                    int divide=numberlassi/10;
                    FileOutputStream[] fos = {null};
                    String file1="table"+str4;
                    String file = file1+".txt";

                    String itemwrite;
                    if (divide >=10){
                        itemwrite = str4 + ","+itemcode+ "," + s + "," + numberlassi + "\n";}
                    else if(divide>0 &divide<10){
                        itemwrite = str4 + ","+itemcode+"," + s + "," +"0"+ numberlassi + "\n";
                    }
                    else{
                        itemwrite = str4 + ","+itemcode+"," + s + "," +"00"+ numberlassi + "\n";
                    }

                    try {
                        fos[0] =getActivity().openFileOutput(file, Context.MODE_APPEND);
                        fos[0].write(itemwrite.getBytes());
                        Toast.makeText(getActivity(),"saved "+getActivity().getFilesDir(), LENGTH_SHORT).show();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    finally {
                        if(fos[0] != null){
                            try {
                                fos[0].close();
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


class teaadapter extends ArrayAdapter<String>{

    String[] title;
    Context context;
    public teaadapter(@NonNull Context context, String[] list_tea) {
        super(context,R.layout.listfooditem,R.id.items,list_tea);
        this.title=list_tea;
        this.context=context;
    }

class tlstholder{
            TextView item;
            tlstholder(View v) {
                item = v.findViewById(R.id.items);

            }
        }





    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
       tlstholder hold=null;
        if(row == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.listfooditem,parent,false);
            hold=new tlstholder(row);
            row.setTag(hold);
        }

        else hold = (tlstholder) row.getTag();


        hold.item.setText(title[position]);
        return row;
    }
}