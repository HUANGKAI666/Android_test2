package com.qidu.adapter;

import java.util.List;

import com.qidu.bean.ShoppingCart;
import com.yanruqi.CatersSystem.R;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class Tab2Adapter extends ArrayAdapter<ShoppingCart> {
	private int resourceId;

	public Tab2Adapter(Context context,  int textViewResourceId,
			List<ShoppingCart> objects) {
		super(context,  textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		resourceId = textViewResourceId;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final ShoppingCart shoppingCart = getItem(position);
		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.shoppingCartImage = (ImageView) view.findViewById(R.id.shopping_image);
			viewHolder.shoppingCartName = (TextView) view.findViewById(R.id.shopping_name);
			viewHolder.shoppingCartprice = (TextView) view.findViewById(R.id.shopping_price);
			viewHolder.rb=(RadioButton) view.findViewById(R.id.radioButton1); 
			view.setTag(viewHolder);
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.shoppingCartImage.setImageResource(shoppingCart.getImage());
		viewHolder.shoppingCartName.setText(shoppingCart.getName());
		viewHolder.shoppingCartprice.setText("￥"+shoppingCart.getPrice()+".00");
		viewHolder.rb.setChecked(shoppingCart.getBo());

		return view;
	}
	public class ViewHolder {
		
	

		TextView shoppingCartprice;
		public RadioButton rb;

		public ImageView shoppingCartImage;
		
		public TextView shoppingCartName;
		
		
	}

}
