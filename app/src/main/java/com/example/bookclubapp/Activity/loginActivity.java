package com.example.bookclubapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bookclubapp.R;
import com.example.bookclubapp.databinding.ActivityIntroBinding;
import com.example.bookclubapp.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;


public class loginActivity extends BaseActivity {
    ActivityLoginBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setVariable();

    }

    private void setVariable() {
        binding.btnLogin.setOnClickListener(v -> {
            String Mail = binding.Username.getText().toString();
            String Password = binding.Password.getText().toString();
            if(!Mail.isEmpty() && !Password.isEmpty()){

                Mauth.createUserWithEmailAndPassword(Mail,Password).addOnCompleteListener(loginActivity.this, task -> {
                    if (task.isSuccessful()){
                        startActivity(new Intent(loginActivity.this,MainActivity.class));
                    }else {
                        Toast.makeText(loginActivity.this,"Authentication Failed",Toast.LENGTH_SHORT).show();

                    }

                });



            }else {
                Toast.makeText(loginActivity.this,"Please fill username and password",Toast.LENGTH_SHORT).show();
            }


        });
    }
}

