package com.example.dongpc.apphuongdannauan.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.dongpc.apphuongdannauan.R;
import com.example.dongpc.apphuongdannauan.activity.ActivityThemChuDeMon;
import com.example.dongpc.apphuongdannauan.database.MyDatabase;
import com.example.dongpc.apphuongdannauan.entities.ChuDeMon;

/**
 * Created by DongPC on 4/17/2017.
 */

public class MyDialogThemChuDe extends Dialog implements View.OnClickListener {

    private EditText editTextChuDe;
    private Button buttonOk, buttonCancel;
    private ActivityThemChuDeMon activityThemChuDeMon;
    private CallBack callBack;


    public MyDialogThemChuDe(@NonNull Context context) {
        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.item_dialog_themchude);
        initViews();
    }

    private void initViews() {

        activityThemChuDeMon = new ActivityThemChuDeMon();
        editTextChuDe = (EditText) findViewById(R.id.edt_themchude);
        buttonOk = (Button) findViewById(R.id.bt_ok);
        buttonCancel = (Button) findViewById(R.id.bt_cancel);
        buttonOk.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_ok:
                callBack.finish(editTextChuDe.getText().toString());
                dismiss();

                break;
            case R.id.bt_cancel:
                dismiss();
                break;
        }
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public interface CallBack {
        public void finish(String result);

    }


}
