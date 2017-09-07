package com.example.test_scrollview;

import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ScrollView;
import android.widget.TextView;
import android.os.Bundle;


public class MainActivity extends ActionBarActivity {
	private TextView tv;
	private ScrollView scr;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.textView1);
		scr = (ScrollView) findViewById(R.id.ScrollView);
		tv.setText(getResources().getString(R.string.content));
		scr.setOnTouchListener(new OnTouchListener() {
			  
			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
				switch (arg1.getAction()) {
				case MotionEvent.ACTION_MOVE:{
					
					//总共的高度      屏幕的高度   手划的高度
					if (scr.getChildAt(0).getMeasuredHeight()<=scr.getHeight()
					+scr.getScrollY()) {
						
						tv.append(getResources().getString(R.string.content));
						
					}
					
					break;
				}

				
				}
				return false;
			}
		});
	}
}
	
