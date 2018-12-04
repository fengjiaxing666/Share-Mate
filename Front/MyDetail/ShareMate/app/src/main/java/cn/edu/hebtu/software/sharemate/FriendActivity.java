package cn.edu.hebtu.software.sharemate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.hebtu.software.sharemate.adapter.NoteAdapter;
import cn.edu.hebtu.software.sharemate.bean.Note;
import cn.edu.hebtu.software.sharemate.bean.User;

public class FriendActivity extends AppCompatActivity {

    private TextView nameView;
    private TextView introView;
    private TextView idView;
    private ImageView photoView;
    private ImageView backView;
    private TextView collection;
    private TextView note;
    private GridView gridView;
    private NoteAdapter noteAdapter;
    private List<Note> collectionList = new ArrayList<>();
    private List<Note> noteList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        nameView = findViewById(R.id.userName);
        idView = findViewById(R.id.userId);
        photoView = findViewById(R.id.userPhoto);
        introView = findViewById(R.id.userIntro);
        backView = findViewById(R.id.back);
        collection = findViewById(R.id.collection);
        note = findViewById(R.id.note);
        gridView = findViewById(R.id.root);
        User user = (User) getIntent().getSerializableExtra("user");
        idView.setText("Share Mate号："+user.getUserId());
        nameView.setText(user.getUserName());
        photoView.setImageResource(user.getUserPhoto());
        introView.setText(user.getUserIntroduce());
        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FriendActivity.this.finish();
            }
        });
        note.setTextColor(getResources().getColor(R.color.warmRed));
        collection.setTextColor(getResources().getColor(R.color.darkGray));
        Note note1 = new Note(R.drawable.heart,"性感女星范冰冰");
        Note note2 = new Note(R.drawable.c,"赵丽颖惊现婚纱照");
        noteList.add(note1);
        noteList.add(note2);
        noteAdapter = new NoteAdapter(FriendActivity.this,R.layout.note_item,noteList);
        gridView.setAdapter(noteAdapter);
        collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                collection.setTextColor(getResources().getColor(R.color.warmRed));
                note.setTextColor(getResources().getColor(R.color.darkGray));
                Note collection1 = new Note(R.drawable.b,"明星资讯随时看");
                Note collection2 = new Note(R.drawable.heart,"旅游时笔芯狂魔");
                collectionList.add(collection1);
                collectionList.add(collection2);
                noteAdapter = new NoteAdapter(FriendActivity.this,R.layout.note_item,collectionList);
                gridView.setAdapter(noteAdapter);
            }
        });
        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                note.setTextColor(getResources().getColor(R.color.warmRed));
                collection.setTextColor(getResources().getColor(R.color.darkGray));
                Note note1 = new Note(R.drawable.heart,"性感女星范冰冰");
                Note note2 = new Note(R.drawable.c,"赵丽颖惊现婚纱照");
                noteList.add(note1);
                noteList.add(note2);
                noteAdapter = new NoteAdapter(FriendActivity.this,R.layout.note_item,noteList);
                gridView.setAdapter(noteAdapter);
            }
        });
    }
}
