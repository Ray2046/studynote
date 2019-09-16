package com.fatray.studynote.splash;

import com.fatray.studynote.mvp.ILifeCircle;
import com.fatray.studynote.mvp.IMvpView;
import com.fatray.studynote.mvp.MvpControler;

public interface ISplashActivityContract {

    interface  Iview extends IMvpView {
        void setTvTimer(String timer);
    }

    interface  IPresenter extends ILifeCircle {
        void initTimer();
    }

    Iview emptyView = new Iview() {
        @Override
        public void setTvTimer(String timer) {

        }

        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };
}
