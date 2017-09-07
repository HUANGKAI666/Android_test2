package com.example.test_listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.Duration;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;

//两个监听器 监听点击事件 和 监听滚动变化
public class MainActivity extends ActionBarActivity implements OnItemClickListener,OnScrollListener {
	private SimpleAdapter simplelist;
	private List<Map<String,Object>> datalist;
	private ListView listview;
	//private ArrayAdapter<String> arr_adapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		ListView list =(ListView) findViewById(R.id.listView1);
		//适配器加载数据
		//String[] arr_data={"111","111","111"};
		//arr_adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr_data);
		datalist = new ArrayList<Map<String,Object>>();
		simplelist = new SimpleAdapter(this,getdata(), R.layout.item, new String[]{"imageView1",
			"textView1","textView2"},new int[]{R.id.imageView1,R.id.textView1,R.id.textView2});
		//视图加载适配器
		list.setAdapter(simplelist);
		//list.setAdapter(arr_adapter);
		list.setOnItemClickListener(this);
		list.setOnScrollListener(this);
		//创建上下文菜单
		this.registerForContextMenu(list);
	
		
	}
	private List<Map<String,Object>> getdata(){
		
		for (int i = 0; i < 20; i++) {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("imageView1",R.drawable.ic_launcher);
			map.put("textView1","TextView11111");
			map.put("textView2","TextView11111");
			datalist.add(map);
			
		}
		return datalist;
		
		
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// TODO Auto-generated method stub
		switch (scrollState) {
		case SCROLL_STATE_FLING:
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("imageView1",R.drawable.ic_launcher);
			map.put("textView1","11111");
			map.put("textView2","22222");
			datalist.add(map);
			simplelist.notifyDataSetChanged();
			break;

		}
	}
	@Override
	public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
		Toast.makeText(this,"1111",Toast.LENGTH_SHORT).show();
	}
	
	//上下文菜单
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
	menu.setHeaderTitle("操作");
	menu.setHeaderIcon(R.drawable.ic_launcher);
	//动态代码创建  
	//groupid   itemid 顺序  显示的数据
//	menu.add(1, 1, 1, "1");
//	menu.add(1, 2, 1, "2");
//	menu.add(1, 3, 1, "3");
//	menu.add(1, 4, 1, "4");

	//布局创建    menu文件里配置item
		MenuInflater inflater = new MenuInflater(this);
		inflater.inflate(R.menu.main, menu);
	}
	//点击事件
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.item_1://1
			Toast.makeText(this, "我是"+item, Toast.LENGTH_SHORT).show();
			break;
		case R.id.item_2://2
			Toast.makeText(this, "我是"+item, Toast.LENGTH_SHORT).show();
			break;
		case R.id.item_3:
			Toast.makeText(this, "我是"+item, Toast.LENGTH_SHORT).show();
			break;
		case R.id.item_4:
			Toast.makeText(this, "我是"+item.getItemId(), Toast.LENGTH_SHORT).show();
			break;
		
		}
		return super.onContextItemSelected(item);
		
	}
}