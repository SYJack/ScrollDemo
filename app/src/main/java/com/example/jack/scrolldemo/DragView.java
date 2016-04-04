package com.example.jack.scrolldemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * author：jack on 2016/4/2 20:10
 */
public class DragView extends ImageView {
//    private Paint mPaint;

    private int lastX;
    private int lastY;

    public DragView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragView(Context context) {
        this(context, null);
    }

    public DragView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        mPaint = new Paint();
//        mPaint.setAntiAlias(true);
//        mPaint.setColor(getResources().getColor(R.color.colorAccent));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    private int measureHeight(int heightMeasureSpec) {
        int specHeight = MeasureSpec.getSize(heightMeasureSpec);
        int specHeightMode = MeasureSpec.getMode(heightMeasureSpec);

        int result = 0;
        if (specHeightMode == MeasureSpec.EXACTLY) {
            result = specHeight;
        } else {
            result = 200;
            if (specHeightMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specHeight);
            }
        }
        return result;
    }

    private int measureWidth(int widthMeasureSpec) {
        int specWidth = MeasureSpec.getSize(widthMeasureSpec);
        int specWidthMode = MeasureSpec.getMode(widthMeasureSpec);

        int result = 0;
        if (specWidthMode == MeasureSpec.EXACTLY) {
            result = specWidth;
        } else {
            result = 200;
            if (specWidthMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specWidth);
            }
        }
        return result;
    }

//    @Override
//    protected void onDraw(Canvas canvas) {
//        canvas.drawRect(0, 0, 100, 100, mPaint);
//    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        /**
         *获取视图坐标
         */
        int x = (int) event.getX();
        int y = (int) event.getY();
        Log.e("XXXXX", String.valueOf(x));
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                layout(getLeft() + offsetX, getTop() + offsetY,
                        getRight() + offsetX, getBottom() + offsetY);
//                offsetLeftAndRight(offsetX);
//                offsetTopAndBottom(offsetY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
}
