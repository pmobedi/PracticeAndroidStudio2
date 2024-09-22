package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "crime-database.db";

    private static final int DATABASE_VERSION = 1;
    private final Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // ایجاد جدول (اگر پایگاه داده وجود نداشته باشد)
        db.execSQL("CREATE TABLE IF NOT EXISTS Crimes (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL, date TEXT NOT NULL, isSolved INTEGER NOT NULL DEFAULT 0);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // آپدیت پایگاه داده
        db.execSQL("DROP TABLE IF EXISTS Crimes");
        onCreate(db);
    }

    public void copyDatabase() throws IOException {
        InputStream input = context.getAssets().open(DATABASE_NAME);
        String outFileName = context.getDatabasePath(DATABASE_NAME).getPath();
        OutputStream output = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = input.read(buffer)) > 0) {
            output.write(buffer, 0, length);
        }

        output.flush();
        output.close();
        input.close();
    }
}
