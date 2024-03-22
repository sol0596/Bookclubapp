package com.example.bookclubapp.Adapter;

import android.content.Context;
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
import com.example.bookclubapp.Domain.Books;
import com.example.bookclubapp.R;

import java.util.ArrayList;

public class BestSellerAdapter extends RecyclerView.Adapter<BestSellerAdapter.viewholder> {
    ArrayList<Books> items;
    Context context;

    public BestSellerAdapter(ArrayList<Books> items){
        this.items=items;
    }

    @NonNull
    @Override
    public BestSellerAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.bestseller_layout,parent,false);

        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull BestSellerAdapter.viewholder holder, int position) {
        holder.title_txt.setText(items.get(position).getTitle());
        holder.star_txt.setText(""+items.get(position).getStar());
        holder.Author_txt.setText("By: "+items.get(position).getAuthor());

        Glide.with(context)
                .load(items.get(position).getImagePath())
                .transform(new CenterCrop(),new RoundedCorners(30))
                .into(holder.bookavatar_img);

    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView title_txt,star_txt,Author_txt;
        ImageView bookavatar_img;
        public viewholder(@NonNull View itemView)
        {
            super(itemView);
            title_txt=itemView.findViewById(R.id.title_txt);
            star_txt=itemView.findViewById(R.id.star_txt);
            Author_txt=itemView.findViewById(R.id.authorlistofbooks_txt);
            bookavatar_img=itemView.findViewById(R.id.bookavatar_img);
        }
    }
}
