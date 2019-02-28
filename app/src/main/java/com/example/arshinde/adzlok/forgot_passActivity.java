package com.example.arshinde.adzlok;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgot_passActivity extends AppCompatActivity {

EditText email;
Button submit;
FirebaseAuth firebaseAuth;
//Toolbar toolbar;
ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);
       // toolbar=(Toolbar)findViewById(R.id.toolbar);
        progressBar=(ProgressBar)findViewById(R.id.progress);
        email=(EditText)findViewById(R.id.email);
        submit=(Button)findViewById(R.id.forgotpass);

        //toolbar.setTitle("Fogot Password");
        firebaseAuth=FirebaseAuth.getInstance();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.sendPasswordResetEmail(email.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressBar.setVisibility(View.GONE);

                        if(task.isSuccessful()){
                            Toast.makeText(forgot_passActivity.this,"password send to your email",Toast.LENGTH_LONG).show();

                        }
                        else {
                            Toast.makeText(forgot_passActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }

                    }
                });
            }
        });





    }
}
