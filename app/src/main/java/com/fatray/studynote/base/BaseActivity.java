package com.fatray.studynote.base;

import android.os.Bundle;

import com.fatray.studynote.ViewInject;
import com.fatray.studynote.mvp.presenter.LifeCircleMvpActivity;

import androidx.annotation.Nullable;
import butterknife.ButterKnife;

public abstract class BaseActivity extends LifeCircleMvpActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation != null){
            int mainlayout = annotation.mainlayout();
            if (mainlayout > 0){
                setContentView(mainlayout);
                bindView();
                afterBindView();
            }else {
                throw new RuntimeException("mainlayout < 0");
            }
        }else {
            throw new RuntimeException("annotation = null");
        }
    }

    // 模板方法 设计模式
    public abstract void afterBindView();

    private void bindView() {
        ButterKnife.bind(this);
    }
}
