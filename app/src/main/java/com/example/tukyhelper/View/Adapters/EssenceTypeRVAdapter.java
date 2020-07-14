package com.example.tukyhelper.View.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tukyhelper.Model.EssenceRoom.EssenceType;
import com.example.tukyhelper.R;

import java.util.ArrayList;
import java.util.List;

public class EssenceTypeRVAdapter extends RecyclerView.Adapter<EssenceTypeRVAdapter.EssenceTypeHolder> {

    private List<EssenceType> types = new ArrayList<>();
    private List<String> typeIcons = new ArrayList<>();

    public void setData(List<EssenceType> types){
        this.types = types;
        //typeIcons = icons;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EssenceTypeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EssenceTypeHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.essencetype_itemview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EssenceTypeHolder holder, int position) {
        holder.tv_name.setText(types.get(position).getTypeName());
        //holder.tv_name.setText(typeNames.get(position));
    }



    @Override
    public int getItemCount() {
        return types.size();
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
