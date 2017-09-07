package com.example.datytime;

import java.util.Calendar;

import android.support.v7.app.ActionBarActivity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class MainActivity extends ActionBarActivity {
	private DatePicker datePicker;
	private TimePicker timePicker;
	private Calendar cal;
	private int year;
	private int month;
	private int day;
	private int hour;
	private int min;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.itme);
		//布局文件和变量的绑定
		datePicker = (DatePicker) findViewById(R.id.datePicker);
		timePicker = (TimePicker) findViewById(R.id.timePicker);
		//获取日历的一个对象
		cal = Calendar.getInstance();
		//获取年月日时分
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH)+1;
		day = cal.get(Calendar.DAY_OF_MONTH);
		hour = cal.get(Calendar.HOUR_OF_DAY);
		min = cal.get(Calendar.MINUTE);
		
        setTitle(year+"-"+month+"-"+day+"-"+hour+"-"+min);
        //datePicker初始化
//		datePicker.init(year, cal.get(Calendar.MONTH),day, new OnDateChangedListener() {
//			
//			@Override
//			public void onDateChanged(DatePicker view , int year, int month, int day) {
//				// TODO Auto-generated method stub
//				setTitle(year+"-"+(month+1)+"-"+day);
//			}
//		});
//		timePicker.setOnTimeChangedListener(new OnTimeChangedListener() {
//			
//			@Override
//			public void onTimeChanged(TimePicker arg0, int hour, int min) {
//				// TODO Auto-generated method stub
//				setTitle(hour+"-"+min);
//			}
//		});
	

		new DatePickerDialog(this, new OnDateSetListener() {
			
			@Override
			public void onDateSet(DatePicker arg0, int year, int month, int day) {
				// TODO Auto-generated method stub
				 setTitle(year+"-"+month+1+"-"+day+"-"+hour+"-"+min);
			}
		}, year, month, day).show();
		new TimePickerDialog(this, new OnTimeSetListener() {
			
			@Override
			public void onTimeSet(TimePicker arg0, int hour, int min) {
				// TODO Auto-generated method stub
				setTitle(hour+"-"+min);
			}
		}, hour, min, true).show();
	}


}