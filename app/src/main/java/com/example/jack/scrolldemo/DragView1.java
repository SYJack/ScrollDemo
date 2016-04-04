package com.example.jack.scrolldemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Scroller;

/**
 * author：jack on 2016/4/3 19:32
 */
public class DragView1 extends ImageView {
    private Scroller mScroller;

    private int lastX;
    private int lastY;

    public DragView1(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragView1(Context context) {
        this(context, null);
    }

    public DragView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScroller = new Scroller(context);
    }

    @Override
    public void computeScroll() {
        Log.e("computeScroll","computeScroll");
        super.computeScroll();
        /**
         *computeScrollOffset判断是否完成整个滑动,方法用来判断是否完成了整个滑动，返回为true，则说明没有完成，否则则完成滑动。
         **/
        if (mScroller.computeScrollOffset()) {
            /**getCurrX，getCurrY获得当前的滑动坐标**/
            ((View) getParent()).scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("ACTION_DOWN","ACTION_DOWN");
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("ACTION_MOVE","ACTION_MOVE");
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                ((View) getParent()).scrollBy(-offsetX, -offsetY);
                break;
            case MotionEvent.ACTION_UP:
                Log.e("ACTION_UP","ACTION_UP");
                View viewGroup = (View) getParent();
                mScroller.startScroll(viewGroup.getScrollX(),viewGroup.getScrollY(),-viewGroup.getScrollX(),-viewGroup.getScrollY());
                /**通知view进行重绘，从而调用computeScroll的模拟过程*/
                invalidate();
                break;
        }
        return true;
    }
}
