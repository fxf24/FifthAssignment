package com.example.qudqj_000.fifth_week_assignment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by qudqj_000 on 2017-03-30.
 */

public class Fragment2 extends Fragment {
    TextView t1, t2, t3, t4, t5, t6;
    Button b1, b2, b3;
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

    public void setText(Data data){
        t1.setText(data.getTablename());
        t2.setText(data.getSet_time());
        t3.setText(data.getSpaghetti());
        t4.setText(data.getPizza());
        t5.setText(data.getMembership());
        t6.setText(data.getPrice() + "원");
    }
}
