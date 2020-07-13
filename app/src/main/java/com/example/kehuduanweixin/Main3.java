package com.example.kehuduanweixin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.example.kehuduanweixin.views.ManyPictureAdapter;
import com.gyf.immersionbar.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

public class Main3 extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private SliderLayout sliderLayout;
    private TextView xiaod_1,xiaod_2,xiaod_3,xiaod_4,xiaod_5;
    private ImageView imageView,touxiang,chace;
    private TextView main3_login,main3_name,chengshi,main3_quanbu;
    private SharedPreferences sharedPreferences;
    private int loginint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main3);
        //沉浸式状态栏
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        viewpager();//滑动图+小圆点
        initSlider_3();//设置轮播图

        imageView=(ImageView)findViewById(R.id.main3_back);
        imageView.setOnClickListener(this);
        main3_login=(TextView)findViewById(R.id.main3_login);
        main3_name=(TextView)findViewById(R.id.main3_name);

        main3_quanbu=(TextView)findViewById(R.id.main3_quanbu);
        main3_quanbu.setOnClickListener(this);
        chengshi=(TextView)findViewById(R.id.chengshi);

        main3_login.setOnClickListener(this);
        sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);

        chace=(ImageView)findViewById(R.id.main3_chace);
        chace.setOnClickListener(this);


        loginint=sharedPreferences.getInt("login2",0);
        touxiang=(ImageView)findViewById(R.id.main3_touxiang);
        String string=sharedPreferences.getString("touxiang15","");
        Glide.with(this).load(string).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(touxiang);

        String diqu=sharedPreferences.getString("diqu","");
        String dengjijiguan=sharedPreferences.getString("dengjijiguan","");
        if(diqu.contains("广") ||dengjijiguan.contains("广")){
            chengshi.setText("广州市");
        }else if(diqu.contains("佛")||dengjijiguan.contains("佛")){
            chengshi.setText("佛山市");
        }else{
            if(diqu.length()<2){
                chengshi.setText(dengjijiguan.substring(0,3));
            }else if(dengjijiguan.length()<2){
                chengshi.setText(diqu.substring(0,3));
            }else {
                chengshi.setText(dengjijiguan.substring(0,3));
            }

        }



        //判断是否登录
        if(loginint==1){
            main3_name.setText(sharedPreferences.getString("name2",""));
            main3_login.setText("个人中心");
            main3_login.setTextColor(getColor(R.color.colorx102));
        }else {
            main3_name.setText(sharedPreferences.getString("name",""));
            main3_login.setText("请登录");
            main3_login.setTextColor(getColor(R.color.colorblue2));
        }




    }

    private void viewpager() {
        xiaod_1=(TextView)findViewById(R.id.xiaod_1);
        xiaod_2=(TextView)findViewById(R.id.xiaod_2);
        xiaod_3=(TextView)findViewById(R.id.xiaod_3);
        xiaod_4=(TextView)findViewById(R.id.xiaod_4);

        viewPager=(ViewPager)findViewById(R.id.main3_viewPager);
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.yibao);
        list.add(R.drawable.yibao2);
        list.add(R.drawable.yibao3);
        list.add(R.drawable.yibao4);
        ManyPictureAdapter adapter=new ManyPictureAdapter(this,list);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                switch (position){
                    case 0:
                        xiaod_1.setBackgroundResource(R.drawable.circle_a);
                        xiaod_2.setBackgroundResource(R.drawable.circle_b);
                        xiaod_3.setBackgroundResource(R.drawable.circle_b);
                        xiaod_4.setBackgroundResource(R.drawable.circle_b);
                        break;
                    case 1:
                        xiaod_1.setBackgroundResource(R.drawable.circle_b);
                        xiaod_2.setBackgroundResource(R.drawable.circle_a);
                        xiaod_3.setBackgroundResource(R.drawable.circle_b);
                        xiaod_4.setBackgroundResource(R.drawable.circle_b);
                        break;
                    case 2:
                        xiaod_1.setBackgroundResource(R.drawable.circle_b);
                        xiaod_2.setBackgroundResource(R.drawable.circle_b);
                        xiaod_3.setBackgroundResource(R.drawable.circle_a);
                        xiaod_4.setBackgroundResource(R.drawable.circle_b);
                        break;
                    case 3:
                        xiaod_1.setBackgroundResource(R.drawable.circle_b);
                        xiaod_2.setBackgroundResource(R.drawable.circle_b);
                        xiaod_3.setBackgroundResource(R.drawable.circle_b);
                        xiaod_4.setBackgroundResource(R.drawable.circle_a);
                        break;
                }
            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });
    }

    private void initSlider_3() {
        String [] url=new String[]{
                "https://2020-ad-file.oss-cn-beijing.aliyuncs.com/data/weixin/weixin01.png",
                "https://2020-ad-file.oss-cn-beijing.aliyuncs.com/data/weixin/weixin02.png",
                "https://2020-ad-file.oss-cn-beijing.aliyuncs.com/data/weixin/weixin03.png",
        };
//        sliderLayout_3=(SliderLayout)
        sliderLayout=(SliderLayout)findViewById(R.id.slider_3);
        for (int i = 0; i < url.length; i++) {
            DefaultSliderView defaultSliderView=new DefaultSliderView(this);
            defaultSliderView.image(url[i]);
            sliderLayout.addSlider(defaultSliderView);
        }
        sliderLayout.setCustomIndicator((PagerIndicator)findViewById(R.id.custom_indicator_3));
        sliderLayout.setDuration(2000);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main3_login:
                if (loginint==0){
                    Intent intent = new Intent(Main3.this, Main4.class);
                    startActivity(intent);
                    finish();
                }
                break;
            case R.id.main3_back:
                finish();
                break;

            case R.id.main3_quanbu:
                if (loginint==1){
                    Intent intent = new Intent(Main3.this, Main14.class);
                    startActivity(intent);
                }
                break;
            case R.id.main3_chace:
                Log.d("TTDD","点击了图片");
                Intent intent = new Intent(Main3.this, Main21.class);
                startActivity(intent);
                finish();
                break;
        }

    }
}
