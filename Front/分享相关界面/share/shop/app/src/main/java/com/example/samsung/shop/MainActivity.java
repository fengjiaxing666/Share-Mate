package com.example.samsung.shop;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView indexView;
    private TextView shoppingView;
    private TextView messageView;
    private TextView myView;
    private IndexFragment indexFragment = new IndexFragment();
    private ShoppingFragment shoppingFragment = new ShoppingFragment();
    private MessageFragment messageFragment = new MessageFragment();
    private MyFragment myFragment = new MyFragment();
    private FragmentManager manager ;
    private Fragment currentFragment = new Fragment();
    private List<TextView> views = new ArrayList<>();
    private RelativeLayout root = null;
    private PopupWindow window = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        indexView = findViewById(R.id.tv_index);
        shoppingView = findViewById(R.id.tv_shopping);
        messageView = findViewById(R.id.tv_message);
        myView = findViewById(R.id.tv_my);

        manager = getSupportFragmentManager();
        showFragment(indexFragment);
        indexView.setTextSize(TypedValue.COMPLEX_UNIT_SP,24);
        indexView.setTextColor(getResources().getColor(R.color.inkGray));

        views.add(indexView);
        views.add(shoppingView);
        views.add(messageView);
        views.add(myView);

        setClickListener();

        //实现 popupwindow 功能
        root = findViewById(R.id.root);
        window = new PopupWindow(root, RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        Button btnShare = findViewById(R.id.btn_share);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(window.isShowing()){
                    window.dismiss();
                }else{
                    showPopupWindow(root);
                    addBackgroundAlpha(0.7f);
                }
            }
        });
    }

    //为每一个 TextView (模拟的选项) 添加监听器
    private void setClickListener(){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.tv_index:
                        showFragment(indexFragment);
                        break;
                    case R.id.tv_shopping:
                        showFragment(shoppingFragment);
                        break;
                    case R.id.tv_message:
                        showFragment(messageFragment);
                        break;
                    case R.id.tv_my:
                        showFragment(myFragment);
                        break;
                }

                //点击改变效果
                for(TextView view : views){
                    TextView tmp = findViewById(v.getId());
                    if(tmp == view){
                        view.setTextColor(getResources().getColor(R.color.inkGray));
                        view.setTextSize(TypedValue.COMPLEX_UNIT_SP,24);
                    }else{
                        view.setTextColor(getResources().getColor(R.color.deepGray));
                        view.setTextSize(TypedValue.COMPLEX_UNIT_SP,22);
                    }
                }
            }

        };

        indexView.setOnClickListener(listener);
        shoppingView.setOnClickListener(listener);
        messageView.setOnClickListener(listener);
        myView.setOnClickListener(listener);
    }

    //显示出指定的页面
    private void showFragment(Fragment fragment){
        //创建 fragment 事务
        FragmentTransaction transaction = manager.beginTransaction();
        //判断传入的fragment 是否是当前正在显示的fragment
        if(fragment != currentFragment)
            transaction.hide(currentFragment);
        //判断要展示的 fragment 是否被添加过
        if(!fragment.isAdded())
            transaction.add(R.id.content,fragment);
        transaction.show(fragment);
        //提交事务
        transaction.commit();
        currentFragment = fragment;
    }

    //点击按钮后弹出选项框
    private void showPopupWindow(RelativeLayout root){

        //设置显示的视图
        LayoutInflater inflater =getLayoutInflater();
        View view = inflater.inflate(R.layout.share_popupwindow_layout,null);
        Button btnCamera = view.findViewById(R.id.btn_camera);
        Button btnPhoto = view.findViewById(R.id.btn_photos);
        Button btnCancel = view.findViewById(R.id.btn_cancel);
        //为弹出框中的每一个按钮
        ClickListener listener = new ClickListener();
        btnCamera.setOnClickListener(listener);
        btnPhoto.setOnClickListener(listener);
        btnCancel.setOnClickListener(listener);

        //将自定义的视图添加到 popupWindow 中
        window.setContentView(view);
        //控制 popupwindow 再点击屏幕其他地方时自动消失
        window.setFocusable(true);
        window.setOutsideTouchable(true);
        window.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                //在弹窗消失时调用
                addBackgroundAlpha(1f);
            }
        });
        //显示 popupWindow 设置 弹出框的位置
        window.showAtLocation(root, Gravity.BOTTOM,0,0);
    }

    // 弹出选项框时为背景加上透明度
    private void addBackgroundAlpha(float alpha){
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.alpha = alpha;
        getWindow().setAttributes(params);
    }

    private class ClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_camera:
                    Intent intent =new Intent();
                    intent.setAction("android.media.action.IMAGE_CAPTURE");
                    intent.addCategory("android .intent.category.DEFAULT");
                    startActivity(intent);
                    break;
                case R.id.btn_photos:
                    break;
                case R.id.btn_cancel:
                    window.dismiss();
                    break;
            }
        }
    }




}

