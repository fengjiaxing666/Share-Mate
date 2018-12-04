package cn.edu.hebtu.software.sharemate.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.hebtu.software.sharemate.AddressActivity;
import cn.edu.hebtu.software.sharemate.FocusActivity;
import cn.edu.hebtu.software.sharemate.PersonalActivity;
import cn.edu.hebtu.software.sharemate.R;
import cn.edu.hebtu.software.sharemate.SettingActivity;
import cn.edu.hebtu.software.sharemate.bean.Note;
import cn.edu.hebtu.software.sharemate.adapter.NoteAdapter;
import cn.edu.hebtu.software.sharemate.bean.User;

public class MyFragment extends Fragment {
    private TextView nameText;
    private TextView idText;
    private TextView introText;
    private ImageView headImg;
    private GridView gridView;
    private NoteAdapter noteAdapter;
    private List<Note> collectionList = new ArrayList<>();
    private List<Note> noteList = new ArrayList<>();
    private User user ;
    private TextView collection;
    private TextView note;
    private TextView focusView;
    private TextView addView;
    private ImageView settingView;
    private Button button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       user = new User(951004,R.drawable.heart,"净汉的小迷妹","女",
               "黑龙江省双鸭山市","1995-10-04","今天是个好日子，心想的事儿都能成");
        View view = inflater.inflate(R.layout.activity_my,container,false);
        findView(view);
        setListener();
        note.setTextColor(getResources().getColor(R.color.warmRed));
        collection.setTextColor(getResources().getColor(R.color.darkGray));
        Note note1 = new Note(R.drawable.heart,"性感女星范冰冰");
        Note note2 = new Note(R.drawable.c,"赵丽颖惊现婚纱照");
        noteList.add(note1);
        noteList.add(note2);
        noteAdapter = new NoteAdapter(getActivity(),R.layout.note_item,noteList);
        gridView.setAdapter(noteAdapter);
        return view;
    }
    public void findView(View view){
        nameText = view.findViewById(R.id.userName);
        nameText.setText(user.getUserName());
        idText = view.findViewById(R.id.userId);
        idText.setText("Share mate号:"+user.getUserId());
        introText = view.findViewById(R.id.userIntro);
        introText.setText(user.getUserIntroduce());
        headImg = view.findViewById(R.id.userPhoto);
        headImg.setImageResource(user.getUserPhoto());
        gridView = view.findViewById(R.id.root);
        collection = view.findViewById(R.id.collection);
        focusView = view.findViewById(R.id.focus);
        addView = view.findViewById(R.id.address);
        note = view.findViewById(R.id.note);
        settingView = view.findViewById(R.id.setting);
        button = view.findViewById(R.id.personal);
    }

    public void setListener(){
        SetOnclickListener listener = new SetOnclickListener();
        collection.setOnClickListener(listener);
        note.setOnClickListener(listener);
        focusView.setOnClickListener(listener);
        addView.setOnClickListener(listener);
        settingView.setOnClickListener(listener);
        button.setOnClickListener(listener);
    }
    public class SetOnclickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.address:
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), AddressActivity.class);
                    intent.putExtra("msg","常住地");
                    intent.putExtra("content",user.getUserAddress());
                    //从数据库中取出当前用户
                    startActivity(intent);
                    break;
                case R.id.note:
                    note.setTextColor(getResources().getColor(R.color.warmRed));
                    collection.setTextColor(getResources().getColor(R.color.darkGray));
                    Note note1 = new Note(R.drawable.heart,"性感女星范冰冰");
                    Note note2 = new Note(R.drawable.c,"赵丽颖惊现婚纱照");
                    noteList.add(note1);
                    noteList.add(note2);
                    noteAdapter = new NoteAdapter(getActivity(),R.layout.note_item,noteList);
                    gridView.setAdapter(noteAdapter);
                    break;
                case R.id.collection:
                    collection.setTextColor(getResources().getColor(R.color.warmRed));
                    note.setTextColor(getResources().getColor(R.color.darkGray));
                    Note collection1 = new Note(R.drawable.b,"明星资讯随时看");
                    Note collection2 = new Note(R.drawable.heart,"旅游时笔芯狂魔");
                    collectionList.add(collection1);
                    collectionList.add(collection2);
                    noteAdapter = new NoteAdapter(getActivity(),R.layout.note_item,collectionList);
                    gridView.setAdapter(noteAdapter);
                    break;
                case R.id.personal:
                    Intent perIntent = new Intent();
                    perIntent.setClass(getActivity(), PersonalActivity.class);
                    perIntent.putExtra("user",user);
                    startActivity(perIntent);
                    break;
                case R.id.focus:
                    Intent focusIntent = new Intent();
                    focusIntent.setClass(getActivity(), FocusActivity.class);
                    startActivity(focusIntent);
                    break;
                case R.id.setting:
                    Intent setIntent = new Intent();
                    setIntent.setClass(getActivity(), SettingActivity.class);
                    setIntent.putExtra("user",user);
                    startActivity(setIntent);
                    break;
            }
        }
    }
}
