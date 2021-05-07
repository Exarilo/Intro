package com.example.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Intro2 extends AppCompatActivity {

    private TextView tvTextLogIn;
    private Button btValider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro2);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        tvTextLogIn=findViewById(R.id.tvTextLogIn);
        btValider=findViewById(R.id.btValider);

        String TxtIntro="   Salutation ! C'est donc toi qui doit nous aider a combattre la tribu des chats ?\n   Sache que je ne parle pas aux inconnus donc dit moi ton nom !";
        //tvTextLogIn.setText(TxtIntro);
        int txtIntroLenght= TxtIntro.length();


        for (char ch: TxtIntro.toCharArray()) {

            tvTextLogIn.setText(tvTextLogIn.getText().toString() + ch);

        }

        btValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToMain();
            }
        });



        /*
        while (tvTextLogIn.getText().toString()!=TxtIntro)
            for (char ch: TxtIntro.toCharArray()) {
                final Handler timerHandler = new Handler();
                final Runnable timerRunnable = new Runnable() {
                    @Override
                    public void run() {

                        tvTextLogIn.setText(tvTextLogIn.getText().toString()+ch);
                        timerHandler.postDelayed(this, 1005);     // 10 is how many milliseconds you want this thread to run
                    }
                };
                timerHandler.postDelayed(timerRunnable, 0);

            }*/
        //tvTextLogIn.setText(tvTextLogIn.getText().toString()+ch);
    }
    public void moveToMain(){
        Intent intent =new Intent(Intro2.this,MainActivity.class);
        startActivity(intent);
    }
}