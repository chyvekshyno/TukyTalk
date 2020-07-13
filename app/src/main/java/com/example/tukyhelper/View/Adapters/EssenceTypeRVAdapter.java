package com.example.tukyhelper.View.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tukyhelper.R;

public class EssenceTypeRVAdapter extends RecyclerView.Adapter<EssenceTypeRVAdapter.EssenceTypeHolder> {



    @NonNull
    @Override
    public EssenceTypeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EssenceTypeHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.essencetype_itemview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EssenceTypeHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class EssenceTypeHolder extends RecyclerView.ViewHolder{
        private ImageButton ibt_icon;
        private TextView tv_name;

        public EssenceTypeHolder(@NonNull View itemView) {
            super(itemView);

            ibt_icon = (ImageButton) itemView.findViewById(R.id.ibt_esstype);
            tv_name = (TextView) itemView.findViewById(R.id.tv_esstype_name);
        }
    };
}
