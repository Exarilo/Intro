package com.example.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ScrollView;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvIntro;
    ScrollView ScrollViewIntro;
    static boolean isAnimate=true;
    private Button btSkipIntro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);




        tvIntro=findViewById(R.id.tvIntro);
        tvIntro.setMovementMethod(new ScrollingMovementMethod());


        ScrollViewIntro=findViewById(R.id.ScrollViewIntro);

        tvAnimate();

        btSkipIntro=findViewById(R.id.btSkipIntro);
        btSkipIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToIntro2();
            }
        });

    }

    public void moveToIntro2(){
        Intent intent =new Intent(MainActivity.this,Intro2.class);
        startActivity(intent);
    }

    public void tvAnimate(){

        final Handler timerHandler = new Handler();
        final Runnable timerRunnable = new Runnable() {
            @Override
            public void run() {
                ScrollViewIntro.smoothScrollBy(0,2);         // 5 is how many pixels you want it to scroll vertically by
                timerHandler.postDelayed(this, 50);     // 10 is how many milliseconds you want this thread to run
            }
        };
        timerHandler.postDelayed(timerRunnable, 0);
        tvIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isAnimate) {
                    timerHandler.removeCallbacks(timerRunnable);
                    isAnimate=false;
                }
                else {
                    timerHandler.postDelayed(timerRunnable, 0);
                    isAnimate=true;
                }

            }
        });
    }



}
