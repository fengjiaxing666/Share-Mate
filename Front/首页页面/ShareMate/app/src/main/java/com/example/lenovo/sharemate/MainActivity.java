package com.example.lenovo.sharemate;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private FragmentTabHost fragmentTabHost;
    private Map<String,View> TabspecViews = new HashMap<>();
    private Map<String,ImageView> imageViews = new HashMap<>();
    private Map<String,TextView> textViews = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentTabHost = findViewById(android.R.id.tabhost);
        //初始化
        fragmentTabHost.setup(this,getSupportFragmentManager(),android.R.id.tabcontent);
        fragmentTabHost.getTabWidget().setDividerDrawable(null);
        //创建选项卡对象
        TabHost.TabSpec tabSpec1 = fragmentTabHost.newTabSpec("tab1")
                .setIndicator(getTabSpecView("首页",0,"tab1"));
        //添加选项卡
        fragmentTabHost.addTab(tabSpec1,FirstFragment.class,null);

        TabHost.TabSpec tabSpec2 = fragmentTabHost.newTabSpec("tab2")
                .setIndicator(getTabSpecView("商城",0,"tab2"));
        //添加选项卡
        fragmentTabHost.addTab(tabSpec2,FirstFragment.class,null);

        TabHost.TabSpec tabSpec3 = fragmentTabHost.newTabSpec("tab3")
                .setIndicator(getTabSpecView("",R.drawable.fabu,"tab3"));
        //添加选项卡
        fragmentTabHost.addTab(tabSpec3,FirstFragment.class,null);

        TabHost.TabSpec tabSpec4 = fragmentTabHost.newTabSpec("tab4")
                .setIndicator(getTabSpecView("消息",0,"tab4"));
        //添加选项卡
        fragmentTabHost.addTab(tabSpec4,FirstFragment.class,null);

        TabHost.TabSpec tabSpec5 = fragmentTabHost.newTabSpec("tab5")
                .setIndicator(getTabSpecView("我",0,"tab5"));
        //添加选项卡
        fragmentTabHost.addTab(tabSpec5,FirstFragment.class,null);
        //默认选中首页
        //设置默认选中某个选项卡
        fragmentTabHost.setCurrentTab(0);
        TextView textView = textViews.get("tab1");
        textView.setTextColor(getResources().
                getColor(R.color.inkGray));
        //textView.setTextSize(R.dimen.textsize2);
        //监听选项卡
        fragmentTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Log.e("点击了选项卡",tabId);
                Set<String> keys=TabspecViews.keySet();//返回所有key
                for(String str:keys){
                    //View view = TabspecViews.get(str);
                    if(str.equals(tabId)){
                        if(str.equals("tab1")){
                            TextView textView1 = textViews.get("tab1");
                            textView1.setTextColor(getResources().
                                    getColor(R.color.inkGray));
                            TextView textView2 = textViews.get("tab2");
                            textView2.setTextColor(getResources().
                                    getColor(R.color.textcolor));
                            TextView textView3 = textViews.get("tab3");
                            textView3.setTextColor(getResources().
                                    getColor(R.color.textcolor));
                            TextView textView4 = textViews.get("tab4");
                            textView4.setTextColor(getResources().
                                    getColor(R.color.textcolor));
                            TextView textView5 = textViews.get("tab5");
                            textView5.setTextColor(getResources().
                                    getColor(R.color.textcolor));
                        }else if(str.equals("tab2")){
                            TextView textView1 = textViews.get("tab1");
                            textView1.setTextColor(getResources().
                                    getColor(R.color.textcolor));
                            TextView textView2 = textViews.get("tab2");
                            textView2.setTextColor(getResources().
                                    getColor(R.color.inkGray));
                            TextView textView3 = textViews.get("tab3");
                            textView3.setTextColor(getResources().
                                    getColor(R.color.textcolor));
                            TextView textView4 = textViews.get("tab4");
                            textView4.setTextColor(getResources().
                                    getColor(R.color.textcolor));
                            TextView textView5 = textViews.get("tab5");
                            textView5.setTextColor(getResources().
                                    getColor(R.color.textcolor));
                        }else if(str.equals("tab3")){
                            TextView textView1 = textViews.get("tab1");
                            textView1.setTextColor(getResources().
                                    getColor(R.color.textcolor));
                            TextView textView2 = textViews.get("tab2");
                            textView2.setTextColor(getResources().
                                    getColor(R.color.textcolor));
                            TextView textView3 = textViews.get("tab3");
                            textView3.setTextColor(getResources().
                                    getColor(R.color.inkGray));
                            TextView textView4 = textViews.get("tab4");
                            textView4.setTextColor(getResources().
                                    getColor(R.color.textcolor));
                            TextView textView5 = textViews.get("tab5");
                            textView5.setTextColor(getResources().
                                    getColor(R.color.textcolor));
                        }else if(str.equals("tab4")){
                            TextView textView1 = textViews.get("tab1");
                            textView1.setTextColor(getResources().
                                    getColor(R.color.textcolor));
                            TextView textView2 = textViews.get("tab2");
                            textView2.setTextColor(getResources().
                                    getColor(R.color.textcolor));
                            TextView textView3 = textViews.get("tab3");
                            textView3.setTextColor(getResources().
                                    getColor(R.color.textcolor));
                            TextView textView4 = textViews.get("tab4");
                            textView4.setTextColor(getResources().
                                    getColor(R.color.inkGray));
                            TextView textView5 = textViews.get("tab5");
                            textView5.setTextColor(getResources().
                                    getColor(R.color.textcolor));
                        }else if(str.equals("tab5")){
                            TextView textView1 = textViews.get("tab1");
                            textView1.setTextColor(getResources().
                                    getColor(R.color.textcolor));
                            TextView textView2 = textViews.get("tab2");
                            textView2.setTextColor(getResources().
                                    getColor(R.color.textcolor));
                            TextView textView3 = textViews.get("tab3");
                            textView3.setTextColor(getResources().
                                    getColor(R.color.textcolor));
                            TextView textView4 = textViews.get("tab4");
                            textView4.setTextColor(getResources().
                                    getColor(R.color.textcolor));
                            TextView textView5 = textViews.get("tab5");
                            textView5.setTextColor(getResources().
                                    getColor(R.color.inkGray));
                        }
                    }
                }
            }
        });
    }


    private View getTabSpecView(String name, int imageId, String tag){
        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.tabspesc_layout,null);
        ImageView imageView = view.findViewById(R.id.image);
        imageView.setImageResource(imageId);
        TextView textView = view.findViewById(R.id.text);
        textView.setText(name);
        textView.setTextSize(15);
        textView.setTextColor(getResources().
                getColor(R.color.textcolor));
        textViews.put(tag,textView);
        TabspecViews.put(tag,view);
        imageViews.put(tag,imageView);
        return view;
    }
}
