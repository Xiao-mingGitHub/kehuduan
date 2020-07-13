package com.example.kehuduanweixin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gyf.immersionbar.ImmersionBar;

public class Main25 extends AppCompatActivity implements View.OnClickListener {
    private TextView queren,quxiao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main25);
        //沉浸式状态栏
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        queren=(TextView)findViewById(R.id.main25_queren);
        queren.setOnClickListener(this);
        quxiao=(TextView)findViewById(R.id.main25_quexiao);
        quxiao.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main25_quexiao:
                Intent intent = new Intent(Main25.this, Main3.class);
                startActivity(intent);
                finish();
                break;
            case R.id.main25_queren:
                Intent intent2 = new Intent(Main25.this, Main24.class);
                startActivity(intent2);
                finish();
                break;
        }
    }
}
