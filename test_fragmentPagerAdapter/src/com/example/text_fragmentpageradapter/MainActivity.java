package com.example.text_fragmentpageradapter;
import java.util.ArrayList;
import java.util.List;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Window;
import android.widget.TextView;


public class MainActivity extends FragmentActivity{
	private List<Fragment> data;
	private myfragmentAdapter pagerAdapter;
	private ViewPager viewpager;
	private TextView t1;
	private TextView t2;
	private TextView t3;
	
	private TextView tab1;
	private TextView tab2;
	private TextView tab3;
	
//	private FragmentPagerAdapter pa;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		data = new ArrayList<Fragment>();
		viewpager = (ViewPager) findViewById(R.id.page);
		t2= (TextView) findViewById(R.id.textView2);
		t3= (TextView) findViewById(R.id.textView3);
		
		tab1= (TextView) findViewById(R.id.t1);
		tab2= (TextView) findViewById(R.id.t2);
		tab3= (TextView) findViewById(R.id.t3);
		
		
		
		Fragment1 f1  = new Fragment1();
		fragment2 f2  = new fragment2();
		fragment3 f3  = new fragment3();
		data.add(f1);
		data.add(f2);
		data.add(f3);
		
		
		
		
		
		pagerAdapter = new myfragmentAdapter(getSupportFragmentManager(), data);
//		pa = new FragmentPagerAdapter(getSupportFragmentManager()) {
//			
//			@Override
//			public int getCount() {
//				// TODO Auto-generated method stub
//				return data.size();
//			}
//			
//			@Override
//			public Fragment getItem(int arg0) {
//				// TODO Auto-generated method stub
//				return data.get(arg0);
//			}
//		};
		
		viewpager.setAdapter(pagerAdapter);
		viewpager.setCurrentItem(1);
		viewpager.setOnPageChangeListener(new OnPageChangeListener() {
			
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
					
			
				tab1.setTextColor(Color.parseColor("#000000"));
				tab2.setTextColor(Color.parseColor("#000000"));
				tab3.setTextColor(Color.parseColor("#000000"));
				
			switch (arg0) {
			case 0:
				tab1.setTextColor(Color.parseColor("#008000"));
				break;
			case 1:
				tab2.setTextColor(Color.parseColor("#008000"));
				break;
			case 2:
				tab3.setTextColor(Color.parseColor("#008000"));					
				break;				
			}
		
			
				
			}
			
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		
		
	}
}
