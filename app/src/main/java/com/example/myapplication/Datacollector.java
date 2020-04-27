package com.example.myapplication;

public class Datacollector {
    private int tableno;
    private int quantity;
    private  int itemcode;

    public Datacollector() {
    }

    public Datacollector(int tableno, int quantity, int itemcode) {
        this.tableno = tableno;
        this.quantity = quantity;
        this.itemcode = itemcode;
    }


    public int getTableno() {
        return tableno;
    }

    public void setTableno(int tableno) {
        this.tableno = tableno;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getItemcode() {
        return itemcode;
    }

    public void setItemcode(int itemcode) {
        this.itemcode = itemcode;
    }

}
