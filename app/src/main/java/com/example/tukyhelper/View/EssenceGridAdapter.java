package com.example.tukyhelper.View;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.tukyhelper.Model.EssenceRoom.Essence;
import com.example.tukyhelper.R;

import java.util.ArrayList;

public class EssenceGridAdapter extends BaseAdapter
{
    private Context _ctx;
    private ArrayList<Essence> _essences;
    private LayoutInflater _inflater;

    public EssenceGridAdapter(Context ctx, ArrayList<Essence> essences) {
        super();
        _ctx = ctx;
        _essences = essences;
        _inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() { return _essences.size(); }

    @Override
    public Object getItem(int position) {
        return _essences.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView == null ? _inflater.inflate(R.layout.essence_grid_item, null) : convertView;
        ImageButton btn = (ImageButton) view.findViewById(R.id.btn_essence_icon);
        TextView tv_name = (TextView) view.findViewById(R.id.tv_essence_name);
        //TextView tv_ntfcount = (TextView) view.findViewById(R.id.tv_essence_ntfcount);

        //btn.setImageBitmap(BitmapFactory.decodeFile(_essences.get(position).icon()));
        tv_name.setText(_essences.get(position).getName());
        return view;
    }
}
