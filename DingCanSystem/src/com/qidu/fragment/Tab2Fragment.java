package com.qidu.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.qidu.activity.DetailsActivity;
import com.qidu.adapter.Tab1Adapter;
import com.qidu.adapter.Tab2Adapter;
import com.qidu.adapter.Tab2Adapter.ViewHolder;
import com.qidu.bean.DbOpenHelper;
import com.qidu.bean.Food;
import com.qidu.bean.ShoppingCart;
import com.yanruqi.CatersSystem.R;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RadioButton;
import android.widget.TextView;

public class Tab2Fragment extends Fragment{
	final List<ShoppingCart> ShoppingCartList = new ArrayList<ShoppingCart>();
	private ListView listView;
	private View rootView;
	private ShoppingCart sh ;
	private SQLiteDatabase dbread;  
	private Tab2Adapter adapter;
	private RadioButton rb;
    private int num = 0;
    private int pric = 0;
    private int flag = 0;
  
    private TextView tv_money;
    private Button bt_money;
    String id;
    
    final List<HashMap<String,Object>> ids =new ArrayList<HashMap<String,Object>>();

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView = inflater.inflate(R.layout.tab02, container, false);
		return rootView;
	}
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		listView = (ListView) rootView.findViewById(R.id.list_view2);	
		initRadioButton(listView);
		super.onActivityCreated(savedInstanceState);

	}
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		
		

	    if (ShoppingCartList.size() > 0) {  
	    	ShoppingCartList.removeAll(ShoppingCartList);  
            adapter.notifyDataSetChanged();  
            listView.setAdapter(adapter);  
        }  
	 adapter = new Tab2Adapter(getActivity(), R.layout.tab02_item, 
			getData());

	listView.requestLayout();
	adapter.notifyDataSetChanged();
	listView.setAdapter(adapter);
		super.onResume();
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	 private List<ShoppingCart> getData() {  
		 DbOpenHelper db = new DbOpenHelper(getActivity());
		 dbread = db.getReadableDatabase();  
		  
	        Cursor cursor = dbread.query("tb_shopping", null, null, null, null,  
	                null, null);  
	 
	        while (cursor.moveToNext()) {
	        	    id = cursor.getString(cursor.getColumnIndex("_id"));  
	        	   String name_data = cursor.getString(cursor.getColumnIndex("name"));  
	               String content_data = cursor.getString(cursor.getColumnIndex("content")); 
	               String price_data = cursor.getString(cursor.getColumnIndex("price"));  
	               int image_data = cursor.getInt(cursor.getColumnIndex("image"));
	               sh = new ShoppingCart();
	               sh.setName(name_data);
	               sh.setContent(content_data);
	               sh.setPrice(price_data);
	               sh.setImage(image_data);
							
				ShoppingCartList.add(sh);
				
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("_id", id);
				ids.add(map);

	        }  
	        cursor.close();  
	        return ShoppingCartList;  
	  
	    }  
	 private void initRadioButton(final ListView listView) {
			// TODO Auto-generated method stub
			rb = (RadioButton) rootView.findViewById(R.id.radioButton2);
			tv_money = (TextView) rootView.findViewById(R.id.money);
			bt_money = (Button) rootView.findViewById(R.id.cart_check);
			
			rb.setOnClickListener( new OnClickListener() {
		
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					flag++;
					if (flag%2!=0) {
						 num = 0;
			                pric = 0;
			                rb.setChecked(true);			          

			                for (int i = 0; i < ShoppingCartList.size(); i++) {
			                    // 改变boolean
			                	ShoppingCartList.get(i).setBo(true);
			                    // 如果为选中
			                    if (ShoppingCartList.get(i).getBo()) {
			                        num++;
			                        pric += Integer.parseInt(ShoppingCartList.get(i).getPrice());

			                    }
			                }
			                // 刷新
			                adapter.notifyDataSetChanged();
			                // 显示
			                tv_money.setText("￥"+pric);
			                bt_money.setText("去结算"+"("+num+")");
						
					} else {
						num = 0;
		                pric = 0;
		                rb.setChecked(false);

		                for (int i = 0; i < ShoppingCartList.size(); i++) {
		                    // 改变boolean
		                	ShoppingCartList.get(i).setBo(false);
		                    // 如果为选中
		                
		                }
		                // 刷新
		                adapter.notifyDataSetChanged();
		                // 显示
		                tv_money.setText("￥"+pric);
		                bt_money.setText("去结算"+"("+num+")");
						

					}				            
					
				}
			});
			bt_money.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					
					
				
					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_VIEW);
					intent.setData(Uri.parse("weixin://wap/pay?"));
					startActivity(intent);
				}
			});
			listView.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						final int position, long id) {
					 ViewHolder viewHolder = (ViewHolder) view.getTag();

							 if (ShoppingCartList.get(position).getBo()==true ){
										
									 ShoppingCartList.get(position).setBo(false);
				
									} else {
										ShoppingCartList.get(position).setBo(true);

									}
					
            
		            	if (viewHolder.rb.isChecked() == false) {
		                    num++;
		                    pric += Integer.parseInt(ShoppingCartList.get(position).getPrice());
		                } else {
		                    num--;
		                    pric -= Integer.parseInt(ShoppingCartList.get(position).getPrice());
		                }
		            
						
		            	
		            	
		            	 adapter.notifyDataSetChanged();
		                // 用TextView显示
		                tv_money.setText("￥"+pric);
		                bt_money.setText("去结算"+"("+num+")");
						
					
					
				
			
				
				}
			});
			listView.setOnItemLongClickListener(new OnItemLongClickListener() {

				@Override
				public boolean onItemLongClick(AdapterView<?> parent,
						View view, final int position,  long id) {
					// TODO Auto-generated method stub
					AlertDialog.Builder	alertDialog = new AlertDialog.Builder(getActivity());
					//alertDialog.setIcon(R.drawable.ic_launcher);
					alertDialog.setTitle("确认删除订单？");
					alertDialog.setMessage("删除之后可以从电脑端订单回收站恢复");
					alertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							 DbOpenHelper db = new DbOpenHelper(getActivity());
							 dbread = db.getReadableDatabase();  
							 int idd = Integer.valueOf(ids.get(position).get("_id").toString());
							 String[] selectionArs = new String[]{String.valueOf(idd)};
						        int cursor = dbread.delete("tb_shopping","_id=?", selectionArs);
	
							//因为不自动更新 所以使用rome把它的listview界面先移除
						
						        ShoppingCartList.remove(position);
						        listView.requestLayout();
							adapter.notifyDataSetChanged();
						}
					});
					alertDialog.setNegativeButton("取消",null);

					alertDialog.show();
					
					
					return false;
				}
				
			});
			
		}
	

}
