package com.example.myapplication;

import android.os.Bundle;
import android.app.Fragment;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class fragment_holder extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_holder);

        Bundle bin1 = getIntent().getExtras();
        String str1;
        str1 = bin1.getString("tab2");
        TextView title=findViewById(R.id.title);
        menushow(str1 ,title);



    }


    public void menushow(String s, TextView title) {
        title.setText(s);
        switch (s) {

            case "salad":
                salad sal = new salad();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.add(R.id.fragmentmenu, sal, null);
                ft.commit();
                break;
            case "soup":
                Soup sop = new Soup();
                FragmentManager fm1 = getSupportFragmentManager();
                FragmentTransaction ft1 = fm1.beginTransaction();
                ft1.add(R.id.fragmentmenu, sop, null);
                ft1.commit();
                break;
            case "chicken":
                Chicken chick = new Chicken();
                FragmentManager fm2 = getSupportFragmentManager();
                FragmentTransaction ft2 = fm2.beginTransaction();
                ft2.add(R.id.fragmentmenu, chick, null);
                ft2.commit();
                break;
            case "curry":
                curry cur = new curry();
                FragmentManager fm6 = getSupportFragmentManager();
                FragmentTransaction ft6 = fm6.beginTransaction();
                ft6.add(R.id.fragmentmenu, cur, null);
                ft6.commit();
                break;


            case "naan":
                Naan nan = new Naan();
                FragmentManager fm4 = getSupportFragmentManager();
                FragmentTransaction ft4 = fm4.beginTransaction();
                ft4.add(R.id.fragmentmenu, nan, null);
                ft4.commit();
                break;
            case "pizza":
                Pizza piz = new Pizza();
                FragmentManager fm3 = getSupportFragmentManager();
                FragmentTransaction ft3 = fm3.beginTransaction();
                ft3.add(R.id.fragmentmenu, piz, null);
                ft3.commit();
                break;
            case "rice":
                riceset ric =new riceset();
                FragmentManager fm5=getSupportFragmentManager();
                FragmentTransaction ft5=fm5.beginTransaction();
                ft5.add(R.id.fragmentmenu,ric,null);
                ft5.commit();
                break;



            default:


        }

    }
}