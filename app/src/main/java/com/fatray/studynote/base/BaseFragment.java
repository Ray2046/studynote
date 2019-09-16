package com.fatray.studynote.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fatray.studynote.ViewInject;
import com.fatray.studynote.mvp.presenter.LifeCircleMvpFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.ButterKnife;

public abstract class BaseFragment extends LifeCircleMvpFragment {

    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView;
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation != null){
            int mainlayout = annotation.mainlayout();
            if (mainlayout > 0){
                mView = initFragmentView(inflater,mainlayout);
                bindView(mView);
                afterBindView();
            }else {
                throw new RuntimeException("mainlayout < 0");
            }
        }else {
            throw new RuntimeException("annotation = null");
        }
        return mView;
    }

    protected View initFragmentView(LayoutInflater inflater,int mainlayout){
        return  inflater.inflate(mainlayout, null);
    }


    // 模板方法 设计模式
    public abstract void afterBindView();

    private void bindView(View view) {
        ButterKnife.bind(view);
    }
}
