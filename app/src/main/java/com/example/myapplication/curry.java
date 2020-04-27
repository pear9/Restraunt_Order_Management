package com.example.myapplication;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class curry extends Fragment {

    public curry() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_curry, container, false);
        ExpandableListView expandableListView;
            ExpandableListAdapter expandableListAdapter;
            final List<String>expandableitems;
            final HashMap<String, List<String>> expandableListDetail;

                expandableListView = v.findViewById(R.id.expandableListView);
                expandableListDetail =datapump.getData();
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
                            lassidialogue(s);
                        }
                        if (position == 1) {
                            String s = child;
                            lassidialogue(s);
                        }
                        if (position == 2) {
                            String s = child;
                            lassidialogue(s);
                        }
                        if (position == 3) {
                            String s = child;
                            lassidialogue(s);
                        }
                        if (position == 4) {
                            String s = child;
                            lassidialogue(s);
                        }
                        if (position == 5) {
                            String s = child;
                            lassidialogue(s);
                        }
                        if (position == 6) {
                            String s = child;
                            lassidialogue(s);
                        }
                        if (position == 7) {
                            String s = child;
                            lassidialogue(s);
                        }
                        return false;

                    }







                });




        return v;}


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
    }}

