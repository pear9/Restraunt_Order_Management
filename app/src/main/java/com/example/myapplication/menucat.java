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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class menucat extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Bundle bin1;
    ListView list;
    Button done;
    public String str1;
    String[] Menu;
    int[] images = {R.drawable.drinks, R.drawable.sal_e, R.drawable.soup_e, R.drawable.curry_e, R.drawable.chicken_e, R.drawable.pizza_e, R.drawable.rice_e, R.drawable.naan_e};
    MainActivity test =new MainActivity();
    String test1=test.getName();
    int number1 =Integer.parseInt(test1);
    String file34="table"+number1+".txt";
    String file43 ="output.txt";
    String file12=file34;
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
        done=findViewById(R.id.Done);




//        bin1 = getIntent().getExtras();
//        str1 = bin1.getString("tab1");
//        check(str1);

        order_no.setText("Order of table "+test1);

        check(test1);

    }
    public  void check(String str) {

        Toast.makeText(this,"table "+str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if(position==0){
            Intent drnk = new Intent(menucat.this,tab.class);
            drnk.putExtra("tab1",str1);
            startActivity(drnk);


        }
        if(position==1){
            Intent intent=new Intent(menucat.this,fragment_holder.class);
            intent.putExtra("tab2","salad");

            startActivity(intent);

        }
        if(position==2)
        {
            Intent intent=new Intent(menucat.this,fragment_holder.class);
            intent.putExtra("tab2","soup");

            startActivity(intent);
        }
        if(position==3)
        {
            Intent intent=new Intent(menucat.this,fragment_holder.class);
            intent.putExtra("tab2","curry");

            startActivity(intent);
        }

        if(position==4)
        {
            Intent intent=new Intent(menucat.this,fragment_holder.class);
            intent.putExtra("tab2","chicken");

            startActivity(intent);
        }
        if(position==5)
        {
            Intent intent=new Intent(menucat.this,fragment_holder.class);
            intent.putExtra("tab2","pizza");

            startActivity(intent);
        }
        if(position==6)
        {
            Intent intent=new Intent(menucat.this,fragment_holder.class);
            intent.putExtra("tab2","naan");
            startActivity(intent);
        }
        if(position==7)
        {
            Intent intent=new Intent(menucat.this,fragment_holder.class);
            intent.putExtra("tab2","rice");

            startActivity(intent);
        }


    }
    public void sort(View v) throws IOException {


        ////reading from table.txt------///
        FileInputStream fis2 = null;
        fis2 = openFileInput(file34);
        InputStreamReader fir2 = new InputStreamReader(fis2);
        BufferedReader bir2 = new BufferedReader(fir2);


        FileOutputStream fos1 = null;
        fos1 = openFileOutput(file43, MODE_PRIVATE);


        String ch = "";


        List<String> tmp = new ArrayList<String>();

        while (ch != null) {
            ch = bir2.readLine();
            tmp.add(ch);

        }

        for (int i = tmp.size() - 2; i >= 0; i--) {
            fos1.write(tmp.get(i).getBytes());
            fos1.write("\n".getBytes());
        }
        fos1.flush();
        fos1.close();
        bir2.close();
        ////closed--------------///

        //--writing in table.txt----////

        //{ opening table.txt in private
        FileOutputStream fos2=null;
        fos2 = openFileOutput(file12, MODE_PRIVATE);

///}
///opening fle output-------/////
        FileInputStream fis3 = null;
        fis3 = openFileInput(file43);
        InputStreamReader fir3 = new InputStreamReader(fis3);
        BufferedReader bir3 = new BufferedReader(fir3);

        String line1 = null;
        line1 = bir3.readLine();



        while(line1 != null)
        {
            boolean flag = false;
            FileInputStream fis4 = null;
            fis4 = openFileInput(file12);
            InputStreamReader fir4 = new InputStreamReader(fis4);
            BufferedReader bir4 = new BufferedReader(fir4);

            String line2 = null;
            line2 = bir4.readLine();
            // loop for each line of output.txt
            while(line2 != null)
            {

                String line3= line1.substring(0,line1.length()-3);
                String line4= line2.substring(0,line2.length()-3);


                if(line3.equals(line4))
                {
                    flag = true;
                    break;
                }
                line2 = bir4.readLine();

            }

            // if flag = false
            // write line of table.txt to output.txt
            if(!flag){
                String line5=line1.substring(line1.length()-3,line1.length());
                if(!(line5.equals("000"))){
                    fos2.write(line1.getBytes());
                    fos2.write("\n".getBytes());
                    // flushing is important here
                    fos2.flush();
                }}


            line1 = bir3.readLine();


        }

        // closing resources

        bir3.close();

        fos2.close();


        Intent nav=new Intent(menucat.this,navigation_learning.class);
        startActivity(nav);
    }




}





class listadapter extends ArrayAdapter<String>
{
Context context;
int[] images;
String[] title;

    public listadapter(@NonNull Context c, String[] Menu, int[] imgs) {
        super(c, R.layout.listappear,R.id.textView3,Menu);
        this.context=c;
        this.images=imgs;
        this.title=Menu;

    }

    class holder{

        public ImageView image;
        TextView item;
        holder(View v){
            image = v.findViewById(R.id.imageView4);
           item = v.findViewById(R.id.textView3);
        }

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        holder hold=null;
        if(row == null){
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        row=inflater.inflate(R.layout.listappear,parent,false);
        hold=new holder(row);
        row.setTag(hold);
                }

        else hold = (holder) row.getTag();

        hold.image.setImageResource(images[position]);
        hold.item.setText(title[position]);
        return row;
    }





    }
