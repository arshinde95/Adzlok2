package com.example.arshinde.adzlok;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    TextView tvreg, Loginpage;
    private Button register;
    EditText etemail, etpass, etrepass;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

//        firebaseAuth = FirebaseAuth.getInstance();
//
//        progressDialog = new ProgressDialog(this);
//        etemail= (EditText) findViewById(R.id.email);
//        etpass = (EditText) findViewById(R.id.pass);
//        etrepass = (EditText) findViewById(R.id.repass);
//        register = (Button) findViewById(R.id.register);
//
//
//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                UserRegister();
//
//
//
//            }
//
//
//        });
//
//
//
//    }
//
//
//
//    private void UserRegister()
//    {
//        String email,pass,repass;
//
//        email=etemail.getText().toString();
//        pass=etpass.getText().toString();
//        repass=etrepass.getText().toString();
//        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass)){
//            Toast.makeText(RegistrationActivity.this,"some fields are empty",Toast.LENGTH_SHORT).show();
//            return;
//
//
//        }
//        progressDialog.setMessage("Registration..");
//        progressDialog.show();
//        firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if(task.isSuccessful())
//                {
//                    Toast.makeText(RegistrationActivity.this,"Registration successful",Toast.LENGTH_SHORT).show();
//                }
//                else
//                {
//                    Toast.makeText(RegistrationActivity.this,"Registration Erro",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//    }
//    public void LoginPage(View v) {
//        startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
//    }


    }
}