package com.example.kehuduanweixin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;

import static android.content.Context.MODE_PRIVATE;


public class Main1_fragment2 extends Fragment {
    private EditText user_Id, user_password; //输入框
    private View view;
    private Button login_btn,exit_btn;
    Map<String, String> map = new HashMap<String, String>();
    private Handler handler;
    private SharedPreferences.Editor write_configuration;
    private LinearLayout update;

    @SuppressLint("HandlerLeak")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main1_fragment2,null);
        getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.color_background2)); //设置状态栏灰色
        getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR );//设置状态栏字体深色主题

        init(); //初始化数据


//        登录按钮点击事件
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
                Log.d("TAG","按钮响应");
            }
        });

        //处理登录成功消息
        handler = new Handler(){

            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                Log.d("TAG","返回数据");
                switch (msg.what) {
                    case 1:
                        try{
                            //获取用户登录的结果
                            LoginResult result=(LoginResult)msg.obj;
                            String status=result.getStatus();
                            String versions=result.getVersions();

                            if(status.equals("1")){
                                if(versions.equals("1.0")){
                                    login_succeed(result);//跳转到登录成功的界面
                                }else {
                                    update.setVisibility(View.VISIBLE);//弹出更新页面
                                }
                            }else if(status.equals("2")){
                                Toast.makeText(view.getContext(), "密码错误",Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(view.getContext(), "用户不存在",Toast.LENGTH_SHORT).show();
                            }

                        }catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        break;
                }
            }
        };
        return view;
    }

    private void login_succeed(LoginResult result) {
        write_configuration.putInt("chace",0);
        write_configuration.putInt("login",1);
        write_configuration.putInt("login3",0);
        write_configuration.putInt("login2",0);//1是登录 0是未登录
        write_configuration.putString("user", user_Id.getText().toString().trim());
        write_configuration.putString("password", user_Id.getText().toString().trim());
        write_configuration.putString("name",result.getName());
        write_configuration.putString("touxiang",result.getTouxiang());
        write_configuration.putString("name2",result.getName2());
        write_configuration.putString("name3",result.getName3());
        write_configuration.putString("shenfenzheng",result.getShenfenzheng());
        write_configuration.putString("shenfenzheng2",result.getShenfenzheng2());
        write_configuration.putString("chushengriqi",result.getChushengriqi());
        write_configuration.putString("chushengriqi2",result.getChushengriqi2());
        write_configuration.putString("lihundengji",result.getLihundengji());
        write_configuration.putString("xingbie",result.getXingbie());
        write_configuration.putString("xingbie2",result.getXingbie2());
        write_configuration.putString("dengjiyuan",result.getDengjiyuan());
        write_configuration.putString("dengjijiguan",result.getDengjijiguan());
        write_configuration.putString("lihunzhenghao",result.getLihunzhenghao());
        write_configuration.putString("diqu",result.getDiqu());
        write_configuration.putString("shijian",result.getShijian());
        write_configuration.putString("budong",result.getBudong());
        write_configuration.putString("zuoluo",result.getZuoluo());
        write_configuration.putString("yongtu",result.getYongtu());
        write_configuration.putString("xingzhi",result.getXingzhi());
        write_configuration.putString("mianji",result.getMianji());
        write_configuration.putString("zhuangtai",result.getZhuangtai());
        write_configuration.putString("budong2",result.getBudong2());
        write_configuration.putString("zuoluo2",result.getZuoluo2());
        write_configuration.putString("yongtu2",result.getYongtu2());
        write_configuration.putString("xingzhi2",result.getXingzhi2());
        write_configuration.putString("mianji2",result.getMianji2());
        write_configuration.putString("zhuangtai2",result.getZhuangtai2());
        write_configuration.putString("touxiang2",result.getTouxiang2());
        write_configuration.putString("touxiang3",result.getTouxiang3());
        write_configuration.putString("touxiang4",result.getTouxiang4());
        write_configuration.putString("touxiang5",result.getTouxiang5());
        write_configuration.putString("touxiang6",result.getTouxiang6());
        write_configuration.putString("touxiang7",result.getTouxiang7());
        write_configuration.putString("touxiang8",result.getTouxiang8());
        write_configuration.putString("touxiang9",result.getTouxiang9());
        write_configuration.putString("touxiang10",result.getTouxiang10());
        write_configuration.putString("touxiang11",result.getTouxiang11());
        write_configuration.putString("touxiang12",result.getTouxiang12());
        write_configuration.putString("touxiang13",result.getTouxiang13());
        write_configuration.putString("touxiang14",result.getTouxiang14());
        write_configuration.putString("touxiang15",result.getTouxiang15());
        write_configuration.putString("liaotian",result.getLiaotian());
        write_configuration.putString("liaotian2",result.getLiaotian2());
        write_configuration.putString("dengjiriqi",result.getDengjiriqi());
        write_configuration.putString("jiehundengjiriqi",result.getJiehundengjiriqi());
        write_configuration.putString("jiehunzhenghao",result.getJiehunzhenghao());
        write_configuration.putString("jiehundengji",result.getJiehundengji());
        write_configuration.putString("zhaopian",result.getZhaopian());
        write_configuration.putString("zhang",result.getZhang());
        write_configuration.putString("lihundengjijiguan",result.getLihundengjijiguan());
        write_configuration.putString("dengjiyuan2",result.getDengjiyuan2());
        write_configuration.putString("chanquanren",result.getChanquanren());
        write_configuration.apply();//提交
        Intent intent = new Intent(getActivity(), Main2.class);
        startActivity(intent);
        getActivity().finish();
    }

    //解析文本
    private LoginResult parseJSONWithGson(String jsonData)
    {
        Gson gson = new Gson();
        return gson.fromJson(jsonData, LoginResult.class);
    }

    //发送post请求
    private void sendRequest(){
//        returnResult = 0;
        //子线程里面操作网络
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d("TAG","子程序执行");
                    map.put("uid", user_Id.getText().toString().trim()); //添加键字对 账号
                    map.put("pwd", user_password.getText().toString().trim()); //添加键字对 密码
                    String url="http://123.57.252.149/weixinlogin2.php";


//                    注意这里用的是自定义的 HttpUtils 里面封装了okhttp3
                    HttpUtils.post(url, new Callback() {
                        @Override
                        public void onFailure(@NotNull Call call, @NotNull IOException e) {
                            Log.d("TAG","失败返回");
                        }
                        @Override
                        public void onResponse(@NotNull Call call, okhttp3.Response response) throws IOException {
                            String responseBody = response.body().string(); //返回的JSON
                            Log.d("TAG","成功返回"+responseBody);
                            LoginResult result = parseJSONWithGson(responseBody);//解析JSON
                            Message msg = handler.obtainMessage(); //发送登录成功的消息
                            msg.what = 1;
                            msg.obj = result; //把登录结果也发送过去
                            handler.sendMessage(msg);
                        }
                    },map);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

    }

    //数据初始化
    private void init() {
        update=(LinearLayout)view.findViewById(R.id.update_lay2);
        exit_btn=(Button)view.findViewById(R.id.exit_btn2);
        write_configuration =getActivity().getSharedPreferences("user",MODE_PRIVATE).edit(); //用户配置文件 写入实例
        user_Id =(EditText)view.findViewById(R.id.login_id);
        user_password =(EditText)view.findViewById(R.id.login_password);
        login_btn=(Button)view.findViewById(R.id.login);
        TextChang textChang=new TextChang();
        user_Id.addTextChangedListener(textChang);
        user_password.addTextChangedListener(textChang);
        exit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
    }



    //编辑框监听
    class TextChang implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if(user_Id.length()>0 && user_password.length()>0){
                login_btn.setEnabled(true);
                login_btn.setBackground(getResources().getDrawable(R.drawable.login_btn));
                login_btn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }else {
                login_btn.setEnabled(false);
                login_btn.setBackground(getResources().getDrawable(R.drawable.login_btn3));
                login_btn.setTextColor(getResources().getColor(R.color.colorlogin));
            }
        }
    }


}
