package com.example.tukyhelper.View.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tukyhelper.Model.EssenceRoom.EssenceType;
import com.example.tukyhelper.R;

import java.util.ArrayList;
import java.util.List;

public class EssenceTypeRVAdapter extends RecyclerView.Adapter<EssenceTypeRVAdapter.EssenceTypeHolder> {

    private int lastSelectedId = -1;

    private List<EssenceType> types = new ArrayList<>();

    private List<String> typeIcons = new ArrayList<>();
    public void setData(List<EssenceType> types){
        this.types = types;
        //typeIcons = icons;
        notifyDataSetChanged();
    }

    public int getLastSelectedId() {
        return lastSelectedId;
    }

    @NonNull
    @Override
    public EssenceTypeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EssenceTypeHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemview_essencetype, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EssenceTypeHolder holder, int position) {
        holder.tv_name.setText(types.get(position).getTypeName());
        //holder.tv_name.setText(typeNames.get(position));
        //holder.rbt_icon.setButtonDrawable(R.drawable.ic_baseline_add_24);
        holder.rbt.setChecked(lastSelectedId == types.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return types.size();
    }

    class EssenceTypeHolder extends RecyclerView.ViewHolder{

        private RadioButton rbt;
        private TextView tv_name;

        public EssenceTypeHolder(@NonNull View itemView) {
            super(itemView);

            rbt = (RadioButton) itemView.findViewById(R.id.rbt_esstype);
            tv_name = (TextView) itemView.findViewById(R.id.tv_esstype_name);

            rbt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lastSelectedId = types.get(getAdapterPosition()).getId();
                    notifyDataSetChanged();
                }
            });
        }

    };
}
