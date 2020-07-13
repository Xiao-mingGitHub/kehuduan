package com.example.kehuduanweixin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Watermark extends View {

    private Paint mPaint;
    private int mDegree; // 旋转角度
    private String mText;
    private String mText_2;
    private int textSize=14;//文字大小sp
    private int xPosition; //x方向起始位置 dp
    private int yPosition; //y方向起始位置 dp
    private int yInterval=100; //y方向间距 dp
    private int mText_2_Interval_=20; //第二行距离第一行距离


    public Watermark(Context context) {
        super(context);
        init();
    }
    public Watermark(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public Watermark(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    //初始化参数
    private void init() {
        mPaint=new Paint();
        mPaint.setAntiAlias(true); //抗锯齿
        mPaint.setColor(getResources().getColor(R.color.colorWatertext)); //画笔颜色
        mPaint.setStyle(Paint.Style.FILL);//画笔风格
        mPaint.setTextSize(sp2px(textSize));//文字大小 单位px
        mPaint.setStrokeWidth(5);//画笔粗细
    }



    //重写该方法，在这里绘图
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.rotate(mDegree, this.getWidth() / 2f, this.getHeight() / 2f);
        canvas.save();

        canvas.drawText(mText,dp2px(xPosition),dp2px(yPosition),mPaint);
        canvas.drawText(mText_2,dp2px(xPosition),dp2px(yPosition)+dp2px(mText_2_Interval_),mPaint);

        canvas.drawText(mText,dp2px(xPosition),dp2px(yPosition)+dp2px(yInterval),mPaint);
        canvas.drawText(mText_2,dp2px(xPosition),dp2px(yPosition)+dp2px(yInterval)+dp2px(mText_2_Interval_),mPaint);

        canvas.drawText(mText,dp2px(xPosition),dp2px(yPosition)+dp2px(yInterval)*2,mPaint);
        canvas.drawText(mText_2,dp2px(xPosition),dp2px(yPosition)+dp2px(yInterval)*2+dp2px(mText_2_Interval_),mPaint);

        canvas.drawText(mText,dp2px(xPosition),dp2px(yPosition)+dp2px(yInterval)*3,mPaint);
        canvas.drawText(mText_2,dp2px(xPosition),dp2px(yPosition)+dp2px(yInterval)*3+dp2px(mText_2_Interval_),mPaint);

        canvas.drawText(mText,dp2px(xPosition),dp2px(yPosition)+dp2px(yInterval)*4,mPaint);
        canvas.drawText(mText_2,dp2px(xPosition),dp2px(yPosition)+dp2px(yInterval)*4+dp2px(mText_2_Interval_),mPaint);
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

    public void setWatermake(int degree,String mText,String mText_2,int xPosition,int yPosition) {
        this.mDegree = degree;
        this.mText=mText;
        this.mText_2=mText_2;
        this.xPosition=xPosition;
        this.yPosition=yPosition;
    }








}
