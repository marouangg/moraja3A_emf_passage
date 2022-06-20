package com.example.moraja3a_emf_passage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {


    public static final String DATABASE_NAME="db.societe";
    public  static final String TABLE_NAME="societe_table";

    public MyDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"(id integer primary key autoincrement,Raison_Sociale text,Secteur_activite text,nb_employe real)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if  exists "+TABLE_NAME);
        onCreate(db);
    }

    public static long AddSociete(SQLiteDatabase db ,Societe s){
        ContentValues c = new ContentValues();
        c.put("Raison_Sociale",s.getNom());
        c.put("Secteur_activite",s.getSecteur_act());
        c.put("nb_employe",s.getNb_employe());

        long l = db.insert(TABLE_NAME,null,c);

        return  l;
    }

    public static long UpdateSociete(SQLiteDatabase db ,Societe s){
        ContentValues c = new ContentValues();
        c.put("id",s.getId());
        c.put("Raison_Sociale",s.getNom());
        c.put("Secteur_activite",s.getSecteur_act());
        c.put("nb_employe",s.getNb_employe());

        long l = db.update(TABLE_NAME,c,"id=?",new String[]{String.valueOf(s.getId())});

        return l;
    }

    public static long DeleteSociete(SQLiteDatabase db ,int id){
        return db.delete(TABLE_NAME,"id="+id,null);
    }


    public static ArrayList<Societe> getAllSociete(SQLiteDatabase db){

        ArrayList<Societe> ls = new ArrayList<>();
        Cursor c = db.rawQuery("select * from "+TABLE_NAME,null);

        while(c.moveToNext()){
            Societe s = new Societe();

            s.setId(c.getInt(0));
            s.setNom(c.getString(1));
            s.setSecteur_act(c.getString(2));
            s.setNb_employe(c.getDouble(3));

            ls.add(s);
        }
        return ls;
    }

    public static  Societe getOneSociete(SQLiteDatabase db , int id){

        Societe s=null;
        Cursor c = db.rawQuery("select * from "+TABLE_NAME+" where id="+id,null);
        while(c.moveToNext()){
             s = new Societe();

            s.setId(c.getInt(0));
            s.setNom(c.getString(1));
            s.setSecteur_act(c.getString(2));
            s.setNb_employe(c.getDouble(3));


        }
        return  s;
    }

}
