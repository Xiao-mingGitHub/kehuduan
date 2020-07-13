package com.example.kehuduanweixin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gyf.immersionbar.ImmersionBar;

public class Main16 extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private TextView name,dengjijiguan,dengjiriqi,lihunhao,name2,chushengriqi,chushengriqi2,dengjiyuan,shengfenzheng,shengfenzheng2,xingbie,xingbie2,lihunzhenghao,chizhengren;
    private ImageView imageView,imageView2,main16_bak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main16);
        //沉浸式状态栏
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);

        name=(TextView)findViewById(R.id.main16_name);
        chushengriqi=(TextView)findViewById(R.id.main16_chushengriqi);
        shengfenzheng=(TextView)findViewById(R.id.main16_shenfenzheng);
        xingbie=(TextView)findViewById(R.id.main16_xingbie);

        imageView2=(ImageView)findViewById(R.id.main16_touxiang);
        main16_bak=(ImageView)findViewById(R.id.main16_bak);
        main16_bak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        name2=(TextView)findViewById(R.id.main16_name2);
        chushengriqi2=(TextView)findViewById(R.id.main16_chushengriqi2);
        shengfenzheng2=(TextView)findViewById(R.id.main16_shenfenzheng2);
        xingbie2=(TextView)findViewById(R.id.main16_xingbie2);


        dengjijiguan=(TextView)findViewById(R.id.main16_dengjichu);
        dengjiyuan=(TextView)findViewById(R.id.main16_dengjiyuan);
        lihunzhenghao=(TextView)findViewById(R.id.main16_lihunzhenghao);


        dengjiriqi=(TextView)findViewById(R.id.main16_dengjiriqi);
        lihunhao=(TextView)findViewById(R.id.main16_lihunzihao);
        chizhengren=(TextView)findViewById(R.id.main16chizhengren);

        name.setText(sharedPreferences.getString("name2",""));
        name2.setText(sharedPreferences.getString("name3",""));
        chushengriqi.setText(sharedPreferences.getString("chushengriqi",""));
        chushengriqi2.setText(sharedPreferences.getString("chushengriqi2",""));
        shengfenzheng.setText(sharedPreferences.getString("shenfenzheng",""));
        shengfenzheng2.setText(sharedPreferences.getString("shenfenzheng2",""));
        xingbie.setText(sharedPreferences.getString("xingbie",""));
        xingbie2.setText(sharedPreferences.getString("xingbie2",""));

        dengjijiguan.setText(sharedPreferences.getString("lihundengjijiguan",""));
        dengjiyuan.setText(sharedPreferences.getString("dengjiyuan2",""));
        lihunzhenghao.setText(sharedPreferences.getString("lihunzhenghao",""));
        chizhengren.setText(sharedPreferences.getString("name2",""));



        dengjiriqi.setText(sharedPreferences.getString("dengjiriqi",""));
        lihunhao.setText(sharedPreferences.getString("lihundengji",""));
        chizhengren.setText(sharedPreferences.getString("name2",""));

        imageView=(ImageView)findViewById(R.id.main16_zhang);
        String[] diqu={
                "禅城区","高明区","南海区","顺德区","三水区"
        };

        TypedArray typedArray = getResources().obtainTypedArray(R.array.diquicon);//引用资源图片文件，得到图片数组

        int yes=0;
        for (int i = 0; i < diqu.length; i++) {
            if(sharedPreferences.getString("lihundengjijiguan","").contains(diqu[i])){
                imageView.setImageResource(typedArray.getResourceId(i,0));
                yes=1;
            }
        }
        if(sharedPreferences.getString("lihundengjijiguan","").contains("广")){
            imageView.setImageResource(R.drawable.rew);
            yes=1;
        }

        String string=sharedPreferences.getString("zhaopian","");
        Glide.with(this).load(string).into(imageView2);

        if(yes==0){
            String string3=sharedPreferences.getString("zhang","");
            Glide.with(this).load(string3).into(imageView);
        }




    }
}
