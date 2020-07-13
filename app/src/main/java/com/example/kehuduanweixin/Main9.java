package com.example.kehuduanweixin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.TextureView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gyf.immersionbar.ImmersionBar;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class Main9 extends AppCompatActivity {
    private CameraHelper cameraHelper;
    private TextureView textureView; //镜头预览
    private ImageView image;
    private TextView textView,textView2;
    Handler mHandler =new Handler(); //延时
    private RelativeLayout relativeLayout,relativeLayout2;
    private GifImageView gifImageView,gifImageView2;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED, WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);//硬件加速
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//保持常亮
        //沉浸式状态栏
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        setContentView(R.layout.main9);
        editor=getSharedPreferences("user",MODE_PRIVATE).edit(); //用户配置文件 写入实例

        //绑定镜头预览
        textureView = findViewById(R.id.textureView);
        cameraHelper = new CameraHelper(this, textureView);
        initBrightness();

        sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);



        image=(ImageView)findViewById(R.id.main9_bak);



        relativeLayout=(RelativeLayout)findViewById(R.id.main9_relay);

        textView=(TextView)findViewById(R.id.main9_text);
        //延时操作
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textView.setText("屏幕即将闪烁，请保持姿势不变");
            }
        },3000);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {


                relativeLayout.setBackgroundColor(getColor(R.color.colorjindu1));
                image.setImageResource(R.drawable.tp28);

                //gif动态
                gifImageView=(GifImageView)findViewById(R.id.main9_gif);
                gifImageView.setVisibility(View.VISIBLE);
                GifDrawable gifDrawable=(GifDrawable)gifImageView.getDrawable();
                gifDrawable.setLoopCount(0);

            }
        },5000);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                relativeLayout.setBackgroundColor(getColor(R.color.colorjindu2));
                image.setImageResource(R.drawable.tp29);
            }
        },5500);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                relativeLayout.setBackgroundColor(getColor(R.color.colorjindu3));
                image.setImageResource(R.drawable.tp30);
            }
        },6000);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                relativeLayout.setBackgroundColor(getColor(R.color.colorjindu4));
                image.setImageResource(R.drawable.tp31);
            }
        },6500);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                relativeLayout.setBackgroundColor(getColor(R.color.colorjindu5));
                image.setImageResource(R.drawable.tp32);
            }
        },7000);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                relativeLayout2=(RelativeLayout)findViewById(R.id.main9_relay2);
                relativeLayout2.setVisibility(View.VISIBLE);
                //gif动态
                gifImageView2=(GifImageView)findViewById(R.id.main9_gif2);
                GifDrawable gifDrawable2=(GifDrawable)gifImageView.getDrawable();
                gifDrawable2.setLoopCount(1);
                relativeLayout.setBackgroundColor(getColor(R.color.colorjindu6));
                textView.setVisibility(View.GONE);
            }
        },7500);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textView2=(TextView)findViewById(R.id.main9_text2);
                textView2.setText("已完成人脸识别");

                if(sharedPreferences.getInt("chace",0)==1){
                    editor.putInt("login3",1);
                    editor.apply();//提交
                    Intent intent = new Intent(Main9.this, Main23.class);
                    startActivity(intent);
                    finish();
                }else {
                    Intent intent = new Intent(Main9.this, Main10.class);
                    startActivity(intent);
                    finish();
                }

            }
        },8500);


    }

    /**
     * 初始化屏幕亮度，不到200自动调整到200
     */
    private void initBrightness() {
        int brightness = BrightnessTools.getScreenBrightness(this);
        if (brightness < 200) {
            BrightnessTools.setBrightness(this, 200);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cameraHelper.releaseThread();
    }
}
