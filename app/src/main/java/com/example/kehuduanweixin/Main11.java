package com.example.kehuduanweixin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.gyf.immersionbar.ImmersionBar;

public class Main11 extends AppCompatActivity implements View.OnClickListener {
    private ImageView weixin,faxian,wode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main11);
        //沉浸式状态栏
        ImmersionBar.with(this).statusBarDarkFont(true).init();


        weixin=(ImageView)findViewById(R.id.main11_weixin); //绑定
        weixin.setOnClickListener(this);
        faxian=(ImageView)findViewById(R.id.main11_faxian); //绑定
        faxian.setOnClickListener(this);
        wode=(ImageView)findViewById(R.id.main11_wode); //绑定
        wode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main11_weixin:
                Intent intent3 = new Intent(Main11.this, Main2.class);
                startActivity(intent3);
                ((Activity) Main11.this).overridePendingTransition(0, 0);
                finish();
                break;
            case R.id.main11_faxian:
                Intent intent4 = new Intent(Main11.this, Main12.class);
                startActivity(intent4);
                ((Activity) Main11.this).overridePendingTransition(0, 0);
                finish();
                break;
            case R.id.main11_wode:
                Intent intent5 = new Intent(Main11.this, Main13.class);
                startActivity(intent5);
                ((Activity) Main11.this).overridePendingTransition(0, 0);
                finish();
                break;
        }
    }
}
