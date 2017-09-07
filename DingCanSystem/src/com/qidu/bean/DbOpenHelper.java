package com.qidu.bean;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;




public class DbOpenHelper extends SQLiteOpenHelper {

    public  DbOpenHelper(Context context) {
 
        super(context.getApplicationContext(), "shopping.db", null , 1);
    }

    private static  DbOpenHelper mHelper;
    public  static  DbOpenHelper getInstance (Context context) {
        if (mHelper == null) {
            synchronized (DbOpenHelper.class) {
                if (mHelper == null) {
                    mHelper = new DbOpenHelper(context);
                }

            }

        }
        return mHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_table = "create table tb_shopping ("
                + "_id integer primary key autoincrement, "
                + "image integer, "
                + "name text,"
                + "content text,"
                + "price text )"
               ;

    db.execSQL(CREATE_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
