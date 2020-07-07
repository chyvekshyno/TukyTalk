package com.example.tukyhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class EssenceDbHelper extends SQLiteOpenHelper {
    // Data base version
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "essence";

    // Table Names
    private static final String TABLE_ESSENCE_TYPE = "essenceTypes";
    private static final String TABLE_ESSENCE = "essenceList";

    // ESSENCE_TYPE Table Variables
    private static final String KEY_TYPE = "Type";
    private static final String KEY_TYPE_ID = "Id";

    // ESSENCE Table Variables
    private static final String KEY_ID = "Id";
    private static final String KEY_ESS_TYPE = "Type";
    private static final String KEY_NAME = "Name";

    // ESSENCE_TYPE table create statement
    private static final String CREATE_ESSENCE_TYPE_TABLE = "CREATE TABLE " + TABLE_ESSENCE_TYPE + "("
            + KEY_TYPE + " TEXT,"
            + KEY_TYPE_ID + " INTEGER PRIMARY KEY" + ")";

    // ESSENCE table create statement
    private static final String CREATE_ESSENCE_TABLE = "CREATE TABLE " + TABLE_ESSENCE + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_ESS_TYPE + " INTEGER,"
            + KEY_NAME + " TEXT" + ")";


    public EssenceDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ESSENCE_TYPE_TABLE);
        db.execSQL(CREATE_ESSENCE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ESSENCE_TYPE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ESSENCE);

        onCreate(db);
    }
}
