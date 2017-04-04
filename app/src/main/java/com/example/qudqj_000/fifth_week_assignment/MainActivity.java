package com.example.qudqj_000.fifth_week_assignment;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        program();
    }

    void program(){

    }
}

class Data{
    private String tablename;
    private String set_time;
    private int pizza;
    private int spaghetti;
    private String membership;
    private String price;

    Data(){}

    Data(String tablename, String set_time, int pizza, int spaghetti, String membership, String price){
        this.tablename = tablename;
        this.set_time = set_time;
        this.pizza = pizza;
        this.spaghetti = spaghetti;
        this.membership = membership;
        this.price = price;
    }


    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getSet_time() {
        return set_time;
    }

    public void setSet_time(String set_time) {
        this.set_time = set_time;
    }

    public int getPizza() {
        return pizza;
    }

    public void setPizza(int pizza) {
        this.pizza = pizza;
    }

    public int getSpaghetti() {
        return spaghetti;
    }

    public void setSpaghetti(int spaghetti) {
        this.spaghetti = spaghetti;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
