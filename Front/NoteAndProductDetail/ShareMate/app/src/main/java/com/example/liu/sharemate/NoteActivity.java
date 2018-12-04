package com.example.liu.sharemate;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class NoteActivity extends AppCompatActivity implements GradationScrollView.ScrollViewListener{
    private TextView allComment;
    private ImageView attentionImage;
    private ImageView zanImage;
    private ImageView collectionImage;
    private ImageView commentImage;
    private boolean isAttention=false;
    private boolean isZan=false;
    private boolean isCollection=false;
    private RelativeLayout title;
    private ImageView titleImage;
    private LinearLayout llComment;
    private LinearLayout bottom;
    private TextView send;
    private TextView countComment;
    private EditText etComment;
    private LinearLayout lleditComment;
    private int height;
    private TextView titleName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        getComment();
        clickAttention();
        clickZanAndCollection();
        clickComment();
        toAllComment();
        initListeners();
    }
    private void getComment(){
        //准备数据
        SimpleDateFormat sdf=new SimpleDateFormat("MM-dd hh:mm");
        Date date=new Date();
        List<Comment> comments=new ArrayList<>();
        Comment comment1=new Comment(1,1,R.drawable.b13,
                "新地图开发","水煮要吃谭记水煮，在渊明北路上（靠近中山路）推荐鸡脚腰子等荤菜，一定要老板多刷特制辣酱~然后拌粉推荐高师傅，和谭记在一个区域~然后苍蝇馆推荐两家：一家叫老三样，一家叫佳佳麻辣烧菜馆"
        ,sdf.format(date),3);
        Comment comment2=new Comment(2,1,R.drawable.a7, "不存在的","好感动终于有人推荐我们南昌的小吃了",sdf.format(date),3);
        Comment comment3=new Comment(3,1,R.drawable.b16, "nebule","南昌的凉粉也挺好吃的",sdf.format(date),2);
        comments.add(comment1);
        comments.add(comment2);
        comments.add(comment3);
        //创建Adapter对象
        CommentNodeAdapter commentNodeAdapter=new CommentNodeAdapter(comments,R.layout.item_comment_node,NoteActivity.this);
        //设置Adapter
        ListView listView=findViewById(R.id.lv_comment);
        showAllListView(commentNodeAdapter,listView);
        listView.setAdapter(commentNodeAdapter);
    }
    //关注
    private void clickAttention(){
        attentionImage=findViewById(R.id.iv_attention);
        attentionImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isAttention){
                    //点击取消关注
                    showDialog(0);
                    isAttention=false;
                }else{
                    //点击关注
                    attentionImage.setImageResource(R.drawable.a9);
                    isAttention=true;
                }

            }
        });
    }
    //点击赞、收藏
    private void clickZanAndCollection(){
        zanImage=findViewById(R.id.iv_zan);
        zanImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView zanCount=findViewById(R.id.tv_allcountZan);
                if (!isZan){
                    zanImage.setImageResource(R.drawable.a3);
                    TextView countZan=findViewById(R.id.tv_conntZan);
                    int count=Integer.parseInt(countZan.getText().toString());
                    count++;
                    countZan.setText(count+"");
                    zanCount.setText(count+"");
                    isZan=true;
                }else {
                    zanImage.setImageResource(R.drawable.a2);
                    TextView countZan=findViewById(R.id.tv_conntZan);
                    int count=Integer.parseInt(countZan.getText().toString());
                    count--;
                    countZan.setText(count+"");
                    zanCount.setText(count+"");
                    isZan=false;
                }


            }
        });
        collectionImage=findViewById(R.id.iv_collection);
        collectionImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView collectionCount=findViewById(R.id.tv_allcountCollection);
                if (!isCollection){
                    collectionImage.setImageResource(R.drawable.a6);
                    TextView countCollection=findViewById(R.id.tv_countCollection);
                    int count=Integer.parseInt(countCollection.getText().toString());
                    count++;
                    countCollection.setText(count+"");
                    collectionCount.setText(count+"");
                    isCollection=true;
                }else {
                    collectionImage.setImageResource(R.drawable.a5);
                    TextView countCollection=findViewById(R.id.tv_countCollection);
                    int count=Integer.parseInt(countCollection.getText().toString());
                    count--;
                    countCollection.setText(count+"");
                    collectionCount.setText(count+"");
                    isCollection=false;
                }
            }
        });
    }
    //点击评论
    private void clickComment(){
       etComment=findViewById(R.id.et_comment);
       send=findViewById(R.id.tv_send);
       countComment=findViewById(R.id.tv_countComment);
        llComment=findViewById(R.id.ll_comment);
        bottom=findViewById(R.id.ll_bottom);
        lleditComment=findViewById(R.id.ll_editcomment);
        llComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //自动出现软键盘
                InputMethodManager inputMethodManager=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                etComment.requestFocus();
                //隐藏底部,显示EditView
                bottom.setVisibility(View.INVISIBLE);
                lleditComment.setVisibility(View.VISIBLE);
            }
        });
        //点击发送
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发布评论,添加到数据库
                String commentContent=etComment.getText().toString();

                //隐藏软键盘
                InputMethodManager imm=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(),0);
                //显示底部,隐藏EditView
                bottom.setVisibility(View.VISIBLE);
                lleditComment.setVisibility(View.INVISIBLE);
                //Toast
                Toast toast=Toast.makeText(NoteActivity.this,"评论成功",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                //评论数加1
                int count=Integer.parseInt(countComment.getText().toString());
                count++;
                countComment.setText(count+"");
            }
        });
    }
    @Override
    protected Dialog onCreateDialog(int id) {
        new AlertDialog.Builder(this)
                .setMessage("确定不再关注这位用户了吗？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //取消关注该用户
                        attentionImage.setImageResource(R.drawable.a8);
                    }
                })
                .setNegativeButton("取消",null)
                .create()
                .show();
        return super.onCreateDialog(id);
    }

    //解决ScrollView嵌套ListView，item显示不全问题
    private void showAllListView(CommentNodeAdapter commentAdapter,ListView listView) {
        if (commentAdapter != null) {
            int totalHeight = 0;
            for (int i = 0; i <commentAdapter.getCount(); i++) {
                View listItem =commentAdapter.getView(i, null, listView);
                listItem.measure(0, 0);
                totalHeight += listItem.getMeasuredHeight();
            }
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = totalHeight+ (listView.getDividerHeight() * (commentAdapter.getCount() - 1));
            listView.setLayoutParams(params);
        }
    }
    //跳转到全部评论页面
    private void toAllComment(){
        allComment=findViewById(R.id.tv_allComment);
        allComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(NoteActivity.this,CommentActivity.class);
                startActivity(intent);
            }
        });
    }
    //获取顶部图片高度后，设置滚动监听
    private void initListeners(){
        final ImageView banner=findViewById(R.id.iv_banner);
        title=findViewById(R.id.tv_title);
        final GradationScrollView scrollView=findViewById(R.id.scrollView);
        ViewTreeObserver vto=banner.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                title.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                height=banner.getHeight();
                scrollView.setScrollViewListener(NoteActivity.this);
            }
        });
    }
    //滑动监听
    @Override
    public void onScrollChanged(GradationScrollView scrollView, int x, int y, int oldx, int oldy) {
        titleName=findViewById(R.id.tv_titleName);
        titleImage=findViewById(R.id.iv_titleImage);
        if (y <= 0) {   //设置标题的背景颜色
            title.setBackgroundColor(Color.argb((int) 0, 0,0,0));
        } else if (y > 0 && y <= height) { //滑动距离小于banner图的高度时，设置背景和字体颜色颜色透明度渐变
            float scale = (float) y / height;
            float alpha = (255 * scale);
            titleName.setTextColor(Color.argb((int) alpha, 255,255,255));
            titleName.setTextSize(18);
            title.setBackgroundColor(Color.argb((int) alpha, 222,65,56));
            titleImage.setAlpha(scale);//设置图片透明度数值from 0 to 1
        } else {    //滑动到banner下面设置普通颜色
            title.setBackgroundColor(Color.argb((int) 255, 222,65,56));
        }
    }
}
