package com.example.test_notifica;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends Activity implements OnClickListener{
	int notification_ID;
	NotificationManager manager; //֪ͨ������  ��״̬��֪ͨ�Ĺ����࣬����֪ͨ�����֪ͨ�ȡ�
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button bt1 = (Button) findViewById(R.id.button1);
		Button bt2= (Button) findViewById(R.id.button2);
		Button bt3= (Button) findViewById(R.id.button4);
		manager =(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		
		bt1.setOnClickListener(this);
		bt2.setOnClickListener(this);
		bt3.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.button1:
			send();
			break;

		case R.id.button2:
			manager.cancel(notification_ID);
			break;
		case R.id.button4:
			Dialog();//�Ի���
			break;
		}
	}
	
	
	
	
//�Ի���
	private void Dialog() {
		// TODO Auto-generated method stub
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("ȷ�϶Ի���");
		builder.setIcon(R.drawable.ic_launcher);
		builder.setMessage("ȷ�϶Ի�������");
		builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "ȷ��", Toast.LENGTH_LONG).show();
			}
		});
		builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "ȡ��", Toast.LENGTH_LONG).show();
			}
		});
		
		builder.show();
	
	
			
			
	}
	
	
	
	
	

	private void send() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this,MainActivity.class);
		PendingIntent pinter = PendingIntent.getActivity(this,0, intent,0);
		
		Notification.Builder buider = new Notification.Builder(this);
		buider.setSmallIcon(R.drawable.ic_launcher);
		buider.setTicker("hello");
		buider.setWhen(System.currentTimeMillis());
		buider.setContentTitle("֪ͨ��֪ͨ");
		buider.setContentText("�����Ա���");
		buider.setDefaults(Notification.DEFAULT_ALL);
		buider.setContentIntent(pinter);//��������ͼ
		
		Notification notification =buider.build();//��ȡnotification
		
		manager.notify(notification_ID, notification);


	}
	
	

		
	
	

	
}
