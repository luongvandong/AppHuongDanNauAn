package com.example.dongpc.apphuongdannauan.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dongpc.apphuongdannauan.R;
import com.example.dongpc.apphuongdannauan.adapter.AdapterThemChuDeMon;
import com.example.dongpc.apphuongdannauan.database.MyDatabase;
import com.example.dongpc.apphuongdannauan.dialog.MyDialogThemChuDe;
import com.example.dongpc.apphuongdannauan.entities.ChuDeMon;

import java.util.ArrayList;

/**
 * Created by DongPC on 4/17/2017.
 */

public class ActivityThemChuDeMon extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    public static final String KEY_MAID = "KEY_MAID";
    private ArrayList<ChuDeMon> chuDeMons;
    private AdapterThemChuDeMon adapter;
    private ListView listView;
    public MyDatabase myDatabase;
    private Button buttonThemChuDe;
    private MyDialogThemChuDe myDialogThemChuDe;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_themchudemon);
        initViews();
    }

    private void initViews() {
        myDialogThemChuDe = new MyDialogThemChuDe(this);
        myDatabase = new MyDatabase(this);
        listView = (ListView) findViewById(R.id.listviewChuDeMon);
        listView.setDividerHeight(10);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            listView.setDivider(Drawable.createFromPath(String.valueOf(getDrawable(R.drawable.draw_line))));
        }
        buttonThemChuDe = (Button) findViewById(R.id.bt_themchude);
        buttonThemChuDe.setOnClickListener(this);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
        registerForContextMenu(listView);
        updateData();

    }

    private void updateData() {
        chuDeMons = myDatabase.getChuDeMon();
        adapter = new AdapterThemChuDeMon(chuDeMons, this);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_themchude:
                myDialogThemChuDe.show();
                showDialogThemChuDe();


                break;
        }
    }

    private void showDialogThemChuDe() {
        myDialogThemChuDe.setCallBack(new MyDialogThemChuDe.CallBack() {
            @Override
            public void finish(String result) {
                myDatabase.insertNameChuDeMon(new ChuDeMon(result));
                chuDeMons = myDatabase.getChuDeMon();
                adapter = new AdapterThemChuDeMon(chuDeMons, ActivityThemChuDeMon.this);
                adapter.notifyDataSetChanged();
                listView.setAdapter(adapter);
                Toast.makeText(ActivityThemChuDeMon.this, "Them Thanh Cong", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_context_menu, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.xoa:
                break;
            case R.id.cancel:
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ChuDeMon chuDeMon = chuDeMons.get(position);
        int maId = chuDeMon.getMaChuDe();
        Intent intent = new Intent(ActivityThemChuDeMon.this, ActivityThemMon.class);
        intent.putExtra(KEY_MAID, maId);
        startActivity(intent);

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }
}
