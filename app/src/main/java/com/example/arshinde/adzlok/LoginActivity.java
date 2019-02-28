package com.example.arshinde.adzlok;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    final String TAG = this.getClass().getName().toString();
    private FirebaseAuth mAuth;
    Button btnLogin;
    EditText etemail,etpass;
    TextView notacc;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin=(Button)findViewById(R.id.login);
        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignIn();


            }
        });

    }




    private void SignIn() {
        final String email, pass;
        email = etemail.getText().toString();
        pass = etpass.getText().toString();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(LoginActivity.this, "enter email id", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pass))
        {
            Toast.makeText(LoginActivity.this,"enter password",Toast.LENGTH_SHORT).show();
            return;
        }
        firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(LoginActivity.this,"Welcome "+email,Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Welcome "+email,Toast.LENGTH_SHORT).show();
                }
            }
        });




    }


    public void LoginPage(View view) {

        startActivity(new Intent(LoginActivity.this,RegistrationActivity.class));
    }

    public void ForgotPass(View view)
    {
        startActivity(new Intent(LoginActivity.this,forgot_passActivity.class));
    }




}
