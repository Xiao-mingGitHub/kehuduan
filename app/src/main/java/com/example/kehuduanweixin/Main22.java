package com.example.kehuduanweixin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Calendar;

public class Main22 extends AppCompatActivity {
    private TextView user_name,user_id2,time_2,zhuzhai_2,xinzhi_2,mianji,zhuangtai,fenqu_2;
    private Button button;
    private SharedPreferences sharedPreferences;
    private  TextView chanQuan,zuoluo_2;
    private String stime,sdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main22);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//设置状态栏字体黑色
        sharedPreferences = getSharedPreferences("user",MODE_PRIVATE); //初始化读取实例
        setTime();//设置时间
        initWater();//设置水印
        settest(); //绑定设置文本
        button=(Button)findViewById(R.id.btn);//返回首页按钮
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Main22.this, Main3.class);
                startActivity(intent2);
                finish();
            }
        });
    }

    private void settest() {
        user_name=(TextView)findViewById(R.id.user_name);//名字
        user_id2=(TextView)findViewById(R.id.user_id2);//身份证
        time_2=(TextView)findViewById(R.id.time_2);//截止时间
        fenqu_2=(TextView)findViewById(R.id.fenqu_2);//地区
        chanQuan=(TextView)findViewById(R.id.chanQuan);//不动产产权证号
        zuoluo_2=(TextView)findViewById(R.id.zuoluo_2);
        zhuzhai_2=(TextView)findViewById(R.id.zhuzhai_2);
        xinzhi_2=(TextView)findViewById(R.id.xinzhi_2);
        mianji=(TextView)findViewById(R.id.mianji);
        zhuangtai=(TextView)findViewById(R.id.zhuangtai);
        String chan_quan=sharedPreferences.getString("budong","");
        int a=getlent(chan_quan); //如果a>0表示要分割文本
        if(a>0){
            chan_quan=chan_quan.substring(0,a)+"\n"+chan_quan.substring(a,chan_quan.length());//分行
            chanQuan.setText(chan_quan);
        }else {
            chanQuan.setText(chan_quan); //不用分行
        }


        String zuo_luo=sharedPreferences.getString("zuoluo","");
        int b=getlent(zuo_luo); //如果B>0表示要分割文本
        if(b>0){
            zuo_luo=zuo_luo.substring(0,b)+"\n"+zuo_luo.substring(b,zuo_luo.length());
            zuoluo_2.setText(zuo_luo);
        }else {
            zuoluo_2.setText(zuo_luo);
        }
        zhuzhai_2.setText(sharedPreferences.getString("yongtu",""));
        xinzhi_2.setText(sharedPreferences.getString("xingzhi",""));
        mianji.setText(sharedPreferences.getString("mianji",""));
        zhuangtai.setText(sharedPreferences.getString("zhuangtai",""));
        fenqu_2.setText(sharedPreferences.getString("diqu","")+"不动产查档情况 (共1套)");
        time_2.setText("查询截止日期:"+sdate+" "+stime);
        if(sharedPreferences.getString("zhuangtai","").contains("登记")||sharedPreferences.getString("zhuangtai","").contains("抵押")){
            zhuangtai.setTextColor(getColor(R.color.colorRed));
        }else {
            zhuangtai.setTextColor(getColor(R.color.colorText_search));
        }
        user_name.setText(sharedPreferences.getString("chanquanren",""));
        String string=sharedPreferences.getString("shenfenzheng","");
        user_id2.setText(string.substring(0,1)+"****************"+string.substring(string.length()-1));

    }


    private void setTime() {
        String gettime;
        gettime=sharedPreferences.getString("shijian","");
        if(gettime.length()<2){
            Calendar calendar = Calendar.getInstance(); //获取系统的日期
            int year = calendar.get(Calendar.YEAR);//年
            int month = calendar.get(Calendar.MONTH)+1;//月
            int day = calendar.get(Calendar.DAY_OF_MONTH);//日
            int hour = calendar.get(Calendar.HOUR_OF_DAY);//小时
            int minute = calendar.get(Calendar.MINUTE);//分钟
            //int second = calendar.get(Calendar.SECOND);//秒
            stime=(hour+":"+minute);
            sdate=(year+"-"+month+"-"+day);
        }else{
            sdate=gettime.substring(0,10);
            stime=gettime.substring(stime.length(),5);
        }
    }


    private int getlent(String s){
        String chinese = "[\u4e00-\u9fa5]";
        double valueLength=0;
        int weizhi=0;
        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(i, i + 1);    // 获取一个字符
            if (temp.matches(chinese)) {            // 判断是否为中文字符
                valueLength += 1;                   // 中文字符长度为1
            } else {
                valueLength += 0.5;                 // 其他字符长度为0.5
            }
            if(valueLength>15){
                weizhi=i;
                break;
            }
        }
        return weizhi;
    }

    private void initWater() {
        String sdiqu,shuiying;
        sdiqu=sharedPreferences.getString("diqu","");
        Watermark watermark=(Watermark)findViewById(R.id.watertext);
        Watermark watermark2=(Watermark)findViewById(R.id.watertext_2);

        if(sdiqu.contains("南海")){
            watermark.setWatermake(-30,sdiqu+"不动产登记中心"+sdate,stime,70,-40);
            watermark2.setWatermake(-30,sdiqu+"不动产登记中心"+sdate,stime,20,-30);
        }else {
            watermark.setWatermake(-30,sdiqu+"不动产登记中心"+sdate+""+stime,"",70,-20);
            watermark2.setWatermake(-30,sdiqu+"不动产登记中心"+sdate+""+stime,"",-50,-40);
        }


    }


}
