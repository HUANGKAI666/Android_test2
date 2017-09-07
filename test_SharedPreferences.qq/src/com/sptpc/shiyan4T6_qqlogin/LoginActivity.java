package com.sptpc.shiyan4T6_qqlogin;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {
	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		textView = (TextView) findViewById(R.id.hello);
		String str = getIntent().getStringExtra("chuandi");
		textView.setText("欢迎你"+str);
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
	
		//super.onBackPressed();
		new AlertDialog.Builder(LoginActivity.this)
		.setTitle("标题")
		.setMessage("你确定退出吗？")
		.setIcon(R.drawable.ic_launcher)
		.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				LoginActivity.this.finish();//结束当前活动
				
				
			}
		})
		.setNegativeButton("取消", null)
		.create().show();
		
	}




	
	
	
}
