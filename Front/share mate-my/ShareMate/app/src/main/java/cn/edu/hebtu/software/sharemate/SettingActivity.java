package cn.edu.hebtu.software.sharemate;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.edu.hebtu.software.sharemate.bean.User;
import cn.edu.hebtu.software.sharemate.fragment.MyFragment;

public class SettingActivity extends AppCompatActivity {

    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ImageView imageView = findViewById(R.id.back);
        LinearLayout setPer = findViewById(R.id.setPer);
        LinearLayout zanText = findViewById(R.id.zan);
        user = (User) getIntent().getSerializableExtra("user");
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SettingActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        setPer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this,PersonalActivity.class);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });
        zanText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SettingActivity.this,ZanActivity.class);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });
    }
}
