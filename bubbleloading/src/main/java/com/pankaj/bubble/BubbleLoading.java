package com.pankaj.bubble;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import java.lang.ref.WeakReference;

public class BubbleLoading extends LinearLayout {


    private Ball ballOne;
    private Ball ballTwo;
    private Ball ballThree;
    private Ball ballFour;
    private Ball ballFive;

    private static final int DURATION = 1000;
    private static final int SHAKE_DISTANCE = 2;
    private static final float PIVOT_X = 0.5f;
    private static final float PIVOT_Y = -3f;
    private static final int DEGREE = 30;

//    RotateAnimation translateUp;
    TranslateAnimation translateUp;
    RotateAnimation translateDown;


    private boolean isStart = false;

    public BubbleLoading(Context context) {
        super(context);
        initView(context);
    }

    public BubbleLoading(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public BubbleLoading(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bubble_loading, this, true);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ballOne = (Ball) findViewById(R.id.ball_one);
        ballTwo = (Ball) findViewById(R.id.ball_two);
        ballThree = (Ball) findViewById(R.id.ball_three);
        ballFour = (Ball) findViewById(R.id.ball_four);
        ballFive = (Ball) findViewById(R.id.ball_five);

        initAnim();
        startLeftAnim();
    }

    private void initAnim() {
//        translateUp = new RotateAnimation(0, -DEGREE, RotateAnimation.RELATIVE_TO_SELF, PIVOT_X, RotateAnimation.RELATIVE_TO_SELF, PIVOT_Y);
//        translateUp.setRepeatCount(1);
//        translateUp.setRepeatMode(Animation.REVERSE);
//        translateUp.setDuration(DURATION);
//        translateUp.setInterpolator(new LinearInterpolator());
//        translateUp.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
////                if (isStart)
////                    startRightAnim();
//                startLeftAnim();
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//            }
//        });

        translateUp = new TranslateAnimation(0, 0, 0, 20);
        translateUp.setDuration(DURATION);
        translateUp.setRepeatCount(Animation.INFINITE);
        translateUp.setInterpolator(new CycleInterpolator(2));
    }

    private void startLeftAnim() {

        new Handler().post(new Runnable() {
            @Override
            public void run() {
                WeakReference<Ball> ballWeakReference1 = new WeakReference<>(ballOne);
                startAnim(ballWeakReference1);
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                WeakReference<Ball> ballWeakReference2 = new WeakReference<>(ballTwo);
                startAnim(ballWeakReference2);
            }
        },200);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                WeakReference<Ball> ballWeakReference3 = new WeakReference<>(ballThree);
                startAnim(ballWeakReference3);
            }
        },400);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                WeakReference<Ball> ballWeakReference4 = new WeakReference<>(ballFour);
                startAnim(ballWeakReference4);
            }
        },600);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                WeakReference<Ball> ballWeakReference5 = new WeakReference<>(ballFive);
                startAnim(ballWeakReference5 );
            }
        },800);

    }

    private void startAnim(WeakReference<Ball> weakReferenceball) {
        Ball ball = weakReferenceball.get();
        TranslateAnimation translate = new TranslateAnimation(0, 0, 0, 20);
        translate.setDuration(DURATION);
        translate.setRepeatCount(Animation.INFINITE);
        translate.setInterpolator(new CycleInterpolator(2));
        ball.startAnimation(translate);

    }


    @Override
    protected void onVisibilityChanged(@NonNull View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == View.VISIBLE) {
            startLeftAnim();
        } else {
            ballOne.clearAnimation();
            ballTwo.clearAnimation();
            ballThree.clearAnimation();
            ballFour.clearAnimation();
            ballFive.clearAnimation();
        }
    }
}
