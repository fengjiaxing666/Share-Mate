package net.onest.sharemate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class RegisterActivity extends AppCompatActivity {

    private ImageView back;
    private ImageView photo;
    private EditText userName;
    private EditText password;
    private EditText phone;
    private Button btnTrue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findViews();
        back.setOnClickListener(new backClickListener());
        btnTrue.setOnClickListener(new ButtonClickListener());
    }
    private void findViews(){
        back = findViewById(R.id.iv_back);
        photo = findViewById(R.id.photo);
        userName = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
        phone = findViewById(R.id.et_phone);
        btnTrue = findViewById(R.id.btn_true);
    }
    //点击返回
    private class backClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
            startActivity(intent);
        }
    }
    //点击确定按钮
    private class ButtonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }
}
