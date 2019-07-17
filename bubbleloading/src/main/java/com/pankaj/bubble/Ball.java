package com.pankaj.bubble;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.pankaj.bubble.R;

public class Ball extends View {

    private int width;
    private int height;

    private Paint paint;

    private int loadingColor = Color.WHITE;

    public Ball(Context context) {
        super(context);
        initView(null);
    }

    public Ball(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }

    public Ball(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);
    }

    private void initView(AttributeSet attrs) {
        if (null != attrs) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.Ball);
            loadingColor = typedArray.getColor(R.styleable.Ball_ball_color, Color.WHITE);
            typedArray.recycle();
        }
        paint = new Paint();
        paint.setColor(loadingColor);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(width / 2, height / 2, width / 2, paint);
    }

    public void setLoadingColor(int color) {
        loadingColor = color;
        paint.setColor(color);
        postInvalidate();
    }

    public int getLoadingColor() {
        return loadingColor;
    }
}