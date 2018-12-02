package com.example.samsung.shop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class FragmentTypeSecond extends Fragment {
    private List<Shop> shops=new ArrayList<>();
    private GridView gridView;
    private ShopdetialAdapter shopdetialAdapter;
    private int mType = 0;
    private String mTitle;
    public void setType(int mType) {
        this.mType = mType;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_second,
                container,
                false);
        shops=new ArrayList<>();
        Shop shop1=new Shop(R.drawable.shop1,"上海 想你的铃儿响叮当","STYLEJING静风格 森系思念小铃铛S925银项链","￥179","十元劵");
        Shop shop2=new Shop(R.drawable.shop2,"上海 趣味灵动星光","STYLEJING静风格 公主星S925银针不对称彩色","￥66","10元劵");
        Shop shop3=new Shop(R.drawable.shop3,"英国 打造百变日抛眼妆","W7九色眼影盘","￥65","99选2");
        Shop shop4=new Shop(R.drawable.shop4,"上海 对你一见钟情","STYLEJING静风格 一见钟情 S925银针不对称","￥86","10元劵");
        Shop shop5=new Shop(R.drawable.shop5,"日本 超平价全身美白","DAISO大创 美白化妆水120ml","￥29","自营");
        Shop shop6=new Shop(R.drawable.shop6,"上海 兜兜转转还是你","STYLEJING静风格 爱情螺旋定律S925银锁骨链","￥196","立减10元");
        shops.add(shop1);
        shops.add(shop2);
        shops.add(shop3);
        shops.add(shop4);
        shops.add(shop5);
        shops.add(shop6);
        gridView=view.findViewById(R.id.root2);

        shopdetialAdapter=new ShopdetialAdapter(getContext(),
                R.layout.list_item,
                shops);
        gridView.setAdapter(shopdetialAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        return view;

    }
}
