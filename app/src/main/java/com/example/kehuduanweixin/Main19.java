package com.example.kehuduanweixin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.gyf.immersionbar.ImmersionBar;

public class Main19 extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main19);
        //沉浸式状态栏
//        ImmersionBar.with(this).statusBarDarkFont(true).init();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE );//设置状态栏字体浅色主题
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorfen)); //设置状态栏黑色
        imageView=(ImageView)findViewById(R.id.main19_bak);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
