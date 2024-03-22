package com.example.bookclubapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.bookclubapp.R;
import com.example.bookclubapp.databinding.ActivityIntroBinding;

public class IntroActivity extends BaseActivity {
    ActivityIntroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setVariable();
        getWindow().setStatusBarColor(Color.parseColor("#1B1B1B"));
    }
    protected void setVariable(){
        binding.BtnMember.setOnClickListener(v -> {

            if(Mauth.getCurrentUser()!=null){
                startActivity(new Intent(IntroActivity.this,MainActivity.class));

            }else {
                startActivity(new Intent(IntroActivity.this,loginActivity.class));


            }

        });

        binding.BtnJoin.setOnClickListener(v -> startActivity(new Intent(IntroActivity.this,SignupActivity.class)));


    }
}