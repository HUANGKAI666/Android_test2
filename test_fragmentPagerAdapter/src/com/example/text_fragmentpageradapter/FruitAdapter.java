package com.example.text_fragmentpageradapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//public class FruitAdapter extends ArrayAdapter<Fruit> {
//
//	private int resourceId;
//
//	public FruitAdapter(Context context, int textViewResourceId,
//			List<Fruit> objects) {
//		super(context, textViewResourceId, objects);
//		resourceId = textViewResourceId;
//	}
//
//	@Override
//	public View getView(int position, View convertView, ViewGroup parent) {
//		Fruit fruit = getItem(position);
//		View view;
//		ViewHolder viewHolder;
//		if (convertView == null) {
//			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
//			viewHolder = new ViewHolder();
//			viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
//			viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
//			view.setTag(viewHolder);
//		} else {
//			view = convertView;
//			viewHolder = (ViewHolder) view.getTag();
//		}
//		viewHolder.fruitImage.setImageResource(fruit.getImageId());
//		viewHolder.fruitName.setText(fruit.getName());
//		return view;
//	}
//	
//	class ViewHolder {
//		
//		ImageView fruitImage;
//		
//		TextView fruitName;
//		
//	}
//
//}

public class FruitAdapter extends BaseAdapter{
	private List<Fruit> fruitList;
	private LayoutInflater inflater;
	public FruitAdapter(Context context, List<Fruit> fruitList){
		this.fruitList = fruitList;
		inflater = LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fruitList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return fruitList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Fruit f = fruitList.get(position);
		ViewHolder vh = null;
		if (convertView == null) {
			vh =new ViewHolder();
			convertView = inflater.inflate(R.layout.fruit_item, parent,false);
		vh.im = (ImageView) convertView.findViewById(R.id.fruit_image);
		vh.tx = (TextView) convertView.findViewById(R.id.fruit_name);
		convertView.setTag(vh);
		}else {
			vh = (ViewHolder) convertView.getTag();
		}
		vh.im.setImageResource(f.getImageId());
		vh.tx.setText(f.getName());
		
		return convertView;
	}
	private final class ViewHolder {
		
		TextView tx;
		ImageView im;
		
	}
	
	
	
}