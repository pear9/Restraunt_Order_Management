package com.example.myapplication;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class datapump {
    public static HashMap<String, List<String>> getData() {
        LinkedHashMap<String, List<String>> expandableListDetail = (LinkedHashMap<String, List<String>>) new LinkedHashMap<String, List<String>>();

        List<String> Veg = new ArrayList<String>();
        Veg.add("Vegetable Curry Set");
        Veg.add("Butter Masala Set");

        List<String> Beef = new ArrayList<String>();
        Beef.add("Beef Curry Set");
        Beef.add("Mame Beef Curry Set");
        Beef.add("Horenso Beef Curry Set");

        List<String> Pork = new ArrayList<String>();
        Pork.add("Pork Curry Set");
        Pork.add("Mame Pork Curry Set");
        Pork.add("Horenso Pork Curry Set");

        List<String> Chicken = new ArrayList<String>();
        Chicken.add("Mame Chicken Curry Set");
        Chicken.add("Horenso Chicken Curry Set");
        Chicken.add("Shahi Chicken Curry Set");
        Chicken.add("Thailand Green Curry Set(Chicken)");
        Chicken.add("Chicken Cheese Curry Set");
        Chicken.add("Chicken Coconut Curry Set");
        Chicken.add("Chicken Curry Set");



        List<String> Others = new ArrayList<String>();
        Others.add("World Spicy No.1 Curry Set");
        Others.add("Kids Curry set");
        Others.add("Mame Curry Set");
        Others.add("Seafood Curry Set");
        Others.add("Shrimp Masala Set");

        expandableListDetail.put("Vegeterian", Veg);
        expandableListDetail.put("Beef", Beef);
        expandableListDetail.put("Pork", Pork);
        expandableListDetail.put("Chicken", Chicken);
        expandableListDetail.put("Others", Others);

        
        return expandableListDetail;
    }
}
