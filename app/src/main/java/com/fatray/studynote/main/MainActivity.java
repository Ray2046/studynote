package com.fatray.studynote.main;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.fatray.studynote.R;
import com.fatray.studynote.ViewInject;
import com.fatray.studynote.base.BaseActivity;
import com.fatray.studynote.main.tools.MainconstantTool;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.OnClick;

@ViewInject(mainlayout = R.layout.activity_main)
public class MainActivity extends BaseActivity implements IMainActivityContract.Iview {


    IMainActivityContract.IPresenter mPresenter = new MainActivityPresenter(this);


    @BindView(R.id.rg_main_top)
    RadioGroup rgMainTop;
    @BindView(R.id.rb_main_beijing)
    RadioButton rbMainNavHomeBeijing;
    @BindView(R.id.rb_main_shenzhen)
    RadioButton rbMainNavCarSourceShenzhen;
    @BindView(R.id.rg_main_bottom)
    RadioGroup rgMainBottom;
    @BindView(R.id.fl_main_bottom)
    FrameLayout flMainBottom;
    @BindView(R.id.float_action_btn)
    FloatingActionButton floatActionBtn;
    @BindView(R.id.fl_main_content)
    FrameLayout flMainContent;
    @BindView(R.id.rb_main_shanghai)
    RadioButton rbMainShanghai;
    @BindView(R.id.rb_main_hangzhou)
    RadioButton rbMainHangzhou;


    private boolean isChangeTopOrButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void afterBindView() {
        initHomeFragment();
        changeAnima(rgMainBottom, rgMainTop);
        initCheckListener();
    }

    private void initCheckListener() {
        rbMainShanghai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbMainShanghai.getId() == mPresenter.getCurrentCheckedIndex()) {
                    return;
                }
                mPresenter.replaceFragment(MainconstantTool.SHANGHAI);
            }
        });

        rbMainHangzhou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbMainHangzhou.getId() == mPresenter.getCurrentCheckedIndex()) {
                    return;
                }
                mPresenter.replaceFragment(MainconstantTool.HANGZHOU);
//                rbMainHangzhou.playAnimation();
//                rbMainShanghai.reverseAnimation();
            }
        });

        rbMainNavHomeBeijing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbMainNavHomeBeijing.getId() == mPresenter.getCurrentCheckedIndex()) {
                    return;
                }
                mPresenter.replaceFragment(MainconstantTool.BEIJING);
            }
        });

        rbMainNavCarSourceShenzhen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbMainNavCarSourceShenzhen.getId() == mPresenter.getCurrentCheckedIndex()) {
                    return;
                }
                mPresenter.replaceFragment(MainconstantTool.SHENZHEN);
            }
        });

//        rgMainBottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if (checkedId == mPresenter.getCurrentCheckedIndex()) {
//                    return;
//                }
//                switch (checkedId) {
//                    case R.id.rb_main_beijing:
//                        mPresenter.replaceFragment(2);
//                        break;
//                    case R.id.rb_main_shenzhen:
//                        mPresenter.replaceFragment(3);
//                        break;
//                }
//            }
//        });

    }

    //初始化Fragment
    private void initHomeFragment() {
        rbMainShanghai.setChecked(true);
        mPresenter.initHomeFragment();
    }


    @OnClick(R.id.float_action_btn)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.float_action_btn:

                isChangeTopOrButton = !isChangeTopOrButton;
                if (isChangeTopOrButton) {
                    changeAnima(rgMainTop, rgMainBottom);
                    handleTopPosition();
                } else {
                    changeAnima(rgMainBottom, rgMainTop);
                    handleBottomPosition();
                }

                break;
        }
    }

    // 北京 深圳
    private void handleBottomPosition() {
        if (mPresenter.getTopPosition() != 1){
            mPresenter.replaceFragment(0);
            rbMainShanghai.setChecked(true);
        }else {
            mPresenter.replaceFragment(1);
            rbMainHangzhou.setChecked(true);
        }

    }

    // 上海 杭州
    private void handleTopPosition() {
        if (mPresenter.getBottomPosition() != 3){
            mPresenter.replaceFragment(2);
            rbMainNavHomeBeijing.setChecked(true);
        }else {
            mPresenter.replaceFragment(3);
            rbMainNavCarSourceShenzhen.setChecked(true);
        }
    }

    private void changeAnima(RadioGroup gone, RadioGroup show) {
        //消失的动画
        gone.clearAnimation(); //清除动画
        Animation animationGone = AnimationUtils.loadAnimation(this, R.anim.main_tab_translate_hide);
        gone.startAnimation(animationGone);
        gone.setVisibility(View.GONE);

        //展示的动画
        show.clearAnimation();
        Animation animationShow = AnimationUtils.loadAnimation(this, R.anim.main_tab_translate_show);
        show.startAnimation(animationShow);
        show.setVisibility(View.VISIBLE);

    }


    @Override
    public void showFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().show(mFragment).commit();
    }

    @Override
    public void addFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main_content, mFragment).commit();
    }

    @Override
    public void hideFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().hide(mFragment).commit();
    }
}
