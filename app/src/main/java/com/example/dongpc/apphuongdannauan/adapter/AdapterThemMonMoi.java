package com.example.dongpc.apphuongdannauan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dongpc.apphuongdannauan.R;
import com.example.dongpc.apphuongdannauan.entities.MonMoi;

import java.util.ArrayList;

/**
 * Created by DongPC on 4/18/2017.
 */

public class AdapterThemMonMoi extends BaseAdapter {
    private ArrayList<MonMoi> monMois;
    private Context context;
    private LayoutInflater layoutInflater;

    public AdapterThemMonMoi(ArrayList<MonMoi> monMois, Context context) {
        this.monMois = monMois;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return monMois.size();
    }

    @Override
    public MonMoi getItem(int position) {
        return monMois.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.item_view_themmonmoi, parent, false);
            viewHolder.textViewName = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.textViewTime = (TextView) convertView.findViewById(R.id.tv_time);
            convertView.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) convertView.getTag();
        MonMoi monMoi = monMois.get(position);
        viewHolder.textViewName.setText(monMoi.getTenMon());
        viewHolder.textViewTime.setText(monMoi.getNgayLap());

        return convertView;
    }

    public class ViewHolder {
        TextView textViewName;
        TextView textViewTime;
    }
}
