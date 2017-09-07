package com.example.text_fragmentpageradapter;

import java.util.ArrayList;
import java.util.List;




import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class Fragment1 extends Fragment{
	private View rootView;
	private ListView listView;
	private List<Fruit> fruitList = new ArrayList<Fruit>();

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView = inflater.inflate(R.layout.view1, container, false);
		return rootView;
	}
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initFruits();
		FruitAdapter adapter = new FruitAdapter(getActivity(), fruitList);
//		FruitAdapter adapter =new FruitAdapter(getActivity(), R.layout.fruit_item,fruitList);
		listView = (ListView) rootView.findViewById(R.id.view1);
		listView.setAdapter(adapter);
		
	}
	
	private void initFruits() {
	
		Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
		fruitList.add(banana);
		fruitList.add(banana);fruitList.add(banana);
		fruitList.add(banana);fruitList.add(banana);fruitList.add(banana);
		fruitList.add(banana);fruitList.add(banana);fruitList.add(banana);
		fruitList.add(banana);
		fruitList.add(banana);fruitList.add(banana);
		fruitList.add(banana);fruitList.add(banana);fruitList.add(banana);
		fruitList.add(banana);fruitList.add(banana);fruitList.add(banana);
	
		
	
	}
}
