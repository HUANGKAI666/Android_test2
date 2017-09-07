package com.example.test_sqliteopenhelpr;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;

public class sqlhelpr extends SQLiteOpenHelper{

	public sqlhelpr(Context context, String name) {
		super(context, name, null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table if not exists stu(" +
				"_id integer primary key autoincrement," +
				"name text not null," +
				"sex text not null," +
				"age integer not null)");
		db.execSQL("insert into stu(name,sex,age) values ('ÕÅÈý','ÄÐ','18')");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
