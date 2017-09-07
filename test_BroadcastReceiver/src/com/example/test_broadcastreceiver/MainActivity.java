package com.example.test_broadcastreceiver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView tv1 = (TextView) findViewById(R.id.textView1);
		
	}
	public void doClick(View v){
		switch (v.getId()) {
		case R.id.button1:
			Intent intent =new Intent();
			intent.putExtra("msg", "这是一条普通广播");
			intent.setAction("bc_1");
			
			sendBroadcast(intent);
		
			break;

		default:
			break;
		}
	}

}
