package com.example.materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    private Button loginBtn,signUpBtn;
    private TextInputLayout username,password;
    private TextView mainText,sloganText;
    private ImageView logoImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        logoImage=findViewById(R.id.logoImageId);
        mainText=findViewById(R.id.mainTextId);
        sloganText=findViewById(R.id.sloganTextId);
        username=findViewById(R.id.userNameId);
        password=findViewById(R.id.passWordId);
        loginBtn=findViewById(R.id.loginBtnId);
        signUpBtn=findViewById(R.id.singUpId);

       

       signUpBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent= new Intent (LoginActivity.this,SignUpActivity.class);
               Pair[] pairs=new Pair[7];
               pairs[0]=new Pair<View,String>(logoImage,"logo_image");
               pairs[1]=new Pair<View,String>(mainText,"main_text");
               pairs[2]=new Pair<View,String>(sloganText,"slogan_text");
               pairs[3]=new Pair<View,String>(username,"username_text");
               pairs[4]=new Pair<View,String>(password,"password_text");
               pairs[5]=new Pair<View,String>(loginBtn,"login_text");
               pairs[6]=new Pair<View,String>(signUpBtn,"signUp_text");
               if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                   ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);
                   startActivity(intent, options.toBundle());
                   finish();
               }
           }
       });



    }
}

