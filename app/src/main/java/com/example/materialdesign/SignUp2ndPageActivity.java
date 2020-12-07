package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SignUp2ndPageActivity extends AppCompatActivity {
    private ImageView backBtn;
    private TextView title;
    private Button next,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up2nd_page);
        backBtn=findViewById(R.id.signUp_backBtn);
        title=findViewById(R.id.signUp_title_text);
        next=findViewById(R.id.signUp_next_Btn);
        login=findViewById(R.id.signUp_login_Btn);
        ;
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    public void callingNextSignUpPage(View view) {
        Intent intent= new Intent(getApplicationContext(),SignUp3rdAcitvity.class);

        Pair[] pairs= new Pair[4];
        pairs[0]=new Pair<View,String>(backBtn,"transition_back_Btn");
        pairs[1]=new Pair<View,String>(title,"transition_back_Btn");
        pairs[2]=new Pair<View,String>(next,"transition_next_Btn");
        pairs[3]=new Pair<View,String>(login,"transition_login_Btn");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp2ndPageActivity.this, pairs);
            startActivity(intent, options.toBundle());

        }
        else {
            startActivity(intent);
        }
    }
}