package com.example.dongpc.apphuongdannauan.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dongpc.apphuongdannauan.R;
import com.example.dongpc.apphuongdannauan.entities.ChuDeMon;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by DongPC on 4/17/2017.
 */

public class AdapterThemChuDeMon extends BaseAdapter {
    private ArrayList<ChuDeMon> chuDeMons;
    private Context context;
    private LayoutInflater layoutInflater;
    private Animation animation;

    public AdapterThemChuDeMon(ArrayList<ChuDeMon> chuDeMons, Context context) {
        this.chuDeMons = chuDeMons;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return chuDeMons.size();
    }

    @Override
    public ChuDeMon getItem(int position) {
        return chuDeMons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        animation = AnimationUtils.loadAnimation(context, R.anim.scale_itemview_chudemon);
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_view_chudemon, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageViewAnh = (ImageView) convertView.findViewById(R.id.img_anh);
            viewHolder.textViewName = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(viewHolder);

        } else
            viewHolder = (ViewHolder) convertView.getTag();
        ChuDeMon chuDeMon = chuDeMons.get(position);
        viewHolder.textViewName.setText(chuDeMon.getTenChuDe());
      /*  byte[] b = chuDeMon.getHinhAnhChuDe();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(b);
        Bitmap bitmap = BitmapFactory.decodeStream(byteArrayInputStream);
        viewHolder.imageViewAnh.setImageBitmap(bitmap);*/
        convertView.startAnimation(animation);
        if (position % 4 == 0) {
            convertView.setBackgroundColor(ContextCompat.getColor(context, R.color.red_A200));

        } else if (position % 4 == 1) {
            convertView.setBackgroundColor(ContextCompat.getColor(context, R.color.green_400));
        } else if (position % 4 == 2) {
            convertView.setBackgroundColor(ContextCompat.getColor(context, R.color.lime_A100));
        } else
            convertView.setBackgroundColor(ContextCompat.getColor(context, R.color.teal_A700));

        return convertView;
    }

    public class ViewHolder

    {
        ImageView imageViewAnh;
        TextView textViewName;
    }

}
