package com.example.tukyhelper.View.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tukyhelper.Model.EssenceRoom.Essence;
import com.example.tukyhelper.R;

import java.util.ArrayList;
import java.util.List;

public class EssenceRVAdapter extends RecyclerView.Adapter<EssenceRVAdapter.EssenceHolder> {

    private List<Essence> essList = new ArrayList<>();


    static class EssenceHolder extends RecyclerView.ViewHolder{
        private TextView name;
        //private ImageButton icon_btn;
        private TextView ntfCount;

        public EssenceHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.tv_essence_name);
            //icon_btn = itemView.findViewById(R.id.btn_essence_icon);
            ntfCount = (TextView) itemView.findViewById(R.id.tv_essence_ntfcount);
        }
    }

    @NonNull
    @Override
    public EssenceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EssenceHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.essence_itemview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EssenceHolder holder, int position) {
        holder.name.setText(essList.get(position).getName());
        holder.ntfCount.setText(String.valueOf(essList.get(position).getNftCount()));
        //holder.icon_btn.setImageBitmap(BitmapFactory
        //       .decodeFile(essList.get(position).getIcon()));
    }

    @Override
    public int getItemCount() {
        return essList.size();
    }

    public void setData(List<Essence> essList) {
        this.essList = essList;
        notifyDataSetChanged();
    }
}
