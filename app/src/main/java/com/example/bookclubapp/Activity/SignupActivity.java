package com.example.bookclubapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.bookclubapp.R;
import com.example.bookclubapp.databinding.ActivitySignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import java.net.Authenticator;

public class SignupActivity extends BaseActivity {
    ActivitySignupBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setVariable();
    }
    protected void setVariable(){
        binding.BtnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Mail = binding.Username.getText().toString();
                String Password = binding.Password.getText().toString();

                if (Password.length()<8){
                    Toast.makeText(SignupActivity.this, "Your Password must be 8 Characters or more",Toast.LENGTH_SHORT).show();
                    return;
                }
                Mauth.createUserWithEmailAndPassword(Mail,Password).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.i(TAG,"onComplete: ");
                            startActivity(new Intent(SignupActivity.this,MainActivity.class));

                        }else {
                            Log.i(TAG,"Failure: "+task.getException());
                            Toast.makeText(SignupActivity.this, "Authentication Failed",Toast.LENGTH_SHORT).show();;

                        }

                    }
                });
            }
        });

    }
}