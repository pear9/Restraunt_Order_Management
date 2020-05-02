package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class tab extends AppCompatActivity {
    Bundle bin2;
    String str2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        bin2 = getIntent().getExtras();
        str2 = bin2.getString("tab1");

        TabLayout tabLayout=findViewById(R.id.tabLayout);
        TabItem tablassi=findViewById(R.id.lassi);
        TabItem tabsoftdrink=findViewById(R.id.softdrink);
        TabItem tabharddrink=findViewById(R.id.harddrink);
        TabItem tabtea=findViewById(R.id.tea);
        final ViewPager viewPager =findViewById(R.id.viewpager);


        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(pagerAdapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



    }
}
