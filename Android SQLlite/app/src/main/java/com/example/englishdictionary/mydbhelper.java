package com.example.englishdictionary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class mydbhelper extends SQLiteOpenHelper {
    private static final String databasename = "mydatabase";
    private  static final int version = 1;

    public mydbhelper( Context context) {
        super(context, databasename,null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String quary = "create table dictionary (id integer primary key autoincrement, word text,meaning text)";
        sqLiteDatabase.execSQL(quary);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
       String quary = "drop table if exists dictionary";
       sqLiteDatabase.execSQL(quary);
       onCreate(sqLiteDatabase);
    }
    public boolean insertdata(String key_word,String key_meaning){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("word",key_word);
        values.put("meaning",key_meaning);
        long i = database.insert("dictionary",null,values);
        if (i == -1){
            return false;
        }else {
            return true;
        }
    }
    public Cursor getdata(){
        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.rawQuery("select * from dictionary",null);
        return cursor;
    }

    public boolean deletedata(String word,String meaning){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from dictionary where word = ? and meaning = ?",new String[]{word,meaning});
        if (cursor.getCount()>0) {
          long i =  db.delete("dictionary", "word=? and meaning=?", new String[]{word, meaning});
          if (i==-1){
              return false;
          } else {
              return true;
          }

        }else {
            return false;
        }
    }

    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from dictionary");
    }
}
