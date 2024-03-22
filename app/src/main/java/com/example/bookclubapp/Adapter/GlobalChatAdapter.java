package com.example.bookclubapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookclubapp.Domain.Message;
import com.example.bookclubapp.R;

import java.util.ArrayList;

import kotlin.coroutines.AbstractCoroutineContextElement;

public class GlobalChatAdapter extends RecyclerView.Adapter<GlobalChatAdapter.viewholder> {
    private Context context;
    private ArrayList<Message> list;

    public GlobalChatAdapter(Context context, ArrayList<Message> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public GlobalChatAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.message_design,parent,false);
        return new viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull GlobalChatAdapter.viewholder holder, int position) {
        holder.username.setText(list.get(position).getUserEmail());
        holder.message.setText(list.get(position).getMessage());
        holder.dateTime.setText(list.get(position).getDateTime());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView username,message,dateTime;
        public viewholder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.user_email);
            message = itemView.findViewById(R.id.user_message);
            dateTime = itemView.findViewById(R.id.user_date_message_time);

        }
    }
}
