package com.example.kehuduanweixin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.immersionbar.ImmersionBar;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class Main8 extends CheckPermissionsActivity implements View.OnClickListener{

    private GifImageView gifImageView;
    private ImageView login;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main8);
        //沉浸式状态栏
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        gifImageView=(GifImageView)findViewById(R.id.main8_gif);
        GifDrawable gifDrawable=(GifDrawable)gifImageView.getDrawable();
        gifDrawable.setLoopCount(0);

        login=(ImageView)findViewById(R.id.main8_login);
        login.setOnClickListener(this);
        textView=(TextView)findViewById(R.id.main8_quxiao);
        textView.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main8_login:
                Intent intent = new Intent(Main8.this, Main9.class);
                startActivity(intent);
                finish();
                break;
            case R.id.main8_quxiao:
                finish();
                break;
        }

    }

}
