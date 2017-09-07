package com.sptpc.shiyan4T6_qqlogin;




import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class MainActivity extends Activity {
	private Button button;
	private EditText nameText,pwdText;
	private Editor editor;
	private SharedPreferences pref;
	private CheckBox checkbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        

         nameText=(EditText) findViewById(R.id.logit_edit_account);
         pwdText=(EditText) findViewById(R.id.logit_edit_pwd);
         button=(Button) findViewById(R.id.login_btn_login);
         checkbox=(CheckBox) findViewById(R.id.CheckBox);
         pref = getSharedPreferences("shuju", MODE_PRIVATE);//获得SharedPreferences对象
         editor = pref.edit();//获得edit()编辑器对象  才能存储
         boolean is=pref.getBoolean("ispname", false);
         String name = pref.getString("username", "");//得到保存的用户名
         if (is) {
        	  nameText.setText(name);//写入文本框
        	  checkbox.setChecked(true);
		}
       
//     或者    if (name.length()>0) {
//        	 checkbox.setChecked(true);
//		}else {	
//			checkbox.setChecked(false);
//		}
         
         button.setOnClickListener(new OnClickListener() {
       
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String name = nameText.getText().toString();
				String pwd = pwdText.getText().toString();
				if (name.equals("123")&&pwd.equals("321")) {
					Intent intent = new Intent(MainActivity.this, LoginActivity.class);
					intent.putExtra("chuandi", name);
					startActivity(intent);
					
					if (checkbox.isChecked()) {
						editor.putBoolean("ispname", true);
						editor.putString("username", name);//写入用户名
						editor.commit();//提交
					}
					else {
						editor.remove("username");
						editor.commit();//提交
					}
						
					
					
					
					
				}
				
				
				
			}
		});
         
    }
}
