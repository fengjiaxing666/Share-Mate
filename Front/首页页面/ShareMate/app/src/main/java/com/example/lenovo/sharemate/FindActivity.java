package com.example.lenovo.sharemate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FindActivity extends AppCompatActivity {
    private CustomAdapter customAdapter=null;
    private List<note> notes;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        Button button = findViewById(R.id.fanhui);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(FindActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

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
        listView = findViewById(R.id.list);
        customAdapter = new CustomAdapter(this,R.layout.list_item, notes);
        listView.setAdapter(customAdapter);
    }
}
