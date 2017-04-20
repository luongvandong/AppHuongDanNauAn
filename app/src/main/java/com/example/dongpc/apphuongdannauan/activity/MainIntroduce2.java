package com.example.dongpc.apphuongdannauan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.dongpc.apphuongdannauan.R;
import com.example.dongpc.apphuongdannauan.adapter.IntroducePagerAdapter;
import com.example.dongpc.apphuongdannauan.entities.Introduce;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by DongPC on 4/15/2017.
 */

public class MainIntroduce2 extends AppCompatActivity {
    private ViewPager viewPager;
    private ArrayList<Introduce> introduceArrayList;
    private IntroducePagerAdapter adapter;
    private CircleIndicator indicator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_introduce2);
        initViews();
    }

    private void initViews() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        indicator = (CircleIndicator) findViewById(R.id.indicator);
        addData();
        adapter = new IntroducePagerAdapter(this, introduceArrayList);
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                if (position == viewPager.getAdapter().getCount() - 1) {
                    Intent intent = new Intent(MainIntroduce2.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addData() {
        introduceArrayList = new ArrayList<>();
        introduceArrayList.add(new Introduce(R.drawable.ic_viewpager3, "AUTHOR:DONG LUONG"));
        introduceArrayList.add(new Introduce(R.drawable.ic_viewpager2, "CẢM ƠN BẠN ĐÃ SỬ DỤNG PHẦN MỀM,CHÚC BẠN MỘT NGÀY TÔT LÀNH "));
        introduceArrayList.add(new Introduce(R.drawable.ic_viewpager1, "!!!"));
    }
}
