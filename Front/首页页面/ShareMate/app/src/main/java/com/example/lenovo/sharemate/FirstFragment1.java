package com.example.lenovo.sharemate;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment1 extends Fragment {
    private CustomAdapter customAdapter=null;
    private List<note> notes;
    private ListView listView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_layout2,container,false);
        note st1= new note(R.drawable.a6,"路飞手办，路飞公仔。。。。。。。。","笔记一",R.drawable.a1,"小明","昨天12:00","66","77","88","99");
        note st2= new note(R.drawable.a2,"海贼王手办公仔模型Q版","笔记一",R.drawable.a1,"小红","昨天12:00","646","77","88","99");
        note st3= new note(R.drawable.a3,"路飞手办，三个路飞Q版模型","笔记一",R.drawable.a1,"小绿","昨天12:00","669","77","88","99");
        note st4= new note(R.drawable.a4,"海贼王手办，路飞公仔全套","笔记一",R.drawable.a1,"小花","昨天12:00","666","77","88","99");
        note st5= new note(R.drawable.a5,"路飞生日礼物全套，onepiece手办模型","笔记一",R.drawable.a1,"小强","昨天12:00","667","77","88","99");
        List<note> notes = new ArrayList<>();
        notes.add(st1);
        notes.add(st2);
        notes.add(st3);
        notes.add(st4);
        notes.add(st5);
        listView = view.findViewById(R.id.list);
        customAdapter = new CustomAdapter(getActivity(),R.layout.list_item, notes);
        listView.setAdapter(customAdapter);
        return view;
    }
}
