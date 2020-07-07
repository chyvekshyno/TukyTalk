package com.example.tukyhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

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
    private static final String KEY_ICON = "Icon";
    private static final String KEY_NTF = "Notification";

    // ESSENCE_TYPE table create statement
    private static final String CREATE_ESSENCE_TYPE_TABLE = "CREATE TABLE " + TABLE_ESSENCE_TYPE + "("
            + KEY_TYPE + " TEXT,"
            + KEY_TYPE_ID + " INTEGER PRIMARY KEY" + ")";

    // ESSENCE table create statement
    private static final String CREATE_ESSENCE_TABLE = "CREATE TABLE " + TABLE_ESSENCE + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_ESS_TYPE + " INTEGER,"
            + KEY_NAME + " TEXT,"
            + KEY_ICON + " TEXT,"
            + KEY_NTF + " INTEGER" + ")";


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

    /*
     * Create new essence
     */
    public long createEssence(Essence es) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ESS_TYPE, es.type().getValue());
        values.put(KEY_NAME, es.name());
        values.put(KEY_ICON, es.icon());
        values.put(KEY_NTF, es.ntfCount());

        return db.insert(TABLE_ESSENCE, null, values);
    }

    /*
     * Fetch  Essence from Data Base
     */
    public Essence getEssence(int esId){
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_ESSENCE
                + " WHERE " + KEY_ID + " = " + esId;

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Essence es = new Essence(EssenceType.valueOf(c.getInt(c.getColumnIndex(KEY_ID)))
                , c.getString(c.getColumnIndex(KEY_NAME))
                , c.getString(c.getColumnIndex(KEY_ICON))
                , c.getInt(c.getColumnIndex(KEY_NTF)));

        c.close();
        return es;
    }

    /*
     * Fatch all essences from Data Base
     */
    public List<Essence> getAllEssences() {
        List<Essence> esList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_ESSENCE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if(c.moveToFirst())
            do{
                Essence es = new Essence(EssenceType.valueOf(c.getInt(c.getColumnIndex(KEY_ID)))
                        , c.getString(c.getColumnIndex(KEY_NAME))
                        , c.getString(c.getColumnIndex(KEY_ICON))
                        , c.getInt(c.getColumnIndex(KEY_NTF)));

                esList.add(es);
            }while(c.moveToNext());

        c.close();
        return esList;
    }

    public void delseteEssence(int esId){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ESSENCE, KEY_ID + "= ?", new String[] { String.valueOf(esId)});
    }

}
