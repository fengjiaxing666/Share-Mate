package cn.edu.hebtu.software.sharemate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.hebtu.software.sharemate.adapter.ZanAdapter;
import cn.edu.hebtu.software.sharemate.bean.Note;

public class ZanActivity extends AppCompatActivity {

    private ZanAdapter zanAdapter;
    private GridView gridView;
    private List<Note> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zan);
        Note note1 = new Note(R.drawable.c,"性感女星范冰冰");
        Note note2 = new Note(R.drawable.b,"赵丽颖婚纱照");
        Note note3 = new Note(R.drawable.heart,"旅游途中的笔芯");
        list.add(note1);
        list.add(note2);
        list.add(note3);
        gridView =findViewById(R.id.root);
        zanAdapter= new ZanAdapter(this,R.layout.zan_item,list);
        gridView.setAdapter(zanAdapter);
        ImageView imageView = findViewById(R.id.back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ZanActivity.this, SettingActivity.class);
                intent.putExtra("user",getIntent().getSerializableExtra("user"));
                startActivity(intent);
            }
        });
    }
}
