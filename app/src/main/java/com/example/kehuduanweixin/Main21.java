package com.example.kehuduanweixin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.immersionbar.ImmersionBar;

public class Main21 extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView,imageView2,back;
    private SharedPreferences sharedPreferences;
    private int loginint,loginint2;
    private TextView queren,quxiao;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main21);
        //沉浸式状态栏
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        queren=(TextView)findViewById(R.id.main21_queren);
        queren.setOnClickListener(this);
        quxiao=(TextView)findViewById(R.id.main21_quexiao);
        quxiao.setOnClickListener(this);
        relativeLayout=(RelativeLayout)findViewById(R.id.main21_tishi);
        sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        loginint=sharedPreferences.getInt("login2",0);

        loginint2=sharedPreferences.getInt("login3",0);

        imageView2=(ImageView)findViewById(R.id.main21g);
        back=(ImageView)findViewById(R.id.main21_bak);
        back.setOnClickListener(this);
        if(sharedPreferences.getString("diqu","").contains("广") ||sharedPreferences.getString("dengjijiguan","").contains("广")){
            imageView2.setVisibility(View.VISIBLE);
        }else if(sharedPreferences.getString("diqu","").contains("佛")||sharedPreferences.getString("dengjijiguan","").contains("佛")){
            imageView2.setVisibility(View.GONE);
        }
        imageView=(ImageView)findViewById(R.id.main21);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main21:
                if (loginint==1){
                    if(loginint2==1){
                        Intent intent = new Intent(Main21.this, Main23.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Intent intent = new Intent(Main21.this, Main25.class);
                        startActivity(intent);
                        finish();
                    }

                }else{
                    relativeLayout.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.main21_quexiao:
                relativeLayout.setVisibility(View.GONE);
                break;
            case R.id.main21_queren:
                Intent intent2 = new Intent(Main21.this, Main5.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.main21_bak:
                finish();
                break;
        }

    }
}
