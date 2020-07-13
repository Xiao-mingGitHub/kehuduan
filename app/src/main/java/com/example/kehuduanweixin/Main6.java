package com.example.kehuduanweixin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.immersionbar.ImmersionBar;

public class Main6 extends AppCompatActivity   implements View.OnClickListener{

    private ImageView back,login,xuanzhe;
    private TextView main6_number,main6_name;
    private int zt=0;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main6);
        //沉浸式状态栏
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        editor=getSharedPreferences("user",MODE_PRIVATE).edit(); //用户配置文件 写入实例
        back=(ImageView)findViewById(R.id.main6_bak);
        login=(ImageView)findViewById(R.id.main6_login);
        login.setOnClickListener(this);
        back.setOnClickListener(this);
        xuanzhe=(ImageView)findViewById(R.id.main6_xuanzhe);
        xuanzhe.setOnClickListener(this);
        sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        main6_number=(TextView)findViewById(R.id.main6_number);
        main6_name=(TextView)findViewById(R.id.main6_name);

        String name=sharedPreferences.getString("name2","");
        String munber=sharedPreferences.getString("shenfenzheng","");
        main6_name.setText(name.substring(0,1)+"**");
        main6_number.setText(munber.substring(0,1)+"****************"+munber.substring(munber.length()-1));



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main6_login:
                editor.putInt("chace",0);
                editor.apply();//提交
                Intent intent = new Intent(Main6.this, Main7.class);
                startActivity(intent);
                finish();
                break;
            case R.id.main6_bak:
                finish();
                break;
            case R.id.main6_xuanzhe:
                if (zt==0){
                    xuanzhe.setImageResource(R.drawable.tp16);
                    zt=1;
                }else if(zt==1){
                    xuanzhe.setImageResource(R.drawable.tp15);
                    zt=0;
                }
                break;
        }

    }
}
