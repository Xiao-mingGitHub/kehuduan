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

public class Main15 extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences sharedPreferences;
    private TextView name,dengjijiguan,dengjiriqi,lihunhao;
    private TextView xiangqing,zhengzhao;
    private ImageView main15_bak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main15);
        //沉浸式状态栏
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);

        name=(TextView)findViewById(R.id.main15_name);
        dengjijiguan=(TextView)findViewById(R.id.main15_dengjisuo);
        dengjiriqi=(TextView)findViewById(R.id.main15_riqi);
        lihunhao=(TextView)findViewById(R.id.main15_lihunhao);

        name.setText(sharedPreferences.getString("name2",""));
        String string2=sharedPreferences.getString("lihundengji","");
        lihunhao.setText(string2.substring(0,1)+"****************"+string2.substring(string2.length()-1));
        dengjijiguan.setText(sharedPreferences.getString("lihundengjijiguan",""));

        String riqitext;
        riqitext=sharedPreferences.getString("dengjiriqi","");
        riqitext=riqitext.replace("年","/");
        riqitext=riqitext.replace("月","/");
        riqitext=riqitext.replace("日","/");
        dengjiriqi.setText(riqitext);
//        dengjiriqi.setText();
        xiangqing=(TextView)findViewById(R.id.main15_xiangqing);
        zhengzhao=(TextView)findViewById(R.id.main15_chushi);
        xiangqing.setOnClickListener(this);
        zhengzhao.setOnClickListener(this);
        main15_bak=(ImageView)findViewById(R.id.main15_bak);
        main15_bak.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main15_xiangqing:
                Intent intent3 = new Intent(Main15.this, Main16.class);
                startActivity(intent3);
                ((Activity) Main15.this).overridePendingTransition(0, 0);
                break;
            case R.id.main15_chushi:
                Intent intent1 = new Intent(Main15.this, Main19.class);
                startActivity(intent1);
                ((Activity) Main15.this).overridePendingTransition(0, 0);
                break;
            case R.id.main15_bak:
                finish();
                break;
        }

    }
}
