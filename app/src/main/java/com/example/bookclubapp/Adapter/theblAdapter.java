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

public class theblAdapter extends RecyclerView.Adapter<theblAdapter.viewholder> {
    ArrayList<Books> items;
    Context context;

    public theblAdapter(ArrayList<Books> items){
        this.items= items;
    }
    @NonNull
    @Override
    public theblAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.listofbooks_viewholder,parent,false);

        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull theblAdapter.viewholder holder, int position) {
        holder.title_txt.setText(items.get(position).getTitle());
        holder.rate_txt.setText(""+items.get(position).getStar());
    holder.Author_txt.setText("By:"+items.get(position).getAuthor());

        Glide.with(context)
                .load(items.get(position).getImagePath())
                .transform(new CenterCrop(),new RoundedCorners(30))
                .into(holder.img_booklist);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class viewholder extends RecyclerView.ViewHolder {
        TextView title_txt,rate_txt,Author_txt;
        ImageView img_booklist;
        public viewholder(@NonNull View itemView){
            super(itemView);

            title_txt=itemView.findViewById(R.id.title_txt);
            rate_txt=itemView.findViewById(R.id.rate_txt);
            Author_txt = itemView.findViewById(R.id.authorlistofbooks_txt);
            img_booklist = itemView.findViewById(R.id.img_listofbooks);
        }
    }

}
