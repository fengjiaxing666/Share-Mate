package com.example.samsung.shop;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingFragment extends Fragment {
    private View viewContent;
    private TabLayout tab_essence;
    private ViewPager vp_essence;
    private LinearLayout constraintLayout;
    private List<Fragment> list;
    private PopupWindow popupWindow=null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewContent = inflater.inflate(R.layout.fragment_shopping,container,false);
        initConentView(viewContent);
        initData();
        constraintLayout=viewContent.findViewById(R.id.root1);
        ImageView imageView=viewContent.findViewById(R.id.more);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shopPopupWindow();
            }
        });

        list=new ArrayList<>();
        list.add(new FragmentTypeFirst());
        list.add(new FragmentTypeSecond());
        return viewContent;
    }




    private void shopPopupWindow(){
        popupWindow = new PopupWindow(getContext());
        //设置宽度
        popupWindow.setWidth(ConstraintLayout.LayoutParams.MATCH_PARENT);
        View view =getLayoutInflater().inflate(R.layout.left_tanchukuang,null);
        ImageView imageView=view.findViewById(R.id.delete);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        popupWindow.setContentView(view);
        popupWindow .setFocusable(true);
        popupWindow .setOutsideTouchable(true);
        popupWindow .setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                //在弹窗消失时调用
               // addBackgroundAlpha(1f);
            }
        });
        popupWindow.showAtLocation(constraintLayout, Gravity.NO_GRAVITY,0,0);
    }




    public void initConentView(View viewContent) {
        this.tab_essence = (TabLayout) viewContent.findViewById(R.id.tab_essence);
        this.vp_essence = (ViewPager) viewContent.findViewById(R.id.vp_essence);
    }

    public void initData() {
        //获取标签数据
        String[] titles = getResources().getStringArray(R.array.home_video_tab);

        //创建一个viewpager的adapter
        TestFragmentAdapter adapter = new TestFragmentAdapter(getFragmentManager(),list, Arrays.asList(titles));
        this.vp_essence.setAdapter(adapter);

        //将TabLayout和ViewPager关联起来

        this.tab_essence.setupWithViewPager(this.vp_essence);
    }

}
