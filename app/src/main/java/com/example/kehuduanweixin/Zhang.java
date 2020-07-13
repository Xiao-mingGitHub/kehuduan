package com.example.kehuduanweixin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Zhang extends View {

    private Paint mPaint,paint2;
    private int mDegree; // 旋转角度
    private String mText;
    private String mText_2;
    private int textSize=14;//文字大小sp
    private int xPosition; //x方向起始位置 dp
    private int yPosition; //y方向起始位置 dp
    private int yInterval=100; //y方向间距 dp
    private int mText_2_Interval_=20; //第二行距离第一行距离


    public Zhang(Context context) {
        super(context);
        init();
    }
    public Zhang(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public Zhang(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    //初始化参数
    private void init() {
        mPaint=new Paint();
        mPaint.setAntiAlias(true); //抗锯齿
        mPaint.setColor(getResources().getColor(R.color.colorRed)); //画笔颜色
        mPaint.setStyle(Paint.Style.FILL);//画笔风格
        mPaint.setTextSize(sp2px(textSize));//文字大小 单位px
        mPaint.setStrokeWidth(5);//画笔粗细
    }



    //重写该方法，在这里绘图
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint2=new Paint();
        paint2.setColor(Color.RED);
        paint2.setStyle(Paint.Style.STROKE);//画笔属性是空心圆
        paint2.setStrokeWidth(8);//设置画笔粗细
         /*四个参数：
                参数一：圆心的x坐标
                参数二：圆心的y坐标
                参数三：圆的半径
                参数四：定义好的画笔
                */
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, dp2px(200), paint2);


    }


    //px转成dp
    private int dp2px(int value) {
        float v = getContext().getResources().getDisplayMetrics().density;
        return (int) (v * value + 0.5f);
    }

    //px转成sp
    private int sp2px(int value) {
        float v = getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (v * value + 0.5f);
    }

    public void setWatermake(String mText) {
        this.mText=mText;
    }








}
