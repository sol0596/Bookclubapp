package com.example.bookclubapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Message;
import android.view.View;

import com.example.bookclubapp.Adapter.GlobalChatAdapter;
import com.example.bookclubapp.R;
import com.example.bookclubapp.databinding.ActivityGlobalchatBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class globalchat extends BaseActivity {
    ActivityGlobalchatBinding binding;
    GlobalChatAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<Message> list;
    TextInputLayout message;
    DatabaseReference db;
    FloatingActionButton send;
    FirebaseAuth auth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_globalchat);
        send = findViewById(R.id.fab_send);
        message = findViewById(R.id.message);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance().getReference();
        user = auth.getCurrentUser();
        String Uid = user.getUid();
        String uEmail = user.getEmail();



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = message.getEditText().getText().toString();
                String dateTime = "12:00 AM";
                db.child("Messages").push().setValue(new Message()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {


                    }
                });

            }
        });
    }
}