package com.fatray.studynote.main;

import com.fatray.studynote.mvp.ILifeCircle;
import com.fatray.studynote.mvp.IMvpView;
import com.fatray.studynote.mvp.MvpControler;

import androidx.fragment.app.Fragment;

public interface IMainActivityContract {

    interface  Iview extends IMvpView {

        void showFragment(Fragment mFragment);

        void addFragment(Fragment mFragment);

        void hideFragment(Fragment mFragment);
    }

    interface  IPresenter extends ILifeCircle {

        void initHomeFragment();

        int getCurrentCheckedIndex();

        void replaceFragment(int mCurrentFragmentIndex);

        int getTopPosition();

        int getBottomPosition();
    }

    Iview emptyView = new Iview() {


        @Override
        public void showFragment(Fragment mFragment) {

        }

        @Override
        public void addFragment(Fragment mFragment) {

        }

        @Override
        public void hideFragment(Fragment mFragment) {

        }

        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };
}
