package com.example.lenovo.sharemate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GridViewAdapter extends BaseAdapter {

    //ALt+enter出方法
    private Context context;
    private int itemLayout;
    private List<note> notes =new ArrayList<>();
    public GridViewAdapter(Context context, int itemLayout, List<note> notes){
        this.context=context;
        this.itemLayout=itemLayout;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        // 加载item布局
        if (convertView==null){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(itemLayout,null);//传空的意思是不用他去加载父视图
        }

        //获取每个item中视图空间对象，设置显示的图片和文字
        ImageView ivPhoto=convertView.findViewById(R.id.iv_photo);
        ivPhoto.setImageResource(notes.get(position).getPhoto());
        TextView text=convertView.findViewById(R.id.note_text);
        text.setText(notes.get(position).getText());
        TextView username=convertView.findViewById(R.id.user_name);
        username.setText(notes.get(position).getUsername());
        ImageView icon=convertView.findViewById(R.id.user_icon);
        icon.setImageResource(notes.get(position).getUsericon());
        TextView count=convertView.findViewById(R.id.zan_count);
        count.setText(notes.get(position).getZanCount());
        final Button button = convertView.findViewById(R.id.dianzan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setBackgroundResource(R.drawable.xinxin2);
            }
        });
        return convertView;
    }
}
