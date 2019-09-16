package com.fatray.studynote.splash;

import android.util.Log;

import com.fatray.studynote.base.BaseMvpPresenter;
import com.fatray.studynote.widget.CustomCountDownTimer;

public class SplashTimerPresenter extends BaseMvpPresenter<ISplashActivityContract.Iview> implements ISplashActivityContract.IPresenter {

    private CustomCountDownTimer timer;

    public SplashTimerPresenter(ISplashActivityContract.Iview view) {
        super(view);
    }

//    public SplashTimerPresenter(SplashActivity activity){
//        this.mActivity = activity;
//    }



    public void initTimer() {
        timer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                getView().setTvTimer(time + "秒");
            }

            @Override
            public void onFinish() {
                getView().setTvTimer("跳过");
            }
        });

        timer.start();
    }

    public void cancel() {
        timer.cancel();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cancel();
        Log.e("SplashTimerPresenter", "onDestroy");
    }


    //防止空指针异常
    @Override
    protected ISplashActivityContract.Iview getEmptyView() {
        return ISplashActivityContract.emptyView;
    }

}
