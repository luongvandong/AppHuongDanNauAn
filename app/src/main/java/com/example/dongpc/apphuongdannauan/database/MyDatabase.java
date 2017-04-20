package com.example.dongpc.apphuongdannauan.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.example.dongpc.apphuongdannauan.entities.ChuDeMon;
import com.example.dongpc.apphuongdannauan.entities.MonMoi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by DongPC on 4/15/2017.
 */

public class MyDatabase {
    private static final String DATABASE_PATH = Environment.getDataDirectory().getAbsolutePath() + "/data/com.example.dongpc.apphuongdannauan/";
    private static final String DATABSE_NAME = "dbnauan.sqlite";
    private static final String TABLE_NAME_CHUDEMON = "chudemon";
    private static final String TABLE_NAME_CHUDEMON_COLUMN_MA = "machudemon";
    private static final String TABLE_NAME_CHUDEMON_COLUMN_TEN = "tenchude";
    private static final String TABLE_NAME_CHUDEMON_COLUMN_HINH = "hinhanhchude";
    private static final String SQL_GET_CHUDEMON = "SELECT * FROM " + TABLE_NAME_CHUDEMON;
    private static final String TABLE_NAME_MONMOI = "chitietmontheochude";
    private static final String TABLE_NAME_MONMOI_COLUMN_MAMON = "mamon";
    private static final String TABLE_NAME_MONMOI_COLUMN_TENMON = "tenmon";
    private static final String TABLE_NAME_MONMOI_COLUMN_NGAYLAP = "ngaylap";
    private static final String TABLE_NAME_MONMOI_COLUMN_NOIDUNG = "noidung";
    private static final String TABLE_NAME_MONMOI_COLUMN_MACHUDE = "machude";
    private static final String SQL_GET_MONMOI = "SELECT *FROM " + TABLE_NAME_MONMOI;


    private SQLiteDatabase sqLiteDatabase;


    public MyDatabase(Context context) {
        copyDatabase(context);

    }

    private void copyDatabase(Context context) {
        try {
            InputStream inputStream = context.getAssets().open("dbnauan.sqlite");
            String path = DATABASE_PATH + DATABSE_NAME;
            File file = new File(path);
            if (file.exists())
                return;
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte buff[] = new byte[1024];
            int len = inputStream.read(buff);
            while (len > 0) {
                fileOutputStream.write(buff);
                inputStream.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void openDatabase() {
        if (sqLiteDatabase == null || !sqLiteDatabase.isOpen())
            sqLiteDatabase = SQLiteDatabase.openDatabase(DATABASE_PATH + DATABSE_NAME, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase() {
        if (sqLiteDatabase.isOpen() && sqLiteDatabase != null)
            sqLiteDatabase.close();
    }

    public void insertChuDeMon(ChuDeMon chuDeMon) {
        openDatabase();
        ContentValues values = new ContentValues();
        values.put(TABLE_NAME_CHUDEMON_COLUMN_MA, chuDeMon.getMaChuDe());
        values.put(TABLE_NAME_CHUDEMON_COLUMN_TEN, chuDeMon.getTenChuDe());
        values.put(TABLE_NAME_CHUDEMON_COLUMN_HINH, chuDeMon.getHinhAnhChuDe());
        sqLiteDatabase.insert(TABLE_NAME_CHUDEMON, null, values);

        closeDatabase();

    }

    public void insertNameChuDeMon(ChuDeMon chuDeMon) {
        openDatabase();
        ContentValues values = new ContentValues();

        values.put(TABLE_NAME_CHUDEMON_COLUMN_TEN, chuDeMon.getTenChuDe());

        sqLiteDatabase.insert(TABLE_NAME_CHUDEMON, null, values);

        closeDatabase();

    }

    public void deleteChuDeMon(ChuDeMon chuDeMon) {
        openDatabase();
        sqLiteDatabase.delete(TABLE_NAME_CHUDEMON, "id=?", new String[]{"12"});
        closeDatabase();

    }

    public void updateChuDeMon(ChuDeMon chuDeMon) {
        openDatabase();
        ContentValues values = new ContentValues();
        values.put(TABLE_NAME_CHUDEMON_COLUMN_MA, chuDeMon.getMaChuDe());
        values.put(TABLE_NAME_CHUDEMON_COLUMN_TEN, chuDeMon.getTenChuDe());
        values.put(TABLE_NAME_CHUDEMON_COLUMN_HINH, chuDeMon.getHinhAnhChuDe());
        sqLiteDatabase.update(TABLE_NAME_CHUDEMON, values, "id=?", new String[]{"12"});

        closeDatabase();

    }



    public ArrayList<ChuDeMon> getChuDeMon() {
        openDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SQL_GET_CHUDEMON, null);
        if (cursor == null)
            return null;
        if (cursor.getCount() == 0) {
            cursor.close();
            closeDatabase();
            return new ArrayList<>();
        }
        int indexMa = cursor.getColumnIndex(TABLE_NAME_CHUDEMON_COLUMN_MA);
        int indexTen = cursor.getColumnIndex(TABLE_NAME_CHUDEMON_COLUMN_TEN);
        int indexHinh = cursor.getColumnIndex(TABLE_NAME_CHUDEMON_COLUMN_HINH);

        cursor.moveToFirst();
        ArrayList<ChuDeMon> chuDeMons = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            int ma = cursor.getInt(indexMa);
            String ten = cursor.getString(indexTen);
            byte[] hinh = cursor.getBlob(indexHinh);
            chuDeMons.add(new ChuDeMon(ma, ten, hinh));
            cursor.moveToNext();

        }
        cursor.close();
        closeDatabase();
        return chuDeMons;
    }
    public ArrayList<MonMoi> getMonMoi() {
        openDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SQL_GET_MONMOI, null);
        if (cursor == null)
            return null;
        if (cursor.getCount() == 0) {
            cursor.close();
            closeDatabase();
            return new ArrayList<>();
        }
        int indexMa = cursor.getColumnIndex(TABLE_NAME_CHUDEMON_COLUMN_MA);
        int indexTen = cursor.getColumnIndex(TABLE_NAME_CHUDEMON_COLUMN_TEN);
        int indexHinh = cursor.getColumnIndex(TABLE_NAME_CHUDEMON_COLUMN_HINH);

        cursor.moveToFirst();
        ArrayList<ChuDeMon> chuDeMons = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            int ma = cursor.getInt(indexMa);
            String ten = cursor.getString(indexTen);
            byte[] hinh = cursor.getBlob(indexHinh);
            chuDeMons.add(new ChuDeMon(ma, ten, hinh));
            cursor.moveToNext();

        }
        cursor.close();
        closeDatabase();
        return chuDeMons;
    }
}
