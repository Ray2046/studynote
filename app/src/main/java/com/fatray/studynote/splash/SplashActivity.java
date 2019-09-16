package com.fatray.studynote.splash;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fatray.studynote.main.MainActivity;
import com.fatray.studynote.R;
import com.fatray.studynote.View.FullScreenVideoView;
import com.fatray.studynote.ViewInject;
import com.fatray.studynote.base.BaseActivity;

import java.io.File;

import androidx.annotation.Nullable;
import butterknife.BindView;

@ViewInject(mainlayout = R.layout.activity_splash)
public class SplashActivity extends BaseActivity implements ISplashActivityContract.Iview {

    @BindView(R.id.video_view)
    FullScreenVideoView video_view;
    @BindView(R.id.splash_tv)
    TextView splash_tv;
//    private CustomCountDownTimer timer;
    private ISplashActivityContract.IPresenter timerPresenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        splash_tv = findViewById(R.id.splash_tv);
//        video_view = findViewById(R.id.video_view);


    }

    @Override
    public void afterBindView() {
        initListener();

        //把初始化timer及 相关内容抽离到Presenter层中
//        initTimer();
        initTimerPresenter();
    }

    private void initTimerPresenter(){
        timerPresenter = new SplashTimerPresenter(this);
        timerPresenter.initTimer();
    }


//    private void initTimer() {
//
//        timer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandler() {
//            @Override
//            public void onTicker(int time) {
//                splash_tv.setText(time + "秒");
//            }
//
//            @Override
//            public void onFinish() {
//                splash_tv.setText("跳过");
//            }
//        });
//
//        timer.start();
//
//    }

    private void initListener() {

        video_view.setVideoURI(Uri.parse("android.resource://" + getPackageName() + File.separator + "raw" + File.separator + R.raw.splash2));

        video_view.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });

        video_view.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });

        splash_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });
    }



//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        timerPresenter.onDestroy();
//        timerPresenter.cancel();
//    }


    @Override
    public void setTvTimer(String s) {
        splash_tv.setText(s);
    }


}
