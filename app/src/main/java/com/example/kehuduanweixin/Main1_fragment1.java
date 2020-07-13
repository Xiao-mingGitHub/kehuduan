package com.example.kehuduanweixin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;

import static android.content.Context.MODE_PRIVATE;


public class Main1_fragment1 extends Fragment  implements View.OnClickListener{
    private Button login_btn,register_btn,exit_btn;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private View view;
    private int login_state;
    Map<String, String> map = new HashMap<String, String>();
    private String user_id, user_password;
    private Handler handler;
    private SharedPreferences.Editor write_configuration;
    private SharedPreferences read_configuration;
    private LinearLayout update;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main1_fragment1,null);
        init();//初始化按钮,界面
        check_login_updates();//检查登录密码
        processing_data(); //处理登录成功消息
        return view;
    }


    @SuppressLint("HandlerLeak")
    private void processing_data() {
        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                Log.d("TAG","开始处理返回数据");
                switch (msg.what) {
                    case 1:
                        try{
                            //获取用户登录的结果
                            LoginResult result=(LoginResult)msg.obj;
                            String status=result.getStatus();
                            String versions=result.getVersions();
                            if(status.equals("1")){
                                //检查是否要更新
                                if(versions.equals("1.0")){
                                    login_succeed(result);//跳转到登录成功的界面
                                }else {
                                    update.setVisibility(View.VISIBLE);//弹出更新页面
                                }
                            }else{
                                login_btn.setVisibility(View.VISIBLE);
                                register_btn.setVisibility(View.VISIBLE);
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
    }

    private void login_succeed(LoginResult result) {
        write_configuration.putInt("chace",0);
        write_configuration.putInt("login2",0);
        write_configuration.putInt("login3",0);
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
        ((Activity) getActivity()).overridePendingTransition(0, 0);
        getActivity().finish();
    }


    private void check_login_updates() {
        login_state= read_configuration.getInt("login",0);//0表示未登录 1登录过了
        if(login_state==1){
            user_id = read_configuration.getString("user","");
            user_password = read_configuration.getString("password","");
            Log.d("TAG", "账号："+ user_id +"密码"+ user_password);
            sendRequest(); //检测保存的密码是否能登录，登录成功返回数据
        }else {
            login_btn.setVisibility(View.VISIBLE);
            register_btn.setVisibility(View.VISIBLE);
        }
    }


    //发送post请求
    private void sendRequest(){
        //子线程里面操作网络
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d("TAG","子程序执行");
                    map.put("uid", user_id.trim()); //添加键字对 账号
                    map.put("pwd", user_password.trim()); //添加键字对 密码
                    String url="http://123.57.252.149/weixinlogin2.php";
                    HttpUtils.post(url, new Callback() {    //注意这里用的是自定义的 HttpUtils 里面封装了okhttp3
                        @Override
                        public void onFailure(@NotNull Call call, @NotNull IOException e) {
                            Log.d("TAG","失败返回");
                        }
                        @Override
                        public void onResponse(@NotNull Call call, okhttp3.Response response) throws IOException {
                            String responseBody = response.body().string(); //返回的JSON
                            Log.d("TAG","成功返回"+responseBody);
                            LoginResult result = parseJSONWithGson(responseBody); //解析JSON
                            Message msg = handler.obtainMessage();//发送登录成功的消息
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

    //解析文本
    private LoginResult parseJSONWithGson(String jsonData)
    {
        Gson gson = new Gson();
        return gson.fromJson(jsonData, LoginResult.class);
    }

    private void init() {
        read_configuration = getActivity().getSharedPreferences("user",MODE_PRIVATE); //初始化读取实例
        write_configuration =getActivity().getSharedPreferences("user",MODE_PRIVATE).edit(); //用户配置文件 写入实例
        getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE );//设置状态栏字体浅色主题
        getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.colorblack)); //设置状态栏黑色
        update=(LinearLayout) view.findViewById(R.id.update_lay);
        login_btn=(Button) view.findViewById(R.id.login_btn);
        register_btn=(Button) view.findViewById(R.id.register_btn);
        exit_btn=(Button) view.findViewById(R.id.exit_btn);
        exit_btn.setOnClickListener(this);
        login_btn.setOnClickListener(this);
        register_btn.setOnClickListener(this);
    }

    //切换fragment
    private void fragment(int fragment) {
        manager=getFragmentManager();//创建fragment的管理对象
        transaction = manager.beginTransaction();//获取fragment的事务对象，并且开启事务
        if(fragment==0){                         // 0表示跳转登录页面
            transaction.replace(R.id.login2,new Main1_fragment2()); //添加fragment
        }
        transaction.addToBackStack(null);//切换后 之前的fragmen不销毁，按返回键返回
        transaction.commit();
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_btn:
                fragment(0);// 0表示登录页面
                break;
            case R.id.register_btn:
                break;
            case R.id.exit_btn:
                getActivity().finish();
                break;
        }

    }
}
