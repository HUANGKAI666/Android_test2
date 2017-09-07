package com.qidu.activity;




import com.qidu.base.activity.ActivityCollector;
import com.qidu.bean.DbOpenHelper;
import com.qidu.bean.ShoppingCart;
import com.qidu.fragment.Tab1Fragment;
import com.qidu.fragment.Tab2Fragment;
import com.qidu.pay.activity.PayActivity;
import com.yanruqi.CatersSystem.R;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class DetailsActivity extends Activity {
	private String name;
	private String content;
	private int image;
	private String price;
	private TextView tv1;
	private TextView tv2;
	private TextView tv3;
	private ImageView image1;
	private Button bt1,pay,cart_check;
	private Editor edit;

	private SQLiteDatabase dbread;  
	private LinearLayout call;
	private LinearLayout collection;
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_details);
		
		ActivityCollector.addActivity(this);
		
		name = getIntent().getStringExtra("name");
		content = getIntent().getStringExtra("content");
		image = getIntent().getIntExtra("image", image);
		price = getIntent().getStringExtra("price");	
		tv1 = (TextView) findViewById(R.id.tv_details1);
		tv2 = (TextView) findViewById(R.id.tv_details2);
		tv3 = (TextView) findViewById(R.id.tv_details3);
		image1 = (ImageView) findViewById(R.id.img_details1);
		bt1 = (Button) findViewById(R.id.bt_details);
		
		call = (LinearLayout) findViewById(R.id.calls);
		collection = (LinearLayout) findViewById(R.id.collection);
		
		
		pay = (Button) findViewById(R.id.pay);
		cart_check =(Button) findViewById(R.id.cart_check);
		tv1.setText(name);
		tv2.setText(content);
		tv3.setText("¥"+price+".00");
		image1.setImageResource(image);
		
		
		pay.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				
			
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("weixin://wap/pay?"));
				startActivity(intent);
			}
		});
		
		
		call.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				
				String string = "";
				
				 Intent intent = new Intent();
		            //3.把动作封装至意图对象中
		            intent.setAction(Intent.ACTION_CALL );
		            //4.打给谁
		            intent.setData(Uri.parse("tel:" + string));
		            //5.告诉系统
		            startActivity(intent);		
			}
		});
		
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

	 
	                
//	              ContentValues values=new ContentValues();  
//	              values.put("image",image);  
//	              values.put("name",name);  
//	              values.put("content",content);  
//	              values.put("price", price); 
//	              dbread.insert("tb_shopping", null, values);  
				
	              ShoppingCart s = new ShoppingCart();
	              s.setImage(image);
	              s.setContent(content);
	              s.setName(name);
	              s.setPrice(price);
	              s.save();


				
				
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

