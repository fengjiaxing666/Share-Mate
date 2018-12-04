package com.example.samsung.shop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;

public class FabuActivity extends AppCompatActivity {
   ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabu);
        imageView=findViewById(R.id.topic);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shopPopMenu();
            }
        });
    }
    void  shopPopMenu(){
        PopupMenu popupMenu=new PopupMenu(this,imageView);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.item1:
                        break;
                    case R.id.item2:
                        break;
                    case R.id.item3:
                        break;
                    case R.id.item4:
                        break;
                    case R.id.item5:
                        break;
                    case R.id.item6:
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }
}
