package com.example.jack.scrolldemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIntent = new Intent(MainActivity.this, ScrollViewText.class);
    }

    public void Button1(View view) {
        mIntent.putExtra(ScrollViewText.EXTRA_FLAG, 0);
        startActivity(mIntent);
    }
    public void Button2(View view){
        mIntent.putExtra(ScrollViewText.EXTRA_FLAG, 1);
        startActivity(mIntent);
    }
    public void Button3(View view){
        mIntent.putExtra(ScrollViewText.EXTRA_FLAG, 2);
        startActivity(mIntent);
    }
}
