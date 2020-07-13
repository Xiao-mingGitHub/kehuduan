package com.example.kehuduanweixin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.gyf.immersionbar.ImmersionBar;

public class Main5 extends AppCompatActivity  implements View.OnClickListener{
    private ImageView back,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main5);
        //沉浸式状态栏
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        back=(ImageView)findViewById(R.id.main5_bak);
        login=(ImageView)findViewById(R.id.main5_longin);
        login.setOnClickListener(this);
        back.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main5_longin:
                Intent intent = new Intent(Main5.this, Main6.class);
                startActivity(intent);
                finish();
                break;
            case R.id.main5_bak:
                finish();
                break;
        }

    }
}
