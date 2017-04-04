package com.example.qudqj_000.fifth_week_assignment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by qudqj_000 on 2017-03-30.
 */

public class Fragment2 extends Fragment {
    TextView t1, t2, t3, t4, t5, t6;
    Button b1, b2, b3;
    Data data;
    int price;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View frag = inflater.inflate(R.layout.fragment2, container, false);
        t1 = (TextView)frag.findViewById(R.id.table_name);
        t2 = (TextView)frag.findViewById(R.id.set_time);
        t3 = (TextView)frag.findViewById(R.id.spaghetti);
        t4 = (TextView)frag.findViewById(R.id.pizza);
        t5 = (TextView)frag.findViewById(R.id.membership);
        t6 = (TextView)frag.findViewById(R.id.price);
        b1 = (Button)frag.findViewById(R.id.new_order);
        b2 = (Button)frag.findViewById(R.id.edit_info);
        b3 = (Button)frag.findViewById(R.id.reset);

        program();
        setTitle();

        return frag;
    }

    void program(){
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOrder();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public static Fragment2 newInstance(String title){
        Fragment2 f2 = new Fragment2();

        Bundle args = new Bundle();
        args.putString("title", title);
        f2.setArguments(args);

        return f2;
    }

    void setTitle(){
        String name = "";
        Bundle args = getArguments();
        if(args != null){
            name = args.getString("title");
        }
        t1.setText(name);
    }

    void setOrder(){
        data = new Data();
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm");
        String format = sdf.format(date);
        data.setSet_time(format);

        View view = getActivity().getLayoutInflater().inflate(R.layout.custom_dialog, null);
        final EditText sp = (EditText)view.findViewById(R.id.spaghettiNum);
        final EditText pz = (EditText)view.findViewById(R.id.pizzaNum);
        final String[] membership = {"기본멤버쉽","VIP멤버쉽"};

        AlertDialog.Builder dlg = new AlertDialog.Builder(getActivity());
        dlg.setTitle("새 주문")
                .setView(view)
                .setIcon(R.mipmap.ic_launcher)
                .setSingleChoiceItems(membership, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        data.setMembership(membership[which]);
                    }
                })
                .setPositiveButton("닫기", null)
                .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String s = sp.getText().toString();
                        String p = pz.getText().toString();
                        int spa = Integer.parseInt(s);
                        int piz = Integer.parseInt(p);
                        data.setSpaghetti(spa);
                        data.setPizza(piz);
                    }
                })
                .create();
        price = 10000*data.getSpaghetti()+12000*data.getPizza();
//        if(data.getMembership().equals("기본멤버쉽")){
//            price = (price/10)*9;
//        }
//        else{
//            price = (price/10)*7;
//        }
        data.setPrice(price);

        setText(data);
    }
    public void setText(Data data){
        t2.setText(data.getSet_time());
        t3.setText(String.valueOf(data.getSpaghetti()));
        t4.setText(String.valueOf(data.getPizza()));
        t5.setText(data.getMembership());
        t6.setText(String.valueOf(data.getPrice()) + "원");
    }
}
