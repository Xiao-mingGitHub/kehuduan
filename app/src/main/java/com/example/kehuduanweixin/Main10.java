package com.example.kehuduanweixin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.gyf.immersionbar.ImmersionBar;

public class Main10 extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private TextView main10_name,main10_text;
    private SharedPreferences.Editor editor;
    private ImageView main10_touxiang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main10);
        //沉浸式状态栏
        ImmersionBar.with(this).statusBarDarkFont(true).init();

        editor=getSharedPreferences("user",MODE_PRIVATE).edit(); //用户配置文件 写入实例
        editor.putInt("login2",1);

        editor.apply();//提交

        main10_touxiang=(ImageView)findViewById(R.id.main10_touxiang);
        sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        
        String string=sharedPreferences.getString("touxiang15","");
        Glide.with(this).load(string).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(main10_touxiang);

        main10_name=(TextView)findViewById(R.id.main10_name);
        main10_name.setText( sharedPreferences.getString("name2",""));
        main10_text=(TextView)findViewById(R.id.main10_text);
        main10_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main10.this, Main3.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
