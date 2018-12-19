package com.zhangl.qqtophead;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by zhangl on 2018/12/19.
 */

public class QQHeaderScrollView extends ListView {

    private static final String TAG = "QQHeaderScrollView";
    private ImageView mImageView;
    private int mImageViewHeight;


    public void setZoomImageView(ImageView iv) {

        this.mImageView = iv;
    }


    public QQHeaderScrollView(Context context) {
        this(context, null);
    }

    public QQHeaderScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

//        this.mImageViewHeight = dip2px(context,160);
//        this.mImageViewHeight = 160;
        this.mImageViewHeight = context.getResources().getDimensionPixelSize(R.dimen.size_default_height);

    }

    public QQHeaderScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        Log.i(TAG, "overScrollBy: " + deltaY);

        Log.i(TAG, "overScrollBy: " + deltaY);

        mImageView.getLayoutParams().height = mImageView.getHeight() - deltaY;
        mImageView.requestLayout();


        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        View header = (View) mImageView.getParent();
        Log.i(TAG, "onSizeChanged: " + header.getTop());
        int deltaY = header.getTop();

        if (mImageView.getHeight() > mImageViewHeight) {
            mImageView.getLayoutParams().height = mImageView.getHeight() + deltaY;
            header.layout(header.getLeft(), 0, header.getRight(), header.getHeight());
            mImageView.requestLayout();
        }


        super.onSizeChanged(w, h, oldw, oldh);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        if (action == MotionEvent.ACTION_UP) {

            ResetAnimation resetAnimation = new ResetAnimation(mImageViewHeight);
            resetAnimation.setInterpolator(new OvershootInterpolator());
            resetAnimation.setDuration(700);
            mImageView.startAnimation(resetAnimation);
        }
        return super.onTouchEvent(ev);
    }


    public class ResetAnimation extends Animation {

        private int extraHeight;
        private int currentHeight;

        public ResetAnimation(int targetHeight) {
            currentHeight = mImageView.getHeight();
            extraHeight = mImageView.getHeight() - targetHeight;
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {

            mImageView.getLayoutParams().height = (int) (currentHeight - extraHeight * interpolatedTime);
            mImageView.requestLayout();
            super.applyTransformation(interpolatedTime, t);
        }
    }


    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


}
