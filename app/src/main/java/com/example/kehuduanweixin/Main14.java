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

public class Main14 extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences sharedPreferences;
    private ImageView main14_bak;
    private TextView lihun,jiehun,shenfenzheng;
    private RelativeLayout relativeLayout,relativeLayout2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main14);
        //沉浸式状态栏
        ImmersionBar.with(this).statusBarDarkFont(true).init();

        main14_bak=(ImageView)findViewById(R.id.main14_bak);
        main14_bak.setOnClickListener(this);
        lihun =(TextView)findViewById(R.id.main14_lihun);
        jiehun =(TextView)findViewById(R.id.main14_jiehun);
        shenfenzheng =(TextView)findViewById(R.id.main14_shenfenzheng);
        sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        relativeLayout=(RelativeLayout)findViewById(R.id.main14_lihunlay);
        relativeLayout.setOnClickListener(this);
        relativeLayout2=(RelativeLayout)findViewById(R.id.main14_lihunlay2);
        relativeLayout2.setOnClickListener(this);

        String string=sharedPreferences.getString("shenfenzheng","");
        shenfenzheng.setText(string.substring(0,1)+"****************"+string.substring(string.length()-1));
        String string2=sharedPreferences.getString("lihundengji","");
        lihun.setText(string2.substring(0,1)+"****************"+string2.substring(string2.length()-1));

        String string3=sharedPreferences.getString("jiehundengji","");
        jiehun.setText(string3.substring(0,1)+"****************"+string3.substring(string3.length()-1));



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main14_lihunlay:
                Intent intent3 = new Intent(Main14.this, Main15.class);
                startActivity(intent3);
                ((Activity) Main14.this).overridePendingTransition(0, 0);
                break;
            case R.id.main14_bak:
                finish();
                break;
            case R.id.main14_lihunlay2:
                Intent intent1 = new Intent(Main14.this, Main18.class);
                startActivity(intent1);
                ((Activity) Main14.this).overridePendingTransition(0, 0);
                break;

        }

    }
}
