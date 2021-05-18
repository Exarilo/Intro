package com.example.intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Intro2 extends AppCompatActivity {

    private TypeWriter tvTextLogIn;
    private Button btValider;
    private Button btPrevious;
    private Button btNext;
    private ImageView imgAvatar1;
    private ImageView imgAvatar2;
    private ImageView imgAvatar3;
    private ImageView imgAvatar4;
    private EditText tvPseudo;
    static int avatarSelect =0;
    static User currentUser;
    Database db = new Database(Intro2.this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro2);
        //this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        tvTextLogIn=findViewById(R.id.tvTextLogIn);
        btValider=findViewById(R.id.btValider);
        btNext=findViewById(R.id.btNext);
        btPrevious=findViewById(R.id.btPrevious);

        imgAvatar1=findViewById(R.id.imgAvatar1);
        imgAvatar2=findViewById(R.id.imgAvatar2);
        imgAvatar3=findViewById(R.id.imgAvatar3);
        imgAvatar4=findViewById(R.id.imgAvatar4);
        tvPseudo=findViewById(R.id.tvPseudo);

        User user=new User("",1,0,0,100,1000,1000);
        currentUser=user;
        db.LoadUser(currentUser);

        if (Intro2.currentUser.name!="")
            tvPseudo.setText(Intro2.currentUser.name);
        //tvTextLogIn.setText(TxtIntro);
        //int txtIntroLenght= TxtIntro.length();

        //showMessageIntro();
        String TxtIntro="Salutation ! C'est donc toi qui doit nous aider a combattre la tribu des chats ?\nSache que je ne parle pas aux inconnus donc dit moi ton nom !";
        tvTextLogIn.setText("");
        tvTextLogIn.setCharacterDelay(35);
        tvTextLogIn.animateText(TxtIntro);
/*
        for (char ch: TxtIntro.toCharArray()) {

            tvTextLogIn.setText(tvTextLogIn.getText().toString() + ch);


        }*/

        imgAvatar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(avatarSelect!=1){
                    imgAvatar1.setBackgroundResource(R.drawable.roundimgselect);
                    imgAvatar2.setBackgroundResource(R.drawable.roundimg);
                    imgAvatar3.setBackgroundResource(R.drawable.roundimg);
                    imgAvatar4.setBackgroundResource(R.drawable.roundimg);
                    avatarSelect=1;
                }
                else{
                    imgAvatar1.setBackgroundResource(R.drawable.roundimg);
                    avatarSelect=0;
                }
            }
        });
        imgAvatar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(avatarSelect!=2) {
                    imgAvatar1.setBackgroundResource(R.drawable.roundimg);
                    imgAvatar2.setBackgroundResource(R.drawable.roundimgselect);
                    imgAvatar3.setBackgroundResource(R.drawable.roundimg);
                    imgAvatar4.setBackgroundResource(R.drawable.roundimg);
                    avatarSelect = 2;
                }
                else{
                    imgAvatar2.setBackgroundResource(R.drawable.roundimg);
                    avatarSelect=0;
                }
            }
        });
        imgAvatar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(avatarSelect!=3) {
                    imgAvatar1.setBackgroundResource(R.drawable.roundimg);
                    imgAvatar2.setBackgroundResource(R.drawable.roundimg);
                    imgAvatar3.setBackgroundResource(R.drawable.roundimgselect);
                    imgAvatar4.setBackgroundResource(R.drawable.roundimg);
                    avatarSelect = 3;
                }
                else{
                    imgAvatar3.setBackgroundResource(R.drawable.roundimg);
                    avatarSelect=0;
                }
            }
        });
        imgAvatar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(avatarSelect!=4) {
                    imgAvatar1.setBackgroundResource(R.drawable.roundimg);
                    imgAvatar2.setBackgroundResource(R.drawable.roundimg);
                    imgAvatar3.setBackgroundResource(R.drawable.roundimg);
                    imgAvatar4.setBackgroundResource(R.drawable.roundimgselect);
                    avatarSelect=4;
                }
                else{
                    imgAvatar4.setBackgroundResource(R.drawable.roundimg);
                    avatarSelect=0;
                }
            }
        });

        btValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvPseudo.getText().toString().length()<1){
                    tvTextLogIn.setText("");
                    tvTextLogIn.setCharacterDelay(35);
                    tvTextLogIn.animateText("Tu es obligés de choisir un pseudo pour rejoindre notre monde ! ");
                }
                else if(tvPseudo.getText().toString().length()>15){
                    tvTextLogIn.setText("");
                    tvTextLogIn.setCharacterDelay(35);
                    tvTextLogIn.animateText("Ce pseudo est trop long je vais jamais pouvoir le retenir ! ");
                }
                else {
                    Intro2.currentUser.name=tvPseudo.getText().toString();
                    Intro1.numActivity++;
                    btValider.setVisibility(View.INVISIBLE);
                    btNext.setVisibility(View.VISIBLE);
                    btPrevious.setVisibility(View.VISIBLE);
                    AnimateBtBottomLeft(v,btPrevious);
                    AnimateBtBottomRight(v,btNext);
                    tvPseudo.setVisibility(View.INVISIBLE);
                    imgAvatar1.setVisibility(View.VISIBLE);
                    imgAvatar2.setVisibility(View.VISIBLE);
                    imgAvatar3.setVisibility(View.VISIBLE);
                    imgAvatar4.setVisibility(View.VISIBLE);
                    tvTextLogIn.setText("");
                    tvTextLogIn.setCharacterDelay(35);
                    tvTextLogIn.animateText("Il est temps de te choisir un avatar stylé maintenant ! ");


                }
            }
        });


        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(avatarSelect!=0) {
                    moveToMain();

                }
                else{
                    tvTextLogIn.setText("");
                    tvTextLogIn.setCharacterDelay(35);
                    tvTextLogIn.animateText("Choisis un avatar avant de valider ! ");
                }

            }
        });
        btPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btBack();
            }
        });

    }


    @Override
    public void onBackPressed() {
        btBack();
    }
    public void moveToMain(){
        Intent intent =new Intent(Intro2.this,MainActivity.class);
        startActivity(intent);
    }


    public void AnimateBtBottomRight(View view,Button bt){
        Animation tobottomright = AnimationUtils.loadAnimation(this, R.anim.tobottomright);
        btNext.startAnimation(tobottomright);

    }

    public void AnimateBtBottomLeft(View view,Button bt){
        Animation tobottomright = AnimationUtils.loadAnimation(this, R.anim.fromtoptobottomleft);
        btPrevious.startAnimation(tobottomright);
    }
    private float getScreenHeight() {

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return (float) displaymetrics.heightPixels;

    }
    public void btBack(){
        if(Intro1.numActivity==3){
            Intro1.numActivity--;
            Intent intent = getIntent();
            finish();
            startActivity(intent);

        }
        else{
            Intro1.numActivity--;
            this.finish();
        }
    }
    public void onStop() {

        db.SaveUser(currentUser);
        super.onStop();
    }
}

