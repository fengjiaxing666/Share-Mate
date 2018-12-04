package com.example.lenovo.sharemate;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment2 extends Fragment {
    private GridViewAdapter gridViewAdapter=null;
    private List<note> notes;
    private ListView listView;
    private GridView gridView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view= inflater.inflate(R.layout.fragment_layout2,container,false);
        note st1= new note(R.drawable.a6,"路飞手办，路飞公仔。。。。。。。。",R.drawable.a1,"小明","66");
        note st2= new note(R.drawable.a2,"海贼王手办公仔模型Q版",R.drawable.a1,"小红","646");
        note st3= new note(R.drawable.a3,"路飞手办，三个路飞Q版模型",R.drawable.a1,"小绿","669");
        note st4= new note(R.drawable.a4,"海贼王手办，路飞公仔全套",R.drawable.a1,"小花","666");
        note st5= new note(R.drawable.a5,"路飞生日礼物全套，onepiece手办模型",R.drawable.a1,"小强","667");
        List<note> notes = new ArrayList<>();
        notes.add(st1);
        notes.add(st2);
        notes.add(st3);
        notes.add(st4);
        notes.add(st5);
        gridView = view.findViewById(R.id.root);
        //创建Adapter对象
        gridViewAdapter = new GridViewAdapter(getActivity(),R.layout.grid_item, notes);
        //设置Adapter
        gridView.setAdapter(gridViewAdapter);
        gridView.setHorizontalSpacing(5);
        gridView.setVerticalSpacing(5);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("点击了", ""+ position);
                Intent intent = new Intent();
                intent.setClass(getActivity(),FindActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
