package cn.edu.hebtu.software.sharemate;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.hebtu.software.sharemate.adapter.FocusAdapter;
import cn.edu.hebtu.software.sharemate.bean.User;


public class FocusActivity extends AppCompatActivity {
    private User user;
    private ListView listView;
    private FocusAdapter focusAdapter;
    private List<User> userList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus);
        User focusUser = new User(158745,R.drawable.c,"徐徐念之","女","河北省","1998-03-13","室友挨个贴佩奇，轮到了我...");
        User focusUser1 = new User(123587,R.drawable.b,"风光","女","河北省","1998-08-18","新的一年，风光无限好~~");
        User focusUser2 = new User(165689,R.drawable.heart,"double V","女","河北省","1998-04-30","800天快乐/爱心/爱心");
        User focusUser3 = new User(158745,R.drawable.c,"似水流年，流年似水","女","河北省","1998-02-26","800天快乐小可爱们，虽然...");
        userList.add(focusUser);
        userList.add(focusUser1);
        userList.add(focusUser2);
        userList.add(focusUser3);
        listView = findViewById(R.id.root);
        focusAdapter = new FocusAdapter(R.layout.focus_item,this,userList);
        listView.setAdapter(focusAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LinearLayout focusLayout = view.findViewById(R.id.focus);
                focusLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showFocusDialog();
                    }
                });
                Intent intent = new Intent();
                intent.setClass(FocusActivity.this,FriendActivity.class);
                intent.putExtra("user",userList.get(position));
                user = userList.get(position);
                startActivity(intent);
            }
        });
        ImageView imageView = findViewById(R.id.back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FocusActivity.this.finish();
            }
        });
    }
    private void showFocusDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("确认不再关注？");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                userList.remove(user);
                //把当前关注的人删除存到数据库里
                dialog.dismiss();
                listView.setAdapter(focusAdapter);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
