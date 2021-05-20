package com.example.intro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class Database extends SQLiteOpenHelper {


    public static final String UserID = "ID";
    public static final String UserName = "Name ";
    public static final String UserAvatar = "Avatar ";
    public static final String UserLvl = "Lvl ";
    public static final String UserXP = "currentXP ";
    public static final String UserXPMax = "maxXP  ";
    public static final String UserGold = "Gold ";
    public static final String UserCurrentHP = "CurrentHP ";
    public static final String UserMaxHP = "MaxHP ";





    public Database(@Nullable Context context) {
        super(context, "ZoupleCastleDatabase", null, 2);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableUser= "CREATE TABLE " + "User" + "(ID INTEGER DEFAULT 1 ,"  + UserName + " String DEFAULT '',"+ UserAvatar + " String DEFAULT 'zoupleavatar1_foreground',"+  UserLvl + " Integer DEFAULT 1 ," + UserXP +
                " Integer DEFAULT 0," + UserXPMax + " Integer DEFAULT 100 ," + UserGold+ " Integer DEFAULT 0 ," + UserCurrentHP + " Integer DEFAULT 1000 ," +
                UserMaxHP +"Integer DEFAULT 1000);";



        db.execSQL(createTableUser);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "User");
        onCreate(db);
    }



    public boolean SaveUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        Long numIdUser = DatabaseUtils.queryNumEntries(db,"User",null);
        if (numIdUser < 1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(UserID, 1);
            long result = db.insert("User", "ID", contentValues);
        }
        numIdUser = DatabaseUtils.queryNumEntries(db,"User",null);
        if (numIdUser >= 1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(UserID, 1);
            contentValues.put(UserLvl, user.lvl);
            contentValues.put(UserXP, user.currentXP);
            contentValues.put(UserXPMax, user.maxXP);
            contentValues.put(UserGold, user.gold);
            contentValues.put(UserName, user.name);
            contentValues.put(UserAvatar, user.avatarImg);
            contentValues.put(UserCurrentHP, user.currentHP);
            contentValues.put(UserMaxHP, user.maxHP);
            db.update("User", contentValues, "ID= ? ", new String[]{"1"});
            return true;
        }
        return false;
    }



    public boolean LoadUser(User user){

        SQLiteDatabase db = this.getReadableDatabase();

        String[] allColumns_User = { "ID", "Name","Avatar", "Lvl", "currentXP", "maxXP","Gold","CurrentHP","MaxHP"};


        Cursor cursor =db.query("User", allColumns_User, "ID = ?",new String[]{"1"},null,null,null);
        if( cursor != null && cursor.moveToFirst() ){
            user.name=cursor.getString(cursor.getColumnIndex("Name"));
            user.avatarImg=cursor.getString(cursor.getColumnIndex("Avatar"));
            user.lvl=cursor.getInt(cursor.getColumnIndex("Lvl"));
            user.currentXP=cursor.getInt(cursor.getColumnIndex("currentXP"));
            user.maxXP=cursor.getInt(cursor.getColumnIndex("maxXP"));
            user.gold=cursor.getInt(cursor.getColumnIndex("Gold"));
            user.currentHP=cursor.getInt(cursor.getColumnIndex("CurrentHP"));
            user.maxHP=cursor.getInt(cursor.getColumnIndex("MaxHP"));
            cursor.close();
            return true;
        }
        return false;
    }

}
