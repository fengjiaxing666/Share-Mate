package cn.edu.hebtu.software.sharemate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import cn.edu.hebtu.software.sharemate.bean.User;

public class NameActivity extends AppCompatActivity {

    private TextView textView;
    private TextView msgText;
    private TextView finishText;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        textView = findViewById(R.id.title);
        msgText = findViewById(R.id.msg);
        editText = findViewById(R.id.content);
        finishText = findViewById(R.id.finish);
        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("user");
        String name = intent.getStringExtra("msg");
        textView.setText(name);
        if(name.equals("姓名")){
            msgText.setText("请输入2-8个字符");
            editText.setText(user.getUserName());
        }else if(name.equals("性别")){
            msgText.setText("请填入男or女  ");
            editText.setText(user.getUserSex());
        }
        finishText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.length()<2){
                    msgText.setText("您输入的小于2个字符");
                }else{
                    msgText.setText("请输入2-8个字符");
                    String content = editText.getText().toString();
                    //把内容存到数据库中
                    NameActivity.this.finish();
                }
            }
        });
        ImageView imageView = findViewById(R.id.back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NameActivity.this.finish();
            }
        });
    }
}
