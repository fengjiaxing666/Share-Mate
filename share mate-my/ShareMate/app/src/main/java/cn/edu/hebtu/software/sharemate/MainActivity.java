package cn.edu.hebtu.software.sharemate;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import cn.edu.hebtu.software.sharemate.fragment.MyFragment;
import cn.edu.hebtu.software.sharemate.fragment.TextFragment;


public class MainActivity extends AppCompatActivity {

    private MyFragment myFragment;
    private TextFragment TextFragment;
    private FragmentManager fragmentManager;
    private Fragment currentFragment = new Fragment();
    private TextView homeText;
    private TextView shopText;
    private TextView msgText;
    private TextView meText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myFragment = new MyFragment();
        TextFragment = new TextFragment();
        fragmentManager = getSupportFragmentManager();
        findViews();
        setListener();
        showFragment(myFragment);
//        String intent = getIntent().getStringExtra("name");
//        if(intent.equals("my")){
//            showFragment(myFragment);
//        }
    }

    //获取组件
    public void findViews(){
        homeText = findViewById(R.id.home);
        shopText = findViewById(R.id.shop);
        msgText = findViewById(R.id.msg);
        meText = findViewById(R.id.me);
    }

    //绑定点击事件
    public void setListener(){
        viewOnClickListener onClickListener = new viewOnClickListener();
        homeText.setOnClickListener(onClickListener);
        shopText.setOnClickListener(onClickListener);
        msgText.setOnClickListener(onClickListener);
        meText.setOnClickListener(onClickListener);
    }

    //点击类
    public class viewOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.home){
                homeText.setTextColor(getResources().getColor(R.color.inkGray));
                homeText.setTextSize(18);
                showFragment(TextFragment);
            }else{
                homeText.setTextColor(getResources().getColor(R.color.darkGray));
                homeText.setTextSize(16);
            }
            if(v.getId() == R.id.shop){
                shopText.setTextColor(getResources().getColor(R.color.inkGray));
                shopText.setTextSize(18);
                showFragment(TextFragment);
            }else{
                shopText.setTextColor(getResources().getColor(R.color.darkGray));
                shopText.setTextSize(16);
            }
            if(v.getId() == R.id.msg){
                msgText.setTextColor(getResources().getColor(R.color.inkGray));
                msgText.setTextSize(18);
                showFragment(TextFragment);
            }else{
                msgText.setTextColor(getResources().getColor(R.color.darkGray));
                msgText.setTextSize(16);
            }
            if(v.getId() == R.id.me){
                meText.setTextColor(getResources().getColor(R.color.inkGray));
                meText.setTextSize(18);
                showFragment(myFragment);
            }else{
                meText.setTextColor(getResources().getColor(R.color.darkGray));
                meText.setTextSize(16);
            }
        }
    }
    //展示Fragment
    public void showFragment(Fragment fragment){
        //创建事务并开启
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(fragment != currentFragment){
            transaction.hide(currentFragment);
            if(!fragment.isAdded()){
                    transaction.add(R.id.content,fragment);
            }
            transaction.show(fragment);
            transaction.commit();
            currentFragment = fragment;
        }
    }
}
