package net.onest.sharemate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SelectInterestActivity extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_interest);
        findViews();
        button.setOnClickListener(new ButtonClickListener());
    }
    private void findViews(){
        button = findViewById(R.id.btn_next);
    }
    private class ButtonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(SelectInterestActivity.this,SelectTopicActivity.class);
            startActivity(intent);
        }
    }
}
