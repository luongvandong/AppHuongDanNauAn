package com.example.dongpc.apphuongdannauan.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dongpc.apphuongdannauan.entities.Introduce;
import com.example.dongpc.apphuongdannauan.R;

import java.util.ArrayList;

/**
 * Created by DongPC on 4/15/2017.
 */

public class IntroducePagerAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<Introduce> introduceArrayList;
    private LayoutInflater layoutInflater;

    public IntroducePagerAdapter(Context context, ArrayList<Introduce> introduceArrayList) {
        this.context = context;
        this.introduceArrayList = introduceArrayList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return introduceArrayList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object.equals(view);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.item_view_introduce2, container, false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linear_introduce2);
        TextView textView = (TextView) view.findViewById(R.id.tv_name);
        Introduce introduce = introduceArrayList.get(position);
        linearLayout.setBackgroundResource(introduce.getImageScreen());
        textView.setText(introduce.getName());
        /*Animation animation = AnimationUtils.loadAnimation(context, R.anim.animation_scalefromsmall);
        textView.startAnimation(animation);*/
        textView.setSelected(true);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
