package com.example.kehuduanweixin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.immersionbar.ImmersionBar;

public class Main18 extends AppCompatActivity implements View.OnClickListener{

    private SharedPreferences sharedPreferences;
    private TextView name,dengjijiguan,dengjiriqi,lihunhao;
    private TextView xiangqing,zhengzhao;
    private ImageView main15_bak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main18);
        //沉浸式状态栏
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);


        name=(TextView)findViewById(R.id.main18_name);
        dengjijiguan=(TextView)findViewById(R.id.main18_dengjisuo);
        dengjiriqi=(TextView)findViewById(R.id.main18_riqi);
        lihunhao=(TextView)findViewById(R.id.main18_lihunhao);

        name.setText(sharedPreferences.getString("name2",""));
        String string2=sharedPreferences.getString("jiehundengji","");
        lihunhao.setText(string2.substring(0,1)+"****************"+string2.substring(string2.length()-1));

        dengjijiguan.setText(sharedPreferences.getString("dengjijiguan",""));

        String riqitext;
        riqitext=sharedPreferences.getString("jiehundengjiriqi","");
        riqitext=riqitext.replace("年","/");
        riqitext=riqitext.replace("月","/");
        riqitext=riqitext.replace("日","/");
        dengjiriqi.setText(riqitext);

        xiangqing=(TextView)findViewById(R.id.main18_xiangqing);
        zhengzhao=(TextView)findViewById(R.id.main18_chushi);
        xiangqing.setOnClickListener(this);
        zhengzhao.setOnClickListener(this);
        main15_bak=(ImageView)findViewById(R.id.main18_bak);
        main15_bak.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main18_xiangqing:
                Intent intent3 = new Intent(Main18.this, Main17.class);
                startActivity(intent3);
                ((Activity) Main18.this).overridePendingTransition(0, 0);
                break;
            case R.id.main18_chushi:
                Intent intent1 = new Intent(Main18.this, Main20.class);
                startActivity(intent1);
                ((Activity) Main18.this).overridePendingTransition(0, 0);
                break;
            case R.id.main18_bak:
                finish();
                break;
        }

    }
}
