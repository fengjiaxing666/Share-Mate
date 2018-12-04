package net.onest.sharemate;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private ImageView back;
    private TextView tv_birth;
    private Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        btnNext.setOnClickListener(new ButtonClickListener());
        back.setOnClickListener(new backClickListener());
        tv_birth.setOnClickListener(new birthClickListener());

    }
    private void findViews(){
        tv_birth = findViewById(R.id.tv_birth);
        btnNext = findViewById(R.id.btn_next);
        back = findViewById(R.id.iv_back);
    }
    //选择生日
    private class birthClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            DatePicker datePicker = findViewById(R.id.datepicker);
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    Calendar calendar1 = Calendar.getInstance();
                    calendar.set(year,monthOfYear,dayOfMonth);
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                }
            });
        }
    }

    //点击返回
    private class backClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
        }
    }
    //点击下一步按钮
    private class ButtonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,SelectInterestActivity.class);
            startActivity(intent);
        }
    }
}
