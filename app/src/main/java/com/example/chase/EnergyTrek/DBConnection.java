package com.example.chase.EnergyTrek;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;

public class DBConnection {
    DatabaseHandler Konekt;
    String name;

    public String getNameDatabase(Context context){
        Konekt = new DatabaseHandler(context);

        Konekt.createDatabase();

        if(Konekt.checkDatabase()) {
            Konekt.openDatabase();
            SQLiteDatabase db1 = Konekt.getWritableDatabase();
            Cursor cursor = db1.rawQuery("SELECT name FROM USERNAMES_TABLE", null);
            while (cursor.moveToNext()) {
                name = cursor.getString(0);
            }

            Konekt.close();

            return name;
        }else{
            return "error";
        }
    }
}
