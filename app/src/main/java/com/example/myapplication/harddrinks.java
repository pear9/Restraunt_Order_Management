package com.example.myapplication;

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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class harddrinks extends Fragment {

    public harddrinks() {
        // Required empty public constructor
    }
        private String[] list;
        private ListView listitem;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_harddrinks, container, false);
        Resources r=getResources();
        list=r.getStringArray(R.array.harddrink);
        listitem=v.findViewById(R.id.Alcohol);
        hlistadapter ladapter = new hlistadapter(getActivity(), list);
        listitem.setAdapter(ladapter);


        return v;
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

