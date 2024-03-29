package com.fatray.studynote.widget;


import android.os.Handler;

public class CustomCountDownTimer implements Runnable {

    private final int time;
    private int countDowntime;
    private final ICountDownHandler countDownHandler;
    private final Handler handler;
    private boolean isRun;

    /**
     *  1.时时回调 这个时候是什么时间， 倒计时第几秒（观察者模式）
     *  2.支持动态传入总时间（一般通过构造函数传入）
     *  3.每过一秒，总秒数减一
     *  4.总时间倒计时为0时，要回调完成的状态
     */

    public CustomCountDownTimer(int time, ICountDownHandler countDownHandler){
        handler = new Handler();
        this.time = time;
        countDowntime = time;
        this.countDownHandler = countDownHandler;

    }

    //实现具体逻辑
    @Override
    public void run() {
        if (isRun){
            if (countDownHandler != null){
                countDownHandler.onTicker(countDowntime);
            }

            if (countDowntime == 0){
                if (countDownHandler != null){
                    countDownHandler.onFinish();
                }
                cancel();
            }else {
                countDowntime--;
                handler.postDelayed(this, 1000);
            }
        }
    }

    public void start(){
        isRun = true;

        handler.post(this);

    }

    public void cancel(){
        isRun =  false;
        handler.removeCallbacks(this);
    }


    // 观察者回调接口（IOC 数据回调）
    public interface ICountDownHandler{
        //倒计时回调
        void onTicker(int time);

        //完成时回调
        void onFinish();
    }


}
