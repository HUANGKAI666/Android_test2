package com.example.test_sqliteopenhelpr;


import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class MainActivity extends Activity {
private TextView tv,tv2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 tv = (TextView) findViewById(R.id.tv);
		 tv2 = (TextView) findViewById(R.id.tv2);
		 sqlhelpr helpr = new sqlhelpr(MainActivity.this, "stu.db");
		 SQLiteDatabase db = helpr.getWritableDatabase();
		 Cursor c = db.rawQuery("select * from stu", null);
		 if (c!=null) {
			String [] cols = c.getColumnNames();
			while (c.moveToNext()) {
				for (String ColumnName:cols) {
					tv.setText(ColumnName);
					tv2.setText(c.getString(c.getColumnIndex(ColumnName)));
					
				}
			}
		}
	}

	
}
