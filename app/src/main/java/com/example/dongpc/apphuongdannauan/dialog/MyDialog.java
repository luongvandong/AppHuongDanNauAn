package com.example.dongpc.apphuongdannauan.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.dongpc.apphuongdannauan.R;

/**
 * Created by DongPC on 4/15/2017.
 */

public class MyDialog extends Dialog implements View.OnClickListener {
    private Button buttonCancel, buttonOk;

    public MyDialog(@NonNull Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.item_dialog);
        initViews();
    }

    private void initViews() {
        buttonCancel = (Button) findViewById(R.id.bt_cancel);
        buttonOk = (Button) findViewById(R.id.bt_ok);
        buttonCancel.setOnClickListener(this);
        buttonOk.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_cancel:
                dismiss();
                break;
            case R.id.bt_ok:
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(intent);
                break;
        }

    }


}
