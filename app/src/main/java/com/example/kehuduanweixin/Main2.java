package com.example.kehuduanweixin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.kehuduanweixin.views.Main2_listview;
import com.example.kehuduanweixin.views.Main2_listview_adapter;
import com.example.kehuduanweixin.views.PullScrollView;
import com.gyf.immersionbar.ImmersionBar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main2 extends AppCompatActivity implements View.OnClickListener{
    private PullScrollView pullScrollView;
    private FrameLayout frameLayout;
    private ImageView yueshengshi,yueshengshi2;
    private LinearLayout danhanglan,linearLayout;
    private TextView weixin;
    private RelativeLayout relativeLayout;
    private DotView dotView;
    private ViewGroup.LayoutParams params;
    private ListView listView;
    private List<Main2_listview> mData=null; //初始化列对象
    private Main2_listview_adapter mAdapter;
    private ImageView tongxun,faxian,wode;
    private SharedPreferences sharedPreferences;
    private ImageView touxiang1,touxiang2,touxiang3,touxiang4,touxiang5,touxiang6
            ,touxiang7,touxiang8,touxiang9,touxiang10,touxiang11,touxiang12,touxiang13
            ,touxiang14,touxiang15,touxiang16,touxiang17,touxiang18,touxiang19,touxiang20
            ,touxiang21;
    private TextView name1,name2,name3,name4,name5,name6,name7,name8,name9,name10,name11,name12
            ,name13,name14,name15,name16,name17,name18,name19,name20,name21;
    private TextView masg1,masg2,masg3,masg4,masg5,masg6,masg7,masg8,masg9,masg10,masg11,masg12
            ,masg13,masg14,masg15,masg16,masg17,masg18,masg19,masg20,masg21;
    private TextView time1,time2,time3,time4;

    private TextView[] name_textViews,masg_textView;

    private ImageView[] touxiang_imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        //沉浸式状态栏
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        //自定义ScrollView,实现上下二楼
        pullScrollView=(PullScrollView)findViewById(R.id.pull);
        frameLayout=findViewById(R.id.two_view);
        //添加第二页view
        pullScrollView.setTwoView(frameLayout);
        sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        init();//初始化



        //滑动监听
        pullScrollView.setScrollTwoViewListener(new PullScrollView.ScrollTwoViewListener() {
            @Override
            public void showTwoView(boolean isShow) {

                float bili=pullScrollView.getbili(); //获取当前位置
                float gaodu=pullScrollView.getheight();//获取总高度
                float bili2=(gaodu-bili)/(gaodu*0.2f);
                if(bili2 <1){
                    dotView.setPercent(bili2);
                    int a=Math.round(500*bili2);
                    params.height=a;
                    relativeLayout.setLayoutParams(params);
//                    danhanglan.setAlpha(1-bili2);
                    Log.d("ttyhy", bili2+"");

                    if(pullScrollView.getyes()==1){
                        relativeLayout.setVisibility(View.GONE);
                    }


                }
                if(bili2 >1){
//                    danhanglan.setAlpha(0);
                    if(pullScrollView.getyes()==1){
                        relativeLayout.setVisibility(View.GONE);
                    }



                }

            }

            @Override
            public void openTwoView() {
                //打开就关闭导航栏
                danhanglan.setVisibility(View.GONE);
                linearLayout.setVisibility(View.VISIBLE);
                relativeLayout.setVisibility(View.GONE);
            }

            @Override
            public void closeTwoView() {
                danhanglan.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.GONE);
                relativeLayout.setVisibility(View.VISIBLE);
            }
        });



    }
//    private void setListview(){
//        mData=new LinkedList<Main2_listview>(); //列表数据容器
//        String name[]=getResources().getStringArray(R.array.main2_name);//引用资源文件,logo名字
//        TypedArray typedArray = getResources().obtainTypedArray(R.array.main2_icon);//引用资源图片文件，得到图片数组
//        for (int i = 0; i <name.length ; i++) {
//            mData.add(new Main2_listview(name[i],typedArray.getResourceId(i,0),name[i])); //数据放入容器
//            mAdapter=new Main2_listview_adapter((LinkedList<Main2_listview>)mData,this);  //加载数据
//
//        }
//        listView.setAdapter(mAdapter);
//
//
//    }


    private void init() {


        yueshengshi=(ImageView)findViewById(R.id.yueshengshi); //绑定粤省事图标
        yueshengshi2=(ImageView)findViewById(R.id.yueshengshi2); //绑定粤省事图标
        yueshengshi.setOnClickListener(this);
        yueshengshi2.setOnClickListener(this);
        danhanglan=(LinearLayout)findViewById(R.id.daohanglan); //绑定导航栏
        weixin=(TextView)findViewById(R.id.weixin);
        weixin.setOnClickListener(this);
        relativeLayout=(RelativeLayout)findViewById(R.id.main2_relay);//绑定圆点图层
        params = relativeLayout.getLayoutParams();
        dotView=(DotView)findViewById(R.id.dotview);//绑定小圆点

        linearLayout=(LinearLayout)findViewById(R.id.main2_linlay);//绑定微信头部
//        listView=(ListView)findViewById(R.id.main2_listview);

        tongxun=(ImageView)findViewById(R.id.main2_tongxunlu); //绑定导航栏
        tongxun.setOnClickListener(this);
        faxian=(ImageView)findViewById(R.id.main2_faxian); //绑定导航栏
        faxian.setOnClickListener(this);
        wode=(ImageView)findViewById(R.id.main2_wode); //绑定导航栏
        wode.setOnClickListener(this);


        touxiang1=(ImageView)findViewById(R.id.ic_avatar1);
        touxiang2=(ImageView)findViewById(R.id.ic_avatar2);
        touxiang3=(ImageView)findViewById(R.id.ic_avatar3);
        touxiang4=(ImageView)findViewById(R.id.ic_avatar4);
        touxiang5=(ImageView)findViewById(R.id.ic_avatar5);
        touxiang6=(ImageView)findViewById(R.id.ic_avatar6);
        touxiang7=(ImageView)findViewById(R.id.ic_avatar7);
        touxiang8=(ImageView)findViewById(R.id.ic_avatar8);
        touxiang9=(ImageView)findViewById(R.id.ic_avatar9);
        touxiang10=(ImageView)findViewById(R.id.ic_avatar10);
        touxiang11=(ImageView)findViewById(R.id.ic_avatar11);
        touxiang12=(ImageView)findViewById(R.id.ic_avatar12);
        touxiang13=(ImageView)findViewById(R.id.ic_avatar13);
        touxiang14=(ImageView)findViewById(R.id.ic_avatar14);

        name1=(TextView)findViewById(R.id.name1);
        name2=(TextView)findViewById(R.id.name2);
        name3=(TextView)findViewById(R.id.name3);
        name4=(TextView)findViewById(R.id.name4);
        name5=(TextView)findViewById(R.id.name5);
        name6=(TextView)findViewById(R.id.name6);
        name7=(TextView)findViewById(R.id.name7);
        name8=(TextView)findViewById(R.id.name8);
        name9=(TextView)findViewById(R.id.name9);
        name10=(TextView)findViewById(R.id.name10);
        name11=(TextView)findViewById(R.id.name11);
        name12=(TextView)findViewById(R.id.name12);
        name13=(TextView)findViewById(R.id.name13);
        name14=(TextView)findViewById(R.id.name14);


        time1=(TextView)findViewById(R.id.time1);
        time2=(TextView)findViewById(R.id.time2);
        time3=(TextView)findViewById(R.id.time3);
        time4=(TextView)findViewById(R.id.time4);

        masg1=(TextView)findViewById(R.id.messg1);
        masg2=(TextView)findViewById(R.id.messg2);
        masg3=(TextView)findViewById(R.id.messg3);
        masg4=(TextView)findViewById(R.id.messg4);
        masg5=(TextView)findViewById(R.id.messg5);
        masg6=(TextView)findViewById(R.id.messg6);
        masg7=(TextView)findViewById(R.id.messg7);
        masg8=(TextView)findViewById(R.id.messg8);
        masg9=(TextView)findViewById(R.id.messg9);
        masg10 =(TextView)findViewById(R.id.messg10);
        masg11 =(TextView)findViewById(R.id.messg11);
        masg12=(TextView)findViewById(R.id.messg12);
        masg13=(TextView)findViewById(R.id.messg13);
        masg14=(TextView)findViewById(R.id.messg14);

        name_textViews=new TextView[]{
                name1,name2,name3,name4,name5,name6
                ,name7,name8,name9,name10,name11,name12,name13
                ,name14
        };
        masg_textView=new TextView[]{
                masg1,masg2,masg3,masg4,masg5,masg6,masg7,masg8,masg9
                ,masg10,masg11,masg12,masg13,masg14};

        touxiang_imageView=new ImageView[]{
                touxiang1,touxiang2,touxiang3,touxiang4,touxiang5,touxiang6
                ,touxiang7,touxiang8,touxiang9,touxiang10,touxiang11,touxiang12
                ,touxiang13,touxiang14
        };


        //设置聊天名
        String[] liaotian=sharedPreferences.getString("liaotian","").split("[|]");
        for (int i = 0; i < 14; i++) {
            Log.d("TTAGG",liaotian[i]+"名字长度："+liaotian.length);
            name_textViews[i].setText(liaotian[i]);
        }

        //设置聊天内容
        String[] liaotian2=sharedPreferences.getString("liaotian2","").split("[|]");
        for (int i = 0; i < 14; i++) {
            Log.d("TTAGG",liaotian2[i]+"名字长度："+liaotian2.length);
            masg_textView[i].setText(liaotian2[i]);
        }


        //获取网络图片连接 设置头像
        String[] touxiang2=new String[14];
        touxiang2[0]=sharedPreferences.getString("touxiang","").replace(" ","");
        touxiang2[1]=sharedPreferences.getString("touxiang2","").replace(" ","");
        touxiang2[2]=sharedPreferences.getString("touxiang3","").replace(" ","");
        touxiang2[3]=sharedPreferences.getString("touxiang4","").replace(" ","");
        touxiang2[4]=sharedPreferences.getString("touxiang5","").replace(" ","");
        touxiang2[5]=sharedPreferences.getString("touxiang6","").replace(" ","");
        touxiang2[6]=sharedPreferences.getString("touxiang7","").replace(" ","");
        touxiang2[7]=sharedPreferences.getString("touxiang8","").replace(" ","");
        touxiang2[8]=sharedPreferences.getString("touxiang9","").replace(" ","");
        touxiang2[9]=sharedPreferences.getString("touxiang10","").replace(" ","");
        touxiang2[10]=sharedPreferences.getString("touxiang11","").replace(" ","");
        touxiang2[11]=sharedPreferences.getString("touxiang12","").replace(" ","");
        touxiang2[12]=sharedPreferences.getString("touxiang13","").replace(" ","");
        touxiang2[13]=sharedPreferences.getString("touxiang14","").replace(" ","");

        for (int i = 0; i < touxiang2.length; i++) {
            Log.d("TTAGG",touxiang2[i]+"长度："+touxiang2.length);
            RequestOptions options = new RequestOptions().error(R.drawable.liaot1).bitmapTransform(new RoundedCorners(8));//图片圆角为30
            Glide.with(this).load(touxiang2[i]).apply(options).into(touxiang_imageView[i]);
        }






        //获取系统时间
        long time=System.currentTimeMillis();
        final Calendar mCalendar=Calendar.getInstance();
        mCalendar.setTimeInMillis(time);
        int mHour=mCalendar.get(Calendar.HOUR_OF_DAY);
        int mMinuts=mCalendar.get(Calendar.MINUTE);

        Random random=new Random();
        int t1=random.nextInt(60 - 30) + 30;
        int t2=random.nextInt(29 - 20) + 20;
        int t3=random.nextInt(60 - 10) + 10;
        int t4=random.nextInt(29 - 10) + 10;
        time1.setText(mHour-1+":"+t1);
        time2.setText(mHour-1+":"+t2);
        time3.setText(mHour-2+":"+t3);
        time4.setText(mHour-3+":"+t4);
        Log.d("TTAG","t1"+t1 +"   t2"+t2+"    t3"+t3+"    t4"+t4);







    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.yueshengshi:
                Intent intent = new Intent(Main2.this, Main3.class);
                startActivity(intent);
                ((Activity) Main2.this).overridePendingTransition(0, 0);
                pullScrollView.closeTwoView();
                break;
            case R.id.yueshengshi2:
                Intent intent2 = new Intent(Main2.this, Main3.class);
                startActivity(intent2);
                ((Activity) Main2.this).overridePendingTransition(0, 0);
                pullScrollView.closeTwoView();
                break;
            case R.id.weixin:
                pullScrollView.closeTwoView(); //返回聊天界面
                break;
            case R.id.main2_tongxunlu:
                Intent intent3 = new Intent(Main2.this, Main11.class);
                startActivity(intent3);
                ((Activity) Main2.this).overridePendingTransition(0, 0);
                finish();
                break;
            case R.id.main2_faxian:
                Intent intent4 = new Intent(Main2.this, Main12.class);
                startActivity(intent4);
                ((Activity) Main2.this).overridePendingTransition(0, 0);
                finish();
                break;
            case R.id.main2_wode:
                Intent intent5 = new Intent(Main2.this, Main13.class);
                startActivity(intent5);
                ((Activity) Main2.this).overridePendingTransition(0, 0);
                finish();
                break;

        }
    }

    @Override
    public void onBackPressed() {
        if (pullScrollView.isTwoViewOpen()) {
            pullScrollView.closeTwoView();
        } else {
            super.onBackPressed();
        }
    }


}
