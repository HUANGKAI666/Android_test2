package com.qidu.activity;

import java.util.ArrayList;
import java.util.List;

import com.qidu.base.activity.ActivityCollector;
import com.qidu.fragment.Tab1Fragment;
import com.qidu.fragment.Tab2Fragment;
import com.yanruqi.CatersSystem.R;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends FragmentActivity{
	private ViewPager mViewPager;
	private List<Fragment> mList;
	private TextView chatTextView,friendTextView;
	private int sceen1_2;
	private ImageView tabline;
	private int mCurrentPage;
	private LinearLayout linTab1;
	private LinearLayout linTab2;
	private TextView tv;

	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        ActivityCollector.addActivity(this);
        
        initTab();
      

		
        chatTextView=(TextView) findViewById(R.id.id_tv_chat);
        friendTextView=(TextView) findViewById(R.id.id_tv_friend);
        linTab1 = (LinearLayout) findViewById(R.id.lin_tab1);
        linTab2 = (LinearLayout) findViewById(R.id.lin_tab2);
        tv = (TextView) findViewById(R.id.tvr_toolbar);
    	tv.setText("美食商城");
        
    	


        //寰楀埌ViewPager瀵硅薄
        mViewPager=(ViewPager) findViewById(R.id.id_viewpager);
        //鍒涘缓Fragment瀵硅薄鍒楄〃
linTab1.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mViewPager.setCurrentItem(0);
			}
		});
linTab2.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mViewPager.setCurrentItem(1);
			}
		});
        mList=new ArrayList<Fragment>();
        //鍒嗗埆鍒涘缓鎵�闇�瑕佺殑Fragement
        Tab1Fragment tab1Fragment = new Tab1Fragment();
        Tab2Fragment tab2Fragment = new Tab2Fragment();
     
        //鎶奆ragment瀵硅薄娣诲姞鍒板垪琛ㄤ腑
        mList.add(tab1Fragment);
        mList.add(tab2Fragment);
   
        //缁橵iewPager璁剧疆閫傞厤鍣�
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
		
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return mList.size();
			}
			
			@Override
			public Fragment getItem(int arg0) {
				// TODO Auto-generated method stub
			
				return mList.get(arg0);
			}
		});
        //缁橵iewPager娣诲姞椤甸潰鏀瑰彉鐩戝惉鍣�
        mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				resetTextViewColor();//閲嶇疆椤甸潰鏂囨湰鍒濆棰滆壊
				switch (arg0) {
				case 0:
					chatTextView.setTextColor(Color.parseColor("#FFFFFF"));
					tv.setText("美食排行");
					break;
				case 1:
					friendTextView.setTextColor(Color.parseColor("#FFFFFF"));
					tv.setText("我的订单");
					break;
						
				}
				mCurrentPage=arg0;
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				Log.d("tag", arg0+":"+arg1+":"+arg2);
				LayoutParams lp=(LayoutParams) tabline.getLayoutParams();
				if(arg0==0&&mCurrentPage==0){//0-1
					lp.leftMargin=(int) (arg1*sceen1_2+mCurrentPage*sceen1_2);
				}else if(arg0==0&&mCurrentPage==1){//1-0
					lp.leftMargin=(int) ((arg1-1)*sceen1_2+mCurrentPage*sceen1_2);
				}else if(arg0==1&&mCurrentPage==1){//1-2
					lp.leftMargin=(int) (arg1*sceen1_2+mCurrentPage*sceen1_2);
				}else if(arg0==1&&mCurrentPage==2){//2-1
					lp.leftMargin=(int) ((arg1-1)*sceen1_2+mCurrentPage*sceen1_2);
				}
				
				tabline.setLayoutParams(lp);
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
    }
    
    
    @Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		ActivityCollector.removeActivity(this);
	}









	private void initTab(){
    	 Display defaultDisplay = getWindow().getWindowManager().getDefaultDisplay();
         DisplayMetrics outMetrics = new DisplayMetrics();
 		 defaultDisplay.getMetrics(outMetrics);
 		 sceen1_2=outMetrics.widthPixels/2;
         tabline=(ImageView) findViewById(R.id.id_iv_tabline);
         LayoutParams lp=(LayoutParams) tabline.getLayoutParams();
         lp.width=sceen1_2;         
    }
    
    
    private void resetTextViewColor() {
    	chatTextView.setTextColor(Color.parseColor("#000000"));
    	friendTextView.setTextColor(Color.parseColor("#000000"));
    	
	}
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	// TODO Auto-generated method stub
    	ActivityCollector.finishAllActivities();
    	return super.onKeyDown(keyCode, event);
    }



		
	}
    
    

