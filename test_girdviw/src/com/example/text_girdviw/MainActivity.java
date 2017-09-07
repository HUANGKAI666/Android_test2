package com.example.text_girdviw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {
	private List<Map<String, Object>> datalist;
	private GridView gridview;
	private SimpleAdapter adapter;
	private int[]img = {R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
	private String[]iconName = {"天气6","天气1","天气6","天气1","天气6","天气1","天气6","天气1","天气6","天气1","天气6","天气1"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		gridview = (GridView) findViewById(R.id.gridView1);
		datalist = new ArrayList<Map<String,Object>>();
		adapter = new SimpleAdapter(this, getData(), R.layout.itme, new String[]{"imageView1",
			"textView1"},new int[]{R.id.imageView1,R.id.textView1});
		gridview.setAdapter(adapter);
		gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(this, "我是"+iconName[arg2], Toast.LENGTH_SHORT).show();
			}
		});                    
//		gridview.setOnItemClickListener(this);
	}
	private  List<Map<String, Object>> getData() {
	 
		
		for (int i = 0; i < iconName.length; i++) {
			Map<String, Object> map= new HashMap<String, Object>();
			map.put("imageView1",img[i]);
			map.put("textView1", iconName[i]);
			datalist.add(map);
			
		}
		
		return datalist;
	
		
	}
	
//	@Override
//	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//		// TODO Auto-generated method stub
//		Toast.makeText(this, "我是"+iconName[arg2], Toast.LENGTH_SHORT).show();
//	}
}