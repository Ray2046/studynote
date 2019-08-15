package com.fatray.studynote;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.fatray.studynote.View.FullScreenVideoView;
import com.fatray.studynote.widget.CustomCountDownTimer;

import java.io.File;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    FullScreenVideoView video_view;
    TextView splash_tv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        splash_tv = findViewById(R.id.splash_tv);
        video_view = findViewById(R.id.video_view);

//        "android:resource/
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


        CustomCountDownTimer timer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                splash_tv.setText(time + "秒");
            }

            @Override
            public void onFinish() {
                splash_tv.setText("跳过");
            }
        });

        timer.start();

    }
}
