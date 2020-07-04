package com.example.tukyhelper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.zip.Inflater;

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
    public int getCount() {
        return _essences.size();
    }

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
        return view;
    }
}
