package com.example.kehuduanweixin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.gyf.immersionbar.ImmersionBar;

public class Main13 extends AppCompatActivity implements View.OnClickListener{
    private ImageView weixin,tongxunlu,faxian,main13_img;
    private TextView textView;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main13);
        //沉浸式状态栏
        ImmersionBar.with(this).statusBarDarkFont(true).init();

        editor=getSharedPreferences("user",MODE_PRIVATE).edit(); //用户配置文件 写入实例


        weixin=(ImageView)findViewById(R.id.main13_weixin); //绑定
        weixin.setOnClickListener(this);
        tongxunlu=(ImageView)findViewById(R.id.main13_tongxunlu); //绑定
        tongxunlu.setOnClickListener(this);
        faxian=(ImageView)findViewById(R.id.main13_faxian); //绑定
        faxian.setOnClickListener(this);
        sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);

        textView=(TextView)findViewById(R.id.main13_name);
        textView.setText(sharedPreferences.getString("name","小陈"));

        main13_img=(ImageView)findViewById(R.id.main13_img); //绑定
        main13_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("login",0);
                editor.apply();
                Intent intent23 = new Intent(Main13.this, Main1__login.class);
                startActivity(intent23);
                ((Activity) Main13.this).overridePendingTransition(0, 0);
                finish();

            }
        });


        String string=sharedPreferences.getString("touxiang15","");
        RequestOptions options = new RequestOptions().error(R.drawable.liaot1).bitmapTransform(new RoundedCorners(15));//图片圆角为30
        Glide.with(this).load(string).apply(options).into(main13_img);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main13_tongxunlu:
                Intent intent3 = new Intent(Main13.this, Main11.class);
                startActivity(intent3);
                ((Activity) Main13.this).overridePendingTransition(0, 0);
                finish();
                break;
            case R.id.main13_weixin:
                Intent intent4 = new Intent(Main13.this, Main2.class);
                startActivity(intent4);
                ((Activity) Main13.this).overridePendingTransition(0, 0);
                finish();
                break;
            case R.id.main13_faxian:
                Intent intent5 = new Intent(Main13.this, Main12.class);
                startActivity(intent5);
                ((Activity) Main13.this).overridePendingTransition(0, 0);
                finish();
                break;
        }
    }
}
