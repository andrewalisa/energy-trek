package com.example.chase.EnergyTrek;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


public class DatabaseHandler extends SQLiteOpenHelper {
//*************************This is where the first attempt begins for making a db******************
    // For this attempt, it makes it's own db within the program, which I realized after
    //I put it all in. This is not very useful for our needs.

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase MyBase;
    private Context mycontext;

    // Database Name
    private static String DB_PATH = "Environment.getExternalStorageDirectory().getPath()";
    private static String DB_NAME = "TABLE_USERNAMES.sql";

    // Usernames table name
    private static final String TABLE_USERNAMES = "usernames";

    // Usernames Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";

    public DatabaseHandler(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }



    // Creating Table
    @Override
    public void onCreate(SQLiteDatabase db) {/*
        String CREATE_USERNAMES_TABLE = "CREATE TABLE " + TABLE_USERNAMES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + ")";
        db.execSQL(CREATE_USERNAMES_TABLE);*/


        String Item = "";
        Username u1 = new Username();

        MyBase = SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READONLY);
        Item = MyBase.toString();
        u1.setName(Item);

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERNAMES);

        // Create table again
        onCreate(db);
    }

    // Adding new username
    public void addUsername(Username username) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, username.getName());
        // Inserting Row
        db.insert(TABLE_USERNAMES, null, values);
        db.close(); // Closing database connection
    }

    //Search for username
    public String Search(String name){
        long ID = 0;
        //ID = MyBase.getMaximumSize();
        String check = "";

        for(Integer x = 0; x < 2; x++) {
            Cursor cursor = MyBase.query(TABLE_USERNAMES, null, name, null, null, null, null, null);
            //check = MyBase.
            Username username = new Username(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1));
        }

        // return username
        return check;
    }

    // Getting single username
    public Username getUsername(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = MyBase.query(TABLE_USERNAMES, new String[] { KEY_ID, KEY_NAME}, KEY_ID + "=?", new String[] { name }, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Username username = new Username(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1));
        // return username
        return username;
    }

    // Updating single username
    public int updateUsername(Username username) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, username.getName());

        // updating row
        return db.update(TABLE_USERNAMES, values, KEY_ID + " = ?",
                new String[] { String.valueOf(username.getID()) });
    }

    // Deleting single username
    public void deleteUsername(Username username) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERNAMES, KEY_ID + " = ?",
                new String[] { String.valueOf(username.getID()) });
        db.close();
    }



    //***********************From here down begins the next attempt at a db***********************
    // This is basically useless. I know how to establish a db_path/name, but idk how to do
    //anything beyond that in this method.
    public void createDatabase(){
        boolean dbExist = checkDatabase();
        if(dbExist){

        }
        else{
            this.getReadableDatabase();

        }
    }

    private void copydatabase() throws IOException {
        //Open your local db as the input stream
        InputStream myinput = mycontext.getAssets().open(DB_NAME);

        // Path to the just created empty db
        String outfilename = DB_PATH + DB_NAME;

        //Open the empty db as the output stream
        OutputStream myoutput = new FileOutputStream("/data/data/EnergyTrek/databases/TABLE_USERNAMES.sqlite");

        // transfer byte to inputfile to outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myinput.read(buffer))>0) {
            myoutput.write(buffer,0,length);
        }

        //Close the streams
        myoutput.flush();
        myoutput.close();
        myinput.close();

    }

    public Boolean checkDatabase(){
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        }catch(SQLiteException e){
            //Database no existo
        }

        return checkDB != null ? true : false;
    }

    public void openDatabase(){
        String myPath = DB_PATH + DB_NAME;
        MyBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

}
