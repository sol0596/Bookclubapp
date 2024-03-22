package com.example.bookclubapp.Activity;



import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookclubapp.Adapter.BestSellerAdapter;
import com.example.bookclubapp.Adapter.CategoryAdapter;
import com.example.bookclubapp.Domain.Books;
import com.example.bookclubapp.Domain.Category;
import com.example.bookclubapp.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import  com.example.bookclubapp.Domain.Books.*;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends BaseActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        initBestSeller();
        initCatergory();
        setVariable();
    }

    private void setVariable() {
        binding.btnSignout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(MainActivity.this,loginActivity.class));
        });
        binding.btnSearch.setOnClickListener(v -> {
            String text = binding.searchtextTxt.getText().toString();
            if(!text.isEmpty()){
                Intent intent =new Intent(MainActivity.this, ListofbooksActivity.class);
                intent.putExtra("",text);
                intent.putExtra("searchVali",true);
                startActivity(intent);
            }
        });
    }

    private void initBestSeller() {
        DatabaseReference myRef=Data.getReference("Books");
        binding.pgbTopbooks.setVisibility(View.VISIBLE);
        ArrayList<Books> list= new ArrayList<>();
        Query query = myRef.orderByChild("BestSellers").equalTo(true);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    for (DataSnapshot issue:snapshot.getChildren()){
                        list.add(issue.getValue(Books.class));

                    }
                    if (list.size()>0){
                        binding.rvView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
                        RecyclerView.Adapter adapter=new BestSellerAdapter(list);
                        binding.rvView.setAdapter(adapter);
                    }
                    binding.pgbTopbooks.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void initCatergory() {
        DatabaseReference myRef=Data.getReference("Category");
        binding.pgbCategory.setVisibility(View.VISIBLE);
        ArrayList<Category> list= new ArrayList<>();

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    for (DataSnapshot issue:snapshot.getChildren()){
                        list.add(issue.getValue(Category.class));

                    }
                    if (list.size()>0){
                        binding.rvCatergory.setLayoutManager(new GridLayoutManager(MainActivity.this, 4));
                        RecyclerView.Adapter adapter=new CategoryAdapter(list);
                        binding.rvCatergory.setAdapter(adapter);
                    }
                    binding.pgbCategory.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}