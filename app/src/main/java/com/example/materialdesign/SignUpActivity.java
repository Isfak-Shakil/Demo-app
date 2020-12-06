package com.example.materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {
    private Button signUpBtn,loginBtn;
    private TextInputLayout userNameEt,phoneEt,addressEt,emailEt,passwordEt;

    private FirebaseDatabase rootNode;
    private DatabaseReference reference;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        userNameEt=findViewById(R.id.userNameId);
        phoneEt=findViewById(R.id.phoneId);
       addressEt=findViewById(R.id.addressId);
       emailEt=findViewById(R.id.emailId);
       passwordEt=findViewById(R.id.passWordId);

       signUpBtn=findViewById(R.id.signUpBtnId);
        loginBtn=findViewById(R.id.loginBtnId);

        rootNode=FirebaseDatabase.getInstance();
        reference=rootNode.getReference("users");


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
                finish();
            }
        });


        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputData();

            }
        });

    }
private  String name,phone, address, email, password;
    private void inputData() {
        name =userNameEt.getEditText().getText().toString().trim();
        phone  =phoneEt.getEditText().getText().toString().trim();
        address=addressEt.getEditText().getText().toString().trim();
        email =emailEt.getEditText().getText().toString().trim();
        password =passwordEt.getEditText().getText().toString().trim();

        if (TextUtils.isEmpty(name)){
           userNameEt.setError("Enter Your Full Name.");
        }else {
           userNameEt.setError(null);
        }


        if (TextUtils.isEmpty(phone)){
            phoneEt.setError("Enter Your Valid Phone Number.");
        }else {
            phoneEt.setError(null);
        }
        if (TextUtils.isEmpty(address)){
            addressEt.setError("Enter Your Valid Address.");
        }else {
            addressEt.setError(null);
        }


        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
          emailEt.setError("Enter Your Valid Email");
        }
        else { emailEt.setError(null);}
        if (password.length()<=6){
          passwordEt.setError("Password is too short");
        }else {
            passwordEt.setError(null);
        }
       

        registerUser();
    }

    private void registerUser() {

             //UserHelper helper=new UserHelper(name,phone,address,email,password);
            HashMap<String,Object> hashMap=new HashMap<>();
            hashMap.put("Name",name);
            hashMap.put("Phone",phone);
            hashMap.put("Address",address);
            hashMap.put("Email",email);
            hashMap.put("Password",password);

             reference.child(phone).setValue(hashMap)
                     .addOnSuccessListener(new OnSuccessListener<Void>() {
                 @Override
                 public void onSuccess(Void aVoid) {

                     startActivity(new Intent(SignUpActivity.this,UserProfileActivity.class));
                     finish();
                 }
             }).addOnFailureListener(new OnFailureListener() {
                 @Override
                 public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SignUpActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    finish();
                 }
             });

        }
}