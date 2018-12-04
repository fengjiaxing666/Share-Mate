package com.example.lenovo.sharemate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private int itemLaout;
    private List<note> notes =new ArrayList<>();
    public CustomAdapter(Context context, int itemLayout, List<note> notes){
        this.context=context;
        this.itemLaout = itemLayout;
        this.notes = notes;
    }
    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Object getItem(int position) {
        return notes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            LayoutInflater layoutInflater=LayoutInflater.from(context);
            convertView=layoutInflater.inflate(itemLaout,null);
        }
        //获取每个item中视图空间对象，设置显示的图片和文字
        ImageView ivPhoto=convertView.findViewById(R.id.iv_photo);
        ivPhoto.setImageResource(notes.get(position).getPhoto());
        TextView text2=convertView.findViewById(R.id.note_alltext);
        text2.setText(notes.get(position).getAlltext());
        TextView text=convertView.findViewById(R.id.title);
        text.setText(notes.get(position).getTitle());
        TextView text3=convertView.findViewById(R.id.time);
        text3.setText(notes.get(position).getTime());
        TextView username=convertView.findViewById(R.id.user_name);
        username.setText(notes.get(position).getUsername());
        ImageView icon=convertView.findViewById(R.id.user_icon);
        icon.setImageResource(notes.get(position).getUsericon());
        TextView count=convertView.findViewById(R.id.z_count);
        count.setText(notes.get(position).getZanCount());
        TextView count2=convertView.findViewById(R.id.c_count);
        count2.setText(notes.get(position).getCollectcount());
        TextView count3=convertView.findViewById(R.id.s_count);
        count3.setText(notes.get(position).getSharecount());
        TextView count4=convertView.findViewById(R.id.p_count);
        count4.setText(notes.get(position).getPingluncount());
        return convertView;
    }
}
