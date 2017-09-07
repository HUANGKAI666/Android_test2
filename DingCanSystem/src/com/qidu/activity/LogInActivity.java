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
import android.widget.CheckBox;

import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends Activity  {
	//添加代码，声明shareprefences对象和editor对象
	private SharedPreferences pref;
		
	private EditText usernameEditText, passwpordEditText;
	private Button signin, register;
	private String nameDB;
	private String pwdDB;
	private CheckBox rememberPass;
	private SharedPreferences.Editor editor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_log_in);
		
		ActivityCollector.addActivity(this);
		//添加代码，创建sharedpreferences对象
		pref = PreferenceManager.getDefaultSharedPreferences(this);
		usernameEditText = (EditText) findViewById(R.id.username);
		passwpordEditText = (EditText) findViewById(R.id.password);
		signin = (Button) findViewById(R.id.signin);
		register = (Button) findViewById(R.id.register);
		
		nameDB  = pref.getString("account", "");
		pwdDB = pref.getString("password", "");
		
		
		
		rememberPass = (CheckBox) findViewById(R.id.check);
		//添加代码，通过sharedpreferences对象取存储中的值
				boolean isRemember = pref.getBoolean("remember_password", false);
				if (isRemember){
					//将账号和密码都设置到文本框中
					String account  = pref.getString("account", "");
					String password = pref.getString("password", "");
					usernameEditText.setText(account);
					passwpordEditText.setText(password);
					rememberPass.setChecked(true);
				}
		
				signin.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						String account = usernameEditText.getText().toString();
						String password = passwpordEditText.getText().toString();
						if (account.equals(nameDB) && password.equals(pwdDB)) {
							//添加代码，把账号和密码通过sharedpreferences存储
							editor = pref.edit();
							if (rememberPass.isChecked()){
								//检查复选框是否被选中
								editor.putBoolean("remember_password", true);
								editor.putString("account", account);
								editor.putString("password", password);
								
							}else{
								editor.clear();
							}
							editor.commit();
							
							Intent intent = new Intent(LogInActivity.this, MainActivity.class);
							startActivity(intent);
							finish();
						} else {
							Toast.makeText(LogInActivity.this,
									"用户名或密码有误",
									Toast.LENGTH_SHORT).show();
						}
					}
				});
				register.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						Intent registerIntent = new Intent(LogInActivity.this,
								RegisterActivity.class);
						startActivity(registerIntent);
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
