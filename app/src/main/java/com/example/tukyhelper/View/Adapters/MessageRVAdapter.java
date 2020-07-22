package com.example.tukyhelper.View.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tukyhelper.R;

import java.util.ArrayList;
import java.util.List;

public class MessageRVAdapter extends RecyclerView.Adapter<MessageRVAdapter.MessageHolder> {

    List<String> messages = new ArrayList<>();

    @NonNull
    @Override
    public MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MessageHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_itemview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MessageHolder holder, int position) {
        holder.tv_text.setText(messages.get(position));
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    static class MessageHolder extends RecyclerView.ViewHolder{

        TextView tv_text;

        public MessageHolder(@NonNull View itemView) {
            super(itemView);
            tv_text = (TextView) itemView.findViewById(R.id.tv_msg_text);
        }
    }
}
