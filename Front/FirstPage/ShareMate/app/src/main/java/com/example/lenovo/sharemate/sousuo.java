package com.example.lenovo.sharemate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class sousuo extends AppCompatActivity {
    private SousuoAdapter gridViewAdapter=null;
    private List<note> notes;
    private ListView listView;
    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sousuo);

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
        gridView = findViewById(R.id.ss);
        //创建Adapter对象
        gridViewAdapter = new SousuoAdapter(this,R.layout.sousuo_item, notes);
        //设置Adapter
        gridView.setAdapter(gridViewAdapter);
    }
}
