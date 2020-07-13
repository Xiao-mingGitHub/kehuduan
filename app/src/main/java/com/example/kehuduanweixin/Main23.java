package com.example.kehuduanweixin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.immersionbar.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

public class Main23 extends AppCompatActivity implements View.OnClickListener {
    private Button button,button2;
    private TextView textView,textView2;
    private RelativeLayout relativeLayout;
    private PickerView pickerView;
    Handler mHandler =new Handler(); //延时
    private ImageView imageView;

    private SharedPreferences sharedPreferences;
    private List<String> data2;
    private List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main23);

        //沉浸式状态栏
        ImmersionBar.with(this).statusBarDarkFont(true).init();

        button=(Button)findViewById(R.id.main23_login_btn);//取消
        button2=(Button)findViewById(R.id.main23_login_btn2);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        textView=(TextView)findViewById(R.id.main23_xuanzhe);
        textView2=(TextView)findViewById(R.id.main23_xuanzhe2);
        textView.setOnClickListener(this);

        relativeLayout=(RelativeLayout)findViewById(R.id.main23_lay);
        pickerView=(PickerView)findViewById(R.id.pv);

        imageView=(ImageView)findViewById(R.id.main23_bak);

        data = new ArrayList<>();
        data.add(" ");
        data.add("荔湾区");
        data.add("越秀区");
        data.add("海珠区");
        data.add("天河区");
        data.add("白云区");
        data.add("黄埔区");
        data.add("番禺区");
        data.add("花都区");
        data.add("南沙区");
        data.add("从化区");
        data.add("增城区");
        data.add(" ");


        data2 = new ArrayList<>();
        data2.add(" ");
        data2.add("禅城区");
        data2.add("南海区");
        data2.add("顺德区");
        data2.add("三水区");
        data2.add("高明区");
        data2.add(" ");

//        pickerView.setData(data);

        sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);

        if(sharedPreferences.getString("diqu","").contains("广")){
            pickerView.setData(data);
            Log.d("gggg","广州");
        }else if(sharedPreferences.getString("diqu","").contains("佛")){
            pickerView.setData(data2);
            Log.d("gggg","佛山");
        }



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main23_login_btn:
                relativeLayout.setVisibility(View.GONE);

                break;
            case R.id.main23_xuanzhe:
                relativeLayout.setVisibility(View.VISIBLE);

                break;
            case R.id.main23_login_btn2:

                relativeLayout.setVisibility(View.GONE);
//                textView2.setText(pickerView.getPosition());
                Intent intent2 = new Intent(Main23.this, Main22.class);
                startActivity(intent2);
                finish();
//                mHandler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        Intent intent2 = new Intent(Main23.this, Main22.class);
//                        startActivity(intent2);
//                        finish();
//                    }
//                },500);
                break;
            case R.id.main23_bak:
                Intent intent3 = new Intent(Main23.this, Main21.class);
                startActivity(intent3);
                finish();
                break;
        }


    }
}
