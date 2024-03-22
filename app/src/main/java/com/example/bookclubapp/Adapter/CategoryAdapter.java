package com.example.bookclubapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.bookclubapp.Activity.ListofbooksActivity;
import com.example.bookclubapp.Domain.Books;
import com.example.bookclubapp.Domain.Category;
import com.example.bookclubapp.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.Vievholder> {
    ArrayList<Category> items;
    Context context;

    public CategoryAdapter(ArrayList<Category> items){
        this.items=items;
    }

    @NonNull
    @Override
    public CategoryAdapter.Vievholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories,parent,false);

        return new Vievholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.Vievholder holder, int position) {

        holder.title_txt.setText(items.get(position).getName());

        switch (position){
            case 0:{
                holder.bookavatar_img.setBackgroundResource(R.drawable.best_horror_books);
                break;
            }
            case 1:{
                holder.bookavatar_img.setBackgroundResource(R.drawable.best_books_2000_acfa32d6debb4316918f130f5538a697);
                break;
            }
            case 2:{
                holder.bookavatar_img.setBackgroundResource(R.drawable.nonfiction_2021);
                break;
            }
            case 3:{
                holder.bookavatar_img.setBackgroundResource(R.drawable.memoir_and_biography_2020_2);
                break;
            }

        }
        int DRid = context.getResources().getIdentifier(items.get(position).getImagePath(),
                "drawable",holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(DRid)
                .into(holder.bookavatar_img);

        holder.itemView.setOnClickListener((View v) -> {
            Intent intent = new Intent(context, ListofbooksActivity.class);
            intent.putExtra("CategoryId",items.get(position).getId());
            intent.putExtra("CategoryName",items.get(position).getName());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    public class Vievholder extends RecyclerView.ViewHolder {
        TextView title_txt;
        ImageView bookavatar_img;
        public Vievholder(@NonNull View itemView)
        {
            super(itemView);
            title_txt=itemView.findViewById(R.id.cat_txt);
            bookavatar_img=itemView.findViewById(R.id.bookcat_img);
        }
    }
}
