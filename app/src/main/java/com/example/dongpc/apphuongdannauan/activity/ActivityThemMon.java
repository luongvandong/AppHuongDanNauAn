package com.example.dongpc.apphuongdannauan.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.dongpc.apphuongdannauan.R;
import com.example.dongpc.apphuongdannauan.adapter.AdapterThemMonMoi;
import com.example.dongpc.apphuongdannauan.entities.MonMoi;

import java.util.ArrayList;

/**
 * Created by DongPC on 4/18/2017.
 */

public class ActivityThemMon extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<MonMoi> monMois;
    private AdapterThemMonMoi adapterThemMonMoi;
    private ListView listViewThemMonMoi;
    private Button buttonThemMonAn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_themmon);
        initViews();
    }

    private void initViews() {
        listViewThemMonMoi = (ListView) findViewById(R.id.listviewThemMonAn);
        buttonThemMonAn = (Button) findViewById(R.id.bt_themmonan);
        buttonThemMonAn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_themmonan:
                break;
        }
    }
}
