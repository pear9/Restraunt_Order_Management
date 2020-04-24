package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplication.harddrinks;
import com.example.myapplication.lassi;
import com.example.myapplication.softdrink;
import com.example.myapplication.tea;

public class PagerAdapter extends FragmentPagerAdapter {
    private int numoftabs;

    public PagerAdapter(FragmentManager fm,int numoftabs) {
        super(fm);
        this.numoftabs=numoftabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new lassi();

            case 1:
                return  new softdrink();

            case 2:
                return new harddrinks();
            case 3:
                return  new tea();
            default:
                return null;
        }




    }

    @Override
    public int getCount() {
        return numoftabs;
    }
}


