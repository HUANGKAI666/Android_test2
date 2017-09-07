package com.qidu.adapter;

import java.util.List;

import com.qidu.bean.Food;
import com.yanruqi.CatersSystem.R;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Tab1Adapter extends ArrayAdapter<Food> {
	private int resourceId;

	public Tab1Adapter(Context context,  int textViewResourceId,
			List<Food> objects) {
		super(context,  textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		resourceId = textViewResourceId;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Food fruit = getItem(position);
		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
			viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
			viewHolder.fruitprice = (TextView) view.findViewById(R.id.fruit_price);
			view.setTag(viewHolder);
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.fruitImage.setImageResource(fruit.getImageId());
		viewHolder.fruitName.setText(fruit.getName());
		viewHolder.fruitprice.setText("¥"+fruit.getPrice()+".00");
		return view;
	}
	class ViewHolder {
		
	

		TextView fruitprice;


		ImageView fruitImage;
		
		TextView fruitName;
		
		
	}

}
