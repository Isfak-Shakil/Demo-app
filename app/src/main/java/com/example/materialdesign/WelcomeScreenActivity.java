package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;

public class WelcomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome_screen);
    }

    public void callingLogingScreen(View view) {
        Intent intent=new Intent(WelcomeScreenActivity.this,NewMaterialLoginScreen.class);
        Pair[] pairs=new Pair[1];
        pairs[0]=new Pair<View,String>(findViewById(R.id.loginNewId),"transition_login");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(WelcomeScreenActivity.this, pairs);
            startActivity(intent, options.toBundle());

        }else {
            startActivity(intent);
        }
    }

    public void callingSignUpScreen(View view) {
    }
}