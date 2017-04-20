package com.example.dongpc.apphuongdannauan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.dongpc.apphuongdannauan.R;
import com.example.dongpc.apphuongdannauan.entities.ChuDeMon;
import com.example.dongpc.apphuongdannauan.database.MyDatabase;

import java.util.ArrayList;

/**
 * Created by DongPC on 4/15/2017.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<ChuDeMon> chuDeMons;
    private Button buttonChuDeMon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        initViews();

    }

    private void initViews() {
        buttonChuDeMon = (Button) findViewById(R.id.bt_chudemon);
        buttonChuDeMon.setOnClickListener(this);

      /*  myDatabase.insertChuDeMon(new ChuDeMon(1,"thit","hghgu"));*/



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_chudemon:
                Intent intent = new Intent(MainActivity.this, ActivityThemChuDeMon.class);
                startActivity(intent);
                break;
        }

    }
}
