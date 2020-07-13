package com.example.kehuduanweixin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class Main1__login extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE );//设置状态栏字体浅色主题
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorblack)); //设置状态栏黑色
        fragment(); //加载页面

    }

    private void fragment() {
        FragmentManager manager=getSupportFragmentManager(); //创建fragment的管理对象
        FragmentTransaction transaction=manager.beginTransaction();//获取fragment的事务对象，并且开启事务
        transaction.replace(R.id.login2,new Main1_fragment1()); //添加fragment
//        transaction.replace(R.id.login1,new Fragment_login())  //替换fragment
        transaction.commit();//提交事务 不然前面的不会执行
    }
}
