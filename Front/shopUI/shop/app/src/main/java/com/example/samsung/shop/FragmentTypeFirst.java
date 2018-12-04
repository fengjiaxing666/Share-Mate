package com.example.samsung.shop;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;


public class FragmentTypeFirst extends Fragment {
    private View viewContent;
    private int mType = 0;
    private String mTitle;



    public void setType(int mType) {
        this.mType = mType;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //布局文件中只有一个居中的TextView
        viewContent = inflater.inflate(R.layout.shop,container,false);
        Button button =viewContent.findViewById(R.id.btn_more);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),ProductActivity.class);
                startActivity(intent);
            }
        });
        RelativeLayout relativeLayout=viewContent.findViewById(R.id.shop1);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),ProductActivity.class);
                startActivity(intent);
            }

        });
        return viewContent;
    }
}
