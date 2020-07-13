package com.example.kehuduanweixin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.gyf.immersionbar.ImmersionBar;

public class Main17 extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private TextView name,dengjijiguan,dengjiriqi,lihunhao,name2,chushengriqi,chushengriqi2,dengjiyuan,shengfenzheng,shengfenzheng2,xingbie,xingbie2,lihunzhenghao,chizhengren;
    private ImageView imageView,main17_bak,imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main17);
        //沉浸式状态栏
        ImmersionBar.with(this).statusBarDarkFont(true).init();

        main17_bak=(ImageView)findViewById(R.id.main17_bak);
        main17_bak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        //沉浸式状态栏
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);

        name=(TextView)findViewById(R.id.main17_name);
        chushengriqi=(TextView)findViewById(R.id.main17_chushengriqi);
        shengfenzheng=(TextView)findViewById(R.id.main17_shenfenzheng);
        xingbie=(TextView)findViewById(R.id.main17_xingbie);
        imageView=(ImageView)findViewById(R.id.main17_touxiang);


        name2=(TextView)findViewById(R.id.main17_name2);
        chushengriqi2=(TextView)findViewById(R.id.main17_chushengriqi2);
        shengfenzheng2=(TextView)findViewById(R.id.main17_shenfenzheng2);
        xingbie2=(TextView)findViewById(R.id.main17_xingbie2);


        dengjijiguan=(TextView)findViewById(R.id.main17_dengjichu);
        dengjiyuan=(TextView)findViewById(R.id.main17_dengjiyuan);
        lihunzhenghao=(TextView)findViewById(R.id.main17_lihunzhenghao);


        dengjiriqi=(TextView)findViewById(R.id.main17_dengjiriqi);
        lihunhao=(TextView)findViewById(R.id.main17_lihunzihao);
        chizhengren=(TextView)findViewById(R.id.main17chizhengren);

        name.setText(sharedPreferences.getString("name2",""));
        name2.setText(sharedPreferences.getString("name3",""));
        chushengriqi.setText(sharedPreferences.getString("chushengriqi",""));
        chushengriqi2.setText(sharedPreferences.getString("chushengriqi2",""));
        shengfenzheng.setText(sharedPreferences.getString("shenfenzheng",""));
        shengfenzheng2.setText(sharedPreferences.getString("shenfenzheng2",""));
        xingbie.setText(sharedPreferences.getString("xingbie",""));
        xingbie2.setText(sharedPreferences.getString("xingbie2",""));

        dengjijiguan.setText(sharedPreferences.getString("dengjijiguan",""));
        dengjiyuan.setText(sharedPreferences.getString("dengjiyuan",""));
        lihunzhenghao.setText(sharedPreferences.getString("jiehunzhenghao",""));
        chizhengren.setText(sharedPreferences.getString("name2",""));
        dengjiriqi.setText(sharedPreferences.getString("jiehundengjiriqi",""));
        lihunhao.setText(sharedPreferences.getString("jiehundengji",""));

        imageView2=(ImageView)findViewById(R.id.main17_zhang);
        String[] diqu={
                "禅城区","高明区","南海区","顺德区","三水区"
        };

        TypedArray typedArray = getResources().obtainTypedArray(R.array.diquicon);//引用资源图片文件，得到图片数组

        int yes=0;
        for (int i = 0; i < diqu.length; i++) {
            if(sharedPreferences.getString("dengjijiguan","").contains(diqu[i])){
                imageView2.setImageResource(typedArray.getResourceId(i,0));
                yes=1;
            }

        }
        if(sharedPreferences.getString("dengjijiguan","").contains("广")){
            imageView2.setImageResource(R.drawable.rew);
            yes=1;
        }

        if(yes==0){
            String string3=sharedPreferences.getString("zhang","");
            Glide.with(this).load(string3).into(imageView2);
        }



        String string=sharedPreferences.getString("zhaopian","");
        Glide.with(this).load(string).into(imageView);

    }
}
