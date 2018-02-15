package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by soham on 18/1/18.
 */

public class PetDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "shelter.db";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + PetContract.PetEntry.TABLE_NAME
            +"(" + PetContract.PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + PetContract.PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL,"
            + PetContract.PetEntry.COLUMN_PET_BREED + " TEXT,"
            + PetContract.PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL,"
            + PetContract.PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0" + ");";
    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + PetContract.PetEntry.TABLE_NAME;

    public PetDbHelper(Context context){
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
    sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
    onCreate(sqLiteDatabase);
    }
}
