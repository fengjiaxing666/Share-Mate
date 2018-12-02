package com.example.samsung.shop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ShopdetialAdapter extends BaseAdapter{
    private Context content;
    private int itemLayout;
    private List<Shop> shops = new ArrayList<>();


    public ShopdetialAdapter() {
    }

    public ShopdetialAdapter(Context content, int itemLayout, List<Shop> shops) {
        this.content = content;
        this.itemLayout = itemLayout;
        this.shops = shops;
    }

    @Override
    public int getCount() {
        return shops.size();
    }

    @Override
    public Object getItem(int position) {
        return shops.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        
        if(null==convertView){
            LayoutInflater layoutInflater=LayoutInflater.from(content);
            convertView=layoutInflater.inflate(itemLayout,null);
        }
        ImageView ivphoto=convertView.findViewById(R.id.item_image);
        ivphoto.setImageResource(shops.get(position).getPhoto());
        TextView ivname=convertView.findViewById(R.id.item_name);
        ivname.setText(shops.get(position).getName());
        TextView ivissure=convertView.findViewById(R.id.item_issure);
        ivissure.setText(shops.get(position).getIssure());
        TextView ivprice=convertView.findViewById(R.id.item_price);
        ivprice.setText(shops.get(position).getPrice());
        TextView ivyouhui=convertView.findViewById(R.id.item_youhui);
        ivyouhui.setText(shops.get(position).getYouhui());

        return convertView;
    }
}

