package net.onest.sharemate;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ForgetPasswordActivity extends AppCompatActivity {

    private TextView tvSpinner;
    private LinearLayout btnSpinner;
    private ImageView back;
    private Button btnTrue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        findViews();
        back.setOnClickListener(new backClickListener());
        btnTrue.setOnClickListener(new ButtonClickListener());
        btnSpinner.setOnClickListener(new btnSpinnerClickListener());
    }
    private void findViews(){
        back = findViewById(R.id.iv_back);
        btnTrue = findViewById(R.id.btn_true);
        btnSpinner = findViewById(R.id.btn_spinner);
        tvSpinner = findViewById(R.id.tv_spinner);
    }
    //选择地区和地区代码
    private class btnSpinnerClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ForgetPasswordActivity.this,CountryActivity.class);
            startActivityForResult(intent, 12);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode)
        {
            case 12:
                if (resultCode == RESULT_OK)
                {
                    Bundle bundle = data.getExtras();
//                    String countryName = bundle.getString("countryName");
                    String countryNumber = bundle.getString("countryNumber");

                    tvSpinner.setText(countryNumber);
//                    tv1.setText(countryName);

                }
                break;

            default:
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    //点击返回
    private class backClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ForgetPasswordActivity.this,PhonePswdLoginActivity.class);
            startActivity(intent);
        }
    }
    //点击确定
    private class ButtonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ForgetPasswordActivity.this,VerifyCodeActivity.class);
            startActivity(intent);
        }
    }
}
