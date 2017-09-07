package com.qidu.activity;

import com.qidu.base.activity.ActivityCollector;
import com.yanruqi.CatersSystem.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;

public class LaunchActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// 全屏
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_launch);
		
		
		
		ActivityCollector.addActivity(this);
		
		
		new Handler(new Handler.Callback() {
			@Override
			public boolean handleMessage(Message msg) {
				// 实现页面跳转
				startActivity(new Intent(getApplicationContext(),
						LogInActivity.class));
				finish();
				return false;
			}
		}).sendEmptyMessageDelayed(0, 2000);// 表示延迟3秒发送任务
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		ActivityCollector.removeActivity(this);
	}
}


