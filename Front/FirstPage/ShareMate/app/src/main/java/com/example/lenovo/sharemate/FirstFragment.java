package com.example.lenovo.sharemate;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FirstFragment extends Fragment {
    private Map<String,View> TabspecViews = new HashMap<>();
    private Map<String,ImageView> imageViews = new HashMap<>();
    private Map<String,TextView> textViews = new HashMap<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_layout,container,false);
        Button button = view.findViewById(R.id.more);
        Button sousuo = view.findViewById(R.id.sousuo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("点击了", "more");
                Intent intent = new Intent();
                intent.setClass(getActivity(),FindActivity.class);
                startActivity(intent);
            }
        });
        sousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("点击了", "sousuo");
                Intent intent = new Intent();
                intent.setClass(getActivity(),sousuo.class);
                startActivity(intent);
            }
        });
        //获取tabhost组件
        FragmentTabHost tabHost = view.findViewById(android.R.id.tabhost);
        //初始化Tabhost容器
        tabHost.setup(getContext(),getChildFragmentManager(),android.R.id.tabcontent);
        tabHost.getTabWidget().setDividerDrawable(null);
        //创建选项卡对象
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("tab6")
                .setIndicator(getTabSpecView("关注","tab6"));
        //添加选项卡
        tabHost.addTab(tabSpec1,FirstFragment1.class,null);
        //创建选项卡对象
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("tab7")
                .setIndicator(getTabSpecView("发现","tab7"));
        //添加选项卡
        tabHost.addTab(tabSpec2,SecondFragment.class,null);
        //创建选项卡对象
        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("tab8")
                .setIndicator(getTabSpecView("附近","tab8"));
        //添加选项卡
        tabHost.addTab(tabSpec3,FirstFragment2.class,null);
        //设置默认选中某个选项卡
        tabHost.setCurrentTab(1);
        TextView textView = textViews.get("tab7");
        textView.setTextColor(getResources().
                getColor(R.color.white));
        //切换
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Set<String> keys=TabspecViews.keySet();//返回所有key
                for(String str:keys){
                    if(str.equals(tabId)){
                        if(str.equals("tab6")){
                            TextView textView1 = textViews.get("tab6");
                            textView1.setTextColor(getResources().
                                    getColor(R.color.white));
                            TextView textView2 = textViews.get("tab7");
                            textView2.setTextColor(getResources().
                                    getColor(R.color.top1));
                            TextView textView3 = textViews.get("tab8");
                            textView3.setTextColor(getResources().
                                    getColor(R.color.top1));
                        }else if(str.equals("tab7")){
                            TextView textView1 = textViews.get("tab6");
                            textView1.setTextColor(getResources().
                                    getColor(R.color.top1));
                            TextView textView2 = textViews.get("tab7");
                            textView2.setTextColor(getResources().
                                    getColor(R.color.white));
                            TextView textView3 = textViews.get("tab8");
                            textView3.setTextColor(getResources().
                                    getColor(R.color.top1));
                        }else if(str.equals("tab8")){
                            TextView textView1 = textViews.get("tab6");
                            textView1.setTextColor(getResources().
                                    getColor(R.color.top1));
                            TextView textView2 = textViews.get("tab7");
                            textView2.setTextColor(getResources().
                                    getColor(R.color.top1));
                            TextView textView3 = textViews.get("tab8");
                            textView3.setTextColor(getResources().
                                    getColor(R.color.white));
                        }
                    }
                }
            }
        });
        return view;
    }
    private View getTabSpecView(String name, String tag){
        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.tabspesc_layout2,null);

        TextView textView = view.findViewById(R.id.text);
        textView.setText(name);
        textView.setTextSize(15);
        textView.setTextColor(getResources().
                getColor(R.color.top1));
        textViews.put(tag,textView);
        TabspecViews.put(tag,view);
        return view;
    }
}
