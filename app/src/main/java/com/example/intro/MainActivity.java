package com.example.intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.pm.ActivityInfo;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    LinearLayout layoutAttack;
    static int  gold =0;
    private TextView tvGold;
    private Button btArmy1;
    private Button btArmy2;
    private Button btArmy3;
    private Button btArmy4;
    private Button btArmy5;
    private Button btArmy6;
    private Button btArmy7;
    private Button btArmy8;


    static Army currentUserArmy;
    HashMap<String, Army> dic_Army = new HashMap<String, Army>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);



        layoutAttack=findViewById(R.id.layoutAttack);
        btArmy1=findViewById(R.id.btArmy1);
        btArmy2=findViewById(R.id.btArmy2);
        btArmy3=findViewById(R.id.btArmy3);
        btArmy4=findViewById(R.id.btArmy4);
        btArmy5=findViewById(R.id.btArmy5);
        btArmy6=findViewById(R.id.btArmy6);
        btArmy7=findViewById(R.id.btArmy7);
        btArmy8=findViewById(R.id.btArmy8);


        tvGold=findViewById(R.id.tvGold);
        tvGold.setText("  Gold : "+String.valueOf(gold)+"  ");


        btArmy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addImg(btArmy1);
            }
        });
        btArmy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addImg(btArmy2);
            }
        });
        btArmy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addImg(btArmy3);
            }
        });
        btArmy4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addImg(btArmy4);
            }
        });
        btArmy5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addImg(btArmy5);
            }
        });
        btArmy6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addImg(btArmy6);
            }
        });
        btArmy7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addImg(btArmy7);
            }
        });
        btArmy8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addImg(btArmy8);
            }
        });
        dic_Army.put("Monster1",new Army("Monster1","larvezouple_foreground",20,2000,50,50,100,1,10,0));
        dic_Army.put("Monster2",new Army("Monster2","fantomozouple_foreground",100,1000,100,200,100,1.5,10,0));
        dic_Army.put("Monster3",new Army("Monster3","sorciozouple_foreground",500,1000,100,120,150,2,10,0));
        dic_Army.put("Monster4",new Army("Monster4","canardchemine_foreground",50,2000,200,250,250,2,10,0));
        dic_Army.put("Monster5",new Army("Monster5","alienzouple_foreground",400,2500,150,400,500,3.5,10,0));
        dic_Army.put("Monster6",new Army("Monster6","hyppozouple_foreground",70,5000,200,200,750,4,10,0));
        dic_Army.put("Monster7",new Army("Monster7","extraterrestrezouple_foreground",600,3500,200,800,1000,5.5,10,0));
        dic_Army.put("Monster8",new Army("Monster8","kirbyzouple_foreground",40,15000,1000,100,1500,10,10,0));


        myHandler = new Handler();
        myHandler.postDelayed(myRunnable,200); // on redemande toute les 500ms



    }
    private Handler myHandler;


    private Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            // Code à éxécuter de façon périodique
            gold++;
            tvGold.setText("  Gold : "+String.valueOf(gold)+"  ");
            myHandler.postDelayed(this,200);
        }
    };


    public void onPause() {
        super.onPause();
        if(myHandler != null)
            myHandler.removeCallbacks(myRunnable); // On arrete le callback
    }
    public  void setImgParam(ImageView img,int width,int height){
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(width,height);
        layoutParams.setMargins(0,550,0,0);

        img.setLayoutParams(layoutParams);
        layoutAttack.addView(img);

    }
    public void addImg(Button bt){
        ImageView imageView= new ImageView(MainActivity.this);
        //int id= getResources().getIdentifier(btArmy1.getForeground().toString(),"mipmap",getPackageName());
        int id= getResources().getIdentifier(bt.getTag().toString(),"mipmap",getPackageName());
        if(id<=0)
            return;
        imageView.setImageResource(id);
        setImgParam(imageView,200,200);
    }

}
