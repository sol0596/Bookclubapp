package com.example.bookclubapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;

import com.example.bookclubapp.Adapter.theblAdapter;
import com.example.bookclubapp.Domain.Books;
import com.example.bookclubapp.R;
import com.example.bookclubapp.databinding.ActivityListofbooksBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.security.SecureRandom;
import java.util.ArrayList;

public class ListofbooksActivity extends BaseActivity {
    ActivityListofbooksBinding binding;
    private RecyclerView.Adapter adapterListBooks;
    private int CategoryId;
    private String categoryName;
    private String searchText;
    private boolean searchVali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListofbooksBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        
        initList();
        getIntentExtra();
        setVariable();

    }

    private void setVariable() {
    }

    private void initList() {
        DatabaseReference myRef= Data.getReference("Books");
        binding.progressBar2.setVisibility(View.VISIBLE);
        ArrayList<Books> list=new ArrayList<>();

        Query query;
        if(searchVali){
            query=myRef.orderByChild("title").startAt(searchText).endAt(searchText+"\uf8ff");
        }
        else
        {
            query=myRef.orderByChild("CategoryId").equalTo(CategoryId);
        }
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot issue : snapshot.getChildren()){
                        list.add(issue.getValue(Books.class));
                    }
                    if (list.size()>0){
                        binding.RvBooklist.setLayoutManager(new GridLayoutManager(ListofbooksActivity.this,2));
                        adapterListBooks=new theblAdapter(list);
                        binding.RvBooklist.setAdapter(adapterListBooks);

                    }
                    binding.progressBar2.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getIntentExtra() {
        CategoryId=getIntent().getIntExtra("CategoryId",0);
        categoryName=getIntent().getStringExtra("CategoryName");
        searchText=getIntent().getStringExtra("text");
        searchVali=getIntent().getBooleanExtra("searchVali",false);


        binding.titleTxt.setText(categoryName);
        binding.backBtn.setOnClickListener(v -> finish());
    }
}