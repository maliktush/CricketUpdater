package com.tusharmalik.cricketupdater.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tusharmalik.cricketupdater.Crics;

import java.util.ArrayList;

import static com.tusharmalik.cricketupdater.db.Consts.CMD_CREATE_TABLE_INE;
import static com.tusharmalik.cricketupdater.db.Consts.COMMA;
import static com.tusharmalik.cricketupdater.db.Consts.LBR;
import static com.tusharmalik.cricketupdater.db.Consts.RBR;
import static com.tusharmalik.cricketupdater.db.Consts.SEMI;
import static com.tusharmalik.cricketupdater.db.Consts.TYPE_INT;
import static com.tusharmalik.cricketupdater.db.Consts.TYPE_PK_AI;
import static com.tusharmalik.cricketupdater.db.Consts.TYPE_TEXT;

/**
 * Created by tushm on 05-02-2018.
 */

public class CricketTable {
    private CricketTable(){}
    public static final String TABLE_NAME = "crics";

    public interface Columns {
        String ID = "ID";
        String Name1="TEAM1";
        String Name2="TEAM2";
        String Date="Date";
        String Time="Time";
        String Type="Type";
    }
    public static final String CMD_CREATE_TABLE =
            CMD_CREATE_TABLE_INE +  TABLE_NAME
                    + LBR
                    + Columns.ID + TYPE_INT + TYPE_PK_AI + COMMA
                    + Columns.Name1 + TYPE_TEXT + COMMA
                    + Columns.Name2+ TYPE_TEXT + COMMA
                    + Columns.Date+ TYPE_TEXT + COMMA
                    + Columns.Time+ TYPE_TEXT + COMMA
                    + Columns.Type+ TYPE_TEXT + COMMA
                    + RBR + SEMI;
    public static long addCrics (Crics crics, SQLiteDatabase db) {
        ContentValues newCric = new ContentValues();
        newCric.put(Columns.ID,crics.getId());
        newCric.put(Columns.Name1,crics.getTeam1());
        newCric.put(Columns.Name2,crics.getTeam2());
        newCric.put(Columns.Date, crics.getDate());
        newCric.put(Columns.Time, crics.getTime());
        newCric.put(Columns.Type, crics.getType());

        return db.insert(TABLE_NAME, null, newCric);
    }

    public static ArrayList<Crics> getAllCrics (SQLiteDatabase db) {
        Cursor c = db.query(
                TABLE_NAME,
                new String[]{Columns.ID, Columns.Name1, Columns.Name2,Columns.Date,Columns.Time,Columns.Type},
                null,
                null,
                null,
                null,
                null
        );
        ArrayList<Crics> Crics = new ArrayList<>();
        c.moveToFirst();
        int id = c.getColumnIndex(Columns.ID);
        int name1 = c.getColumnIndex(Columns.Name1);
        int name2 = c.getColumnIndex(Columns.Name2);
        int date = c.getColumnIndex(Columns.Date);
        int time = c.getColumnIndex(Columns.Time);
        int type = c.getColumnIndex(Columns.Type);


        while (!c.isAfterLast()) {
            Crics.add(new Crics(
                    c.getInt(id),
                    c.getString(name1),
                    c.getString(name2),
                    c.getString(date),
                    c.getString(time),
                    c.getString(type)

            ));

            c.moveToNext();
        }
        return Crics;
    }


}


