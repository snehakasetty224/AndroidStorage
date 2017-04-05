package com.example.sneha.androiddatastorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sneha on 4/4/17.
 */

public class DataController {

    public static final String ITEMNAME = "itemName";
    public static final String ITEMDESCRIPTION = "itemDescription";
    public static final String ITEMPRICE = "itemPrice";
    public static final String ITEMREVIEW = "itemReview";
    public static final String TABLENAME = "Product_Table";
    public static final String DATABASENAME = "StorageAssignment";
    public static final int DATABASE_VERSION =4;
    public static final String TABLE_CREATE="create table Product_Table (itemName text not null,itemDescription text not null, itemPrice text not null,itemReview not null); ";

    DataBaseHelper dbHelper;
    Context context;
    SQLiteDatabase db;

    public  DataController(Context ctx)
    {
        this.context = ctx;
        dbHelper = new DataBaseHelper(context);
    }
    public DataController open()
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dbHelper.close();
    }

    public long insert(String itemName, String itemDescription, String itemPrice, String itemReview)
    {
        ContentValues content = new ContentValues();
        content.put(ITEMNAME,itemName);
        content.put(ITEMDESCRIPTION,itemDescription);
        content.put(ITEMPRICE,itemPrice);
        content.put(ITEMREVIEW,itemReview);
        return db.insertOrThrow(TABLENAME,null,content);
    }
    public Cursor retrieve()
    {
        return db.query(TABLENAME, new String[]{ITEMNAME,ITEMDESCRIPTION,ITEMPRICE,ITEMREVIEW},null,null,null,null,null);
    }

    private static class DataBaseHelper extends SQLiteOpenHelper
    {

        public DataBaseHelper(Context context)
        {
            super(context, DATABASENAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db){

            try
            {
                db.execSQL(TABLE_CREATE);
            }
            catch (SQLiteException e)
            {
                e.printStackTrace();
            }

        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

            db.execSQL("DROP TABLE IF EXISTS Product_Table ");
            onCreate(db);
        }
    }




}
