package com.example.jack.scrolldemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * author：jack on 2016/4/2 19:41
 */
public class ScrollViewText extends AppCompatActivity {
    public static final String EXTRA_FLAG = "extra_flag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int flag = getIntent().getIntExtra(EXTRA_FLAG, -1);
        switch (flag) {
            case 0:
                setContentView(R.layout.layout_motionevent);
                break;
            case 1:
                setContentView(R.layout.layout_scrollbyto);
                break;
            case 2:
                setContentView(R.layout.layout_dragscale);
        }
    }
}
