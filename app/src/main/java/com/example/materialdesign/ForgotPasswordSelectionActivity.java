package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class ForgotPasswordSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_forgot_password_selection);
    }

    public void callBackScreenFromMakeSelection(View view) {
        Intent intent=new Intent(ForgotPasswordSelectionActivity.this,ForgetPasswordSuccessActivity.class);
        startActivity(intent);
    }

    public void callOTPScreenFromMakeSelection(View view) {
        Intent intent=new Intent(ForgotPasswordSelectionActivity.this,ForgetPasswordSuccessActivity.class);
        startActivity(intent);
    }
}