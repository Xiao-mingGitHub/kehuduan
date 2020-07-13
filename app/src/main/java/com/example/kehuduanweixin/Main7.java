package com.example.kehuduanweixin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.immersionbar.ImmersionBar;

public class Main7 extends AppCompatActivity implements View.OnClickListener{
    private ImageView back,login,tongyi;
    private int zt=0;
    private TextView main7_shuoming;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main7);
        //沉浸式状态栏
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        back=(ImageView)findViewById(R.id.main7_bak);
        login=(ImageView)findViewById(R.id.main7_login);
        login.setOnClickListener(this);
        back.setOnClickListener(this);
        tongyi=(ImageView)findViewById(R.id.main7_tongyi);
        tongyi.setOnClickListener(this);

        sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        main7_shuoming=(TextView)findViewById(R.id.main7_shuoming);
        main7_shuoming.setText("人脸识别验证你的身份信息，请确保为"+sharedPreferences.getString("name2","")+"本人操作");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main7_login:
                if (zt==1){
                    Intent intent = new Intent(Main7.this, Main8.class);
                    startActivity(intent);
                    finish();
                }

                break;
            case R.id.main7_bak:
                finish();
                break;
            case R.id.main7_tongyi:
                if (zt==0){
                    tongyi.setImageResource(R.drawable.tp22);
                    login.setImageResource(R.drawable.tp23);
                    zt=1;
                }else if(zt==1){
                    tongyi.setImageResource(R.drawable.tp19);
                    login.setImageResource(R.drawable.tp20);
                    zt=0;
                }
                break;
        }

    }
}
