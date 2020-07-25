package com.example.tukyhelper.View.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tukyhelper.Model.EssenceRoom.Essence;
import com.example.tukyhelper.R;

import java.util.ArrayList;
import java.util.List;

public class EssenceRVAdapter extends RecyclerView.Adapter<EssenceRVAdapter.EssenceHolder> {

    //region variables
    private List<Essence> data = new ArrayList<>();
    private View.OnClickListener listener;

    //endregion

    //region Override extended methods
    @NonNull
    @Override
    public EssenceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EssenceHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemview_essence, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EssenceHolder holder, final int position) {
        holder.name.setText(data.get(position).getName());
        holder.ntfCount.setText(String.valueOf(data.get(position).getNftCount()));
        //holder.ibt.setImageBitmap(BitmapFactory
        //       .decodeFile(essList.get(position).getIcon()));

        holder.ibt.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    //endregion

    //region Methods
    public void setData(List<Essence> essList) {
        this.data = essList;
        notifyDataSetChanged();
    }

    public void setOnEssenceClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    //endregion

    //region Inner classes and interfaces
    class EssenceHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private ImageButton ibt;
        private TextView ntfCount;

        public EssenceHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.tv_essenceview_name);
            ibt = (ImageButton) itemView.findViewById(R.id.ibt_essenceview_icon);
            ntfCount = (TextView) itemView.findViewById(R.id.tv_essenceview_ntfcount);
        }
    }
    //endregion
}
