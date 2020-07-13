package com.example.kehuduanweixin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.gyf.immersionbar.ImmersionBar;

public class Main12 extends AppCompatActivity implements View.OnClickListener{
    private ImageView weixin,tongxunlu,wode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main12);
        //沉浸式状态栏
        ImmersionBar.with(this).statusBarDarkFont(true).init();

        weixin=(ImageView)findViewById(R.id.main12_weixin); //绑定
        weixin.setOnClickListener(this);
        tongxunlu=(ImageView)findViewById(R.id.main12_tongxunlu); //绑定
        tongxunlu.setOnClickListener(this);
        wode=(ImageView)findViewById(R.id.main12_wode); //绑定
        wode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main12_tongxunlu:
                Intent intent3 = new Intent(Main12.this, Main11.class);
                startActivity(intent3);
                ((Activity) Main12.this).overridePendingTransition(0, 0);
                finish();
                break;
            case R.id.main12_weixin:
                Intent intent4 = new Intent(Main12.this, Main2.class);
                startActivity(intent4);
                ((Activity) Main12.this).overridePendingTransition(0, 0);
                finish();
                break;
            case R.id.main12_wode:
                Intent intent5 = new Intent(Main12.this, Main13.class);
                startActivity(intent5);
                ((Activity) Main12.this).overridePendingTransition(0, 0);
                finish();
                break;
        }
    }
}
