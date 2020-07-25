package com.example.tukyhelper.View.Adapters;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tukyhelper.Model.EssenceRoom.Essence;
import com.example.tukyhelper.Model.ParamRoom.EssenceParam;
import com.example.tukyhelper.Model.ParamRoom.EssenceParamWord;
import com.example.tukyhelper.R;

import java.util.ArrayList;
import java.util.List;

public class ParamRVAdapter extends RecyclerView.Adapter<ParamRVAdapter.ParamHolder> {

    List<EssenceParam> params = new ArrayList<>();          //  ordered by param_id
    List<EssenceParamWord> paramDic = new ArrayList<>();    //  ordered by order

    //region Override
    @NonNull
    @Override
    public ParamHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ParamHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemview_param, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ParamHolder holder, int position) {
        Log.d("PARAM BINDING NAME", paramDic.get(position).getParamName());
        Log.d("PARAM BINDING VALUE", getParamByParamId(paramDic.get(position).getId()).getValue());

        holder.tv_parameter.setText(paramDic.get(position).getParamName());
        holder.tv_value.setText(getParamByParamId(paramDic.get(position).getId()).getValue());
    }

    @Override
    public int getItemCount() {
        return params.size();
    }
    //endregion

    //region additional methods

    EssenceParam getParamByParamId(int id){
        for ( EssenceParam param : params ){
            if (param.getParamId() == id) {
                return param;
            }
        }
        return null;
    }

    public void setParams(List<EssenceParam> params){
        this.params = params;
        notifyDataSetChanged();
    }

    ///  paramDic need being ordered by params order field
    public void setParamDic(List<EssenceParamWord> paramDic) {
        this.paramDic = paramDic;
        notifyDataSetChanged();
    }

    //endregion

    //region Inner classes
    class ParamHolder extends RecyclerView.ViewHolder{
        TextView tv_parameter;
        TextView tv_value;

        public ParamHolder(@NonNull View itemView) {
            super(itemView);

            tv_parameter = (TextView) itemView.findViewById(R.id.tv_param_name);
            tv_value = (TextView) itemView.findViewById(R.id.tv_param_value);
        }
    }

    //endregion
}
