package com.example.mdw.rxjavademo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotate);

        findViewById(R.id.load).startAnimation(anim);
        TextView tv;
    }
}
