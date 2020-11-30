package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView quizIv;
    private TextView mainTv,poweredTv;
    private Animation top_anim,bottom_anim,side_anim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        quizIv=findViewById(R.id.quiz);
        mainTv=findViewById(R.id.mainText);
        poweredTv=findViewById(R.id.poweredTextId);

        top_anim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom_anim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        side_anim= AnimationUtils.loadAnimation(this,R.anim.side_animation);

        quizIv.setAnimation(side_anim);
        mainTv.setAnimation(bottom_anim);
        poweredTv.setAnimation(top_anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
             Intent intent= new Intent (MainActivity.this,DashBoardActivity.class);
          //   Intent intent= new Intent (MainActivity.this,LoginActivity.class);
                Pair[] pairs=new Pair[2];
                pairs[0]=new Pair<View,String>(quizIv,"logo_image");
                pairs[1]=new Pair<View,String>(mainTv,"main_text");
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                    startActivity(intent,options.toBundle());
                    finish();
                }
            }
        },3000);

    }
}