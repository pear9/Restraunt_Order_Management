package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class menucat extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Bundle bin1;
    ListView list;
    String[] Menu;
    int[] images = {R.drawable.drinks, R.drawable.sal_e, R.drawable.soup_e, R.drawable.curry_e, R.drawable.chicken_e, R.drawable.pizza_e, R.drawable.rice_e, R.drawable.naan_e};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menucat);
        Resources r = getResources();
        Menu = r.getStringArray(R.array.menu);
        list = findViewById(R.id.listview);
        TextView order_no = findViewById(R.id.order);
        listadapter adapter = new listadapter(this, Menu, images);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);


        bin1 = getIntent().getExtras();
        String str1;
        str1 = bin1.getString("tab1");
        check(str1);
        order_no.setText("Order of table"+str1);


    }
    public  void check(String str) {

        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if(position==0){
            Intent drnk = new Intent(menucat.this,tab.class);
            startActivity(drnk);
        }
    }
}





class listadapter extends ArrayAdapter<String>
{
Context context;
int[] images;
String[] title;

    public listadapter(@NonNull Context c, String[] Menu,int imgs[]) {
        super(c, R.layout.listappear,R.id.textView3,Menu);
        this.context=c;
        this.images=imgs;
        this.title=Menu;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.listappear,parent,false);
        ImageView image = row.findViewById(R.id.imageView4);
        TextView item = row.findViewById(R.id.textView3);

        image.setImageResource(images[position]);
        item.setText(title[position]);
        return row;
    }
}