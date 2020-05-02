package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;


/**
 * A simple {@link Fragment} subclass.
 */
public class curry extends Fragment {

    public curry() {
        // Required empty public constructor
    }
    MainActivity currytble=new MainActivity();
    private String str4=currytble.getName();
    String itemwrite;
    private int itemno=0;
    private int itemcode;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_curry, container, false);
        ExpandableListView expandableListView;
            ExpandableListAdapter expandableListAdapter;
            final List<String>expandableitems;
            final LinkedHashMap<String, List<String>> expandableListDetail;

                expandableListView = v.findViewById(R.id.expandableListView);
                expandableListDetail = (LinkedHashMap<String, List<String>>) datapump.getData();
               expandableitems = new ArrayList<String>(expandableListDetail.keySet());
                expandableListAdapter = new expandablelist(getContext(),expandableitems, expandableListDetail);
                expandableListView.setAdapter(expandableListAdapter);
                expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

                    @Override
                    public void onGroupExpand(int groupPosition) {

                    }
                });

                expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

                    @Override
                    public void onGroupCollapse(int groupPosition) {


                    }
                });


                expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                    @Override
                    public boolean onChildClick(ExpandableListView parent, View v,
                                                int groupPosition, int childPosition, long id) {
                        int position = childPosition;
                        String child = expandableListDetail.get(
                                expandableitems.get(groupPosition)).get(
                                childPosition);
                        if (position == 0) {
                            String s = child;
                            lassidialogue(s,childPosition,groupPosition);
                        }
                        if (position == 1) {
                            String s = child;
                            lassidialogue(s, childPosition, groupPosition);
                        }
                        if (position == 2) {
                            String s = child;
                            lassidialogue(s, childPosition, groupPosition);
                        }
                        if (position == 3) {
                            String s = child;
                            lassidialogue(s, childPosition, groupPosition);
                        }
                        if (position == 4) {
                            String s = child;
                            lassidialogue(s, childPosition, groupPosition);
                        }
                        if (position == 5) {
                            String s = child;
                            lassidialogue(s, childPosition, groupPosition);
                        }
                        if (position == 6) {
                            String s = child;
                            lassidialogue(s, childPosition, groupPosition);
                        }
                        if (position == 7) {
                            String s = child;
                            lassidialogue(s, childPosition, groupPosition);
                        }
                        return false;

                    }







                });




        return v;}


    private void lassidialogue(final String s, int childPosition, int groupPosition) {
        if(groupPosition==0){
            itemno=5;
        }
        if(groupPosition==1){
            itemno=7;
        }
        if(groupPosition==2){
            itemno=10;
        }
        if(groupPosition==3){
            itemno=13;
        }
        if(groupPosition==4){
            itemno=20;
        }

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
        itemcode=childPosition+itemno;

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

                    if (divide >=10){
                        itemwrite = str4 + ","+itemcode+ "," + s + "," + numberlassi + "\n";}
                    else if(divide>0 & divide<10){
                        itemwrite = str4 + ","+itemcode+"," + s + "," +"0"+ numberlassi + "\n";
                    }
                    else{
                        itemwrite = str4 + ","+itemcode+"," + s + "," +"00"+ numberlassi + "\n";
                    }

                    try {
                        fos[0] = getActivity().openFileOutput(file, Context.MODE_APPEND);
                        fos[0].write(itemwrite.getBytes());
                        Toast.makeText(getActivity(), "saved " + getActivity().getFilesDir(), LENGTH_SHORT).show();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (fos[0] != null) {
                            try {
                                fos[0].close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        alertDialog.dismiss();
                    }
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
    }}

