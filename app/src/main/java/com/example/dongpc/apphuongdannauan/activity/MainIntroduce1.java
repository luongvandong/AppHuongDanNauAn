package com.example.dongpc.apphuongdannauan.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.dongpc.apphuongdannauan.dialog.MyDialog;
import com.example.dongpc.apphuongdannauan.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainIntroduce1 extends AppCompatActivity implements View.OnClickListener {

    private CircleImageView circleImageView;
    private RelativeLayout relativeLayout;
    private Animation animation;
    private Animation animation1;
    private Animation animation2;
    private Button buttonStart;
    private MyDialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_introduce1);
        initViews();
    }

    private void initViews() {
        myDialog = new MyDialog(this);
        relativeLayout = (RelativeLayout) findViewById(R.id.relative_introduce1);
        circleImageView = (CircleImageView) findViewById(R.id.img_circle);
        buttonStart = (Button) findViewById(R.id.bt_start);
        animation = AnimationUtils.loadAnimation(this, R.anim.animation_rotate);
        animation1 = AnimationUtils.loadAnimation(this, R.anim.translatefromleft);
        relativeLayout.startAnimation(animation1);
        animation2 = AnimationUtils.loadAnimation(this, R.anim.animation_blink);
        buttonStart.startAnimation(animation2);
        circleImageView.startAnimation(animation);
        buttonStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_start:
                Intent intent = new Intent(MainIntroduce1.this, MainIntroduce2.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == event.KEYCODE_BACK) {

            myDialog.show();

        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        super.onPause();
        myDialog.cancel();
    }
}
