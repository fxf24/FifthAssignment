package com.example.qudqj_000.fifth_week_assignment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by qudqj_000 on 2017-03-30.
 */

public class Fragment1 extends Fragment {
    ArrayList<String> arrayList;
    ListView lv1;
    ArrayAdapter<String> arrayAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View frag = inflater.inflate(R.layout.fragment1, container, false);
        lv1 =(ListView)frag.findViewById(R.id.list);
        program();
        return frag;
    }

    void program(){
        arrayList = new ArrayList<>();
        arrayList.add("사과 table");
        arrayList.add("포도 table");
        arrayList.add("키위 table");
        arrayList.add("자몽 table");

        arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arrayList);
        lv1.setAdapter(arrayAdapter);
    }

}
