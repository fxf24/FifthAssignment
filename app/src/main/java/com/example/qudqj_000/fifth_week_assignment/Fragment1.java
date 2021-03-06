package com.example.qudqj_000.fifth_week_assignment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by qudqj_000 on 2017-03-30.
 */

public class Fragment1 extends Fragment {
    public static ArrayList<String> arrayList;
    public static ListView lv1;
    public static ArrayAdapter<String> arrayAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View frag = inflater.inflate(R.layout.fragment1, container, false);
        lv1 =(ListView)frag.findViewById(R.id.list);
        program();
        lv1.setAdapter(arrayAdapter);
        return frag;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    void program(){
        arrayList = new ArrayList<>();
        arrayList.add("사과 테이블(비어있음)");
        arrayList.add("포도 테이블(비어있음)");
        arrayList.add("키위 테이블(비어있음)");
        arrayList.add("자몽 테이블(비어있음)");


        arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arrayList);

        lv1.setAdapter(arrayAdapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FragmentManager fm = getFragmentManager();
                FragmentTransaction tr = fm.beginTransaction();

                switch(position){
                    case 0:
                        if(arrayList.get(position).equals("사과 테이블(비어있음)")) {
                            Fragment2 f2 = Fragment2.newInstance("사과 테이블",0);
                            tr.replace(R.id.fragment2, f2, "사과 테이블");
                            tr.commit();
                            makeToast();
                        }
                        else{
                            Fragment2 f2 = (Fragment2)getFragmentManager().findFragmentByTag("사과 테이블");
                            tr.replace(R.id.fragment2, f2);
                            tr.commit();
                        }
                        break;
                    case 1:
                        if(arrayList.get(position).equals("포도 테이블(비어있음)")) {
                            Fragment2 f2 = Fragment2.newInstance("포도 테이블",1);
                            tr.replace(R.id.fragment2, f2, "포도 테이블");
                            tr.commit();
                            makeToast();
                        }
                        else{
                            Fragment2 f2 = (Fragment2)getFragmentManager().findFragmentByTag("포도 테이블");
                            tr.replace(R.id.fragment2, f2);
                            tr.commit();
                        }
                        break;
                    case 2:
                        if(arrayList.get(position).equals("키위 테이블(비어있음)")) {
                            Fragment2 f2 = Fragment2.newInstance("키위 테이블",2);
                            tr.replace(R.id.fragment2, f2, "키위 테이블");
                            tr.commit();
                            makeToast();
                        }
                        else{
                            Fragment2 f2 = (Fragment2)getFragmentManager().findFragmentByTag("키위 테이블");
                            tr.replace(R.id.fragment2, f2);
                            tr.commit();
                        }
                        break;
                    case 3:
                        if(arrayList.get(position).equals("자몽 테이블(비어있음)")) {
                            Fragment2 f2 = Fragment2.newInstance("자몽 테이블",3);
                            tr.replace(R.id.fragment2, f2, "자몽 테이블");
                            tr.commit();
                            makeToast();
                        }
                        else{
                            Fragment2 f2 = (Fragment2)getFragmentManager().findFragmentByTag("자몽 테이블");
                            tr.replace(R.id.fragment2, f2);
                            tr.commit();
                        }
                        break;
                }
            }
        });
    }

    void makeToast(){
        Toast.makeText(getActivity(), "비어있는 테이블입니다.", Toast.LENGTH_SHORT).show();
    }
}
