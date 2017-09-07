package com.qidu.bean;

import org.litepal.crud.DataSupport;

public class ShoppingCart extends DataSupport{
	private String name;
	private String content;
	private String  price;
	private int  image;
	boolean bo;
	
	public void setBo(boolean bo) {
		this.bo = bo;
	}
	public boolean getBo() {
		return bo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getImage() {
		return image;
	}
	public void setImage(int image) {
		this.image = image;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
