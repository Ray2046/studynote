package com.fatray.studynote.mvp;

import android.content.Intent;
import android.os.Bundle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MvpControler implements ILifeCircle {

    // 存放的是 P层的实例
    private Set<ILifeCircle> lifeCircles = new HashSet<>();


    public void savePresenter(ILifeCircle lifeCircle){
        this.lifeCircles.add(lifeCircle);
    }


    private static MvpControler getInstance(){
        return new MvpControler();
    }

    @Override
    public void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArgue) {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            if (intent == null){
                intent = new Intent();
            }
            if (getArgue == null){
                getArgue = new Bundle();
            }
            next.onCreate(savedInstanceState,intent,getArgue);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState, Intent intent, Bundle getArgue) {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            if (intent == null){
                intent = new Intent();
            }
            if (getArgue == null){
                getArgue = new Bundle();
            }
            next.onActivityCreated(savedInstanceState,intent,getArgue);
        }
    }

    @Override
    public void onStart() {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            next.onStart();
        }
    }

    @Override
    public void onResume() {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            next.onResume();
        }
    }

    @Override
    public void onPause() {

        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            next.onPause();
        }
    }

    @Override
    public void onStop() {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            next.onStop();
        }
    }

    @Override
    public void onDestroy() {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            next.onDestroy();
        }
    }

    @Override
    public void destroyView() {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            next.destroyView();
        }
    }

    @Override
    public void onViewDestroy() {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            next.onViewDestroy();
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            if (intent == null){
                intent = new Intent();
            }
            next.onNewIntent(intent);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            if (data == null){
                data = new Intent();
            }
            next.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()){
            ILifeCircle next = iterator.next();
            if (bundle == null){
                bundle = new Bundle();
            }
            next.onSaveInstanceState(bundle);
        }
    }

    @Override
    public void attachView(IMvpView iMvpView) {

    }
}
