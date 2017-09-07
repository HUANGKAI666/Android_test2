package com.qidu.activity;

import com.qidu.base.activity.ActivityCollector;

import com.yanruqi.CatersSystem.R;



import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity  {
	//添加代码，声明shareprefences对象和editor对象
	private SharedPreferences pref;
		
	private EditText username, passwpord;
	private Button signin, register;
	private String name;
	private String pwd;
	
	private SharedPreferences.Editor editor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_register);
		
		ActivityCollector.addActivity(this);
		//添加代码，创建sharedpreferences对象
		pref = PreferenceManager.getDefaultSharedPreferences(this);
		username = (EditText) findViewById(R.id.RegisterName);
		passwpord = (EditText) findViewById(R.id.RegisterPassword);
		signin = (Button) findViewById(R.id.login);
		
				signin.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						String account = username.getText().toString();
						String password = passwpord.getText().toString();
						if (account.equals("") || password.equals("")) {
							//添加代码，把账号和密码通过sharedpreferences存储
							
							Toast.makeText(RegisterActivity.this,
									"用户名或密码有误",
									Toast.LENGTH_SHORT).show();
							
							
							
						} else {
							editor = pref.edit();
							Boolean booleanA = false;
							//检查复选框是否被选中
							editor.putBoolean("remember_password", booleanA);
							editor.putString("account", account);
							editor.putString("password", password);
		
						    editor.commit();
						    
						    Intent intent = new Intent(RegisterActivity.this, LogInActivity.class);
							startActivity(intent);
							finish();
							
						}
					}
				});
			
		
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		ActivityCollector.removeActivity(this);
	}

	
	

}
