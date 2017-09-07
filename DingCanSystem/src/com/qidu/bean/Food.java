package com.qidu.bean;

public class Food {
	private String name;
	private String content;
	private String  price;
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	private int imageId;

	public Food(String name, int imageId) {
		this.name = name;
		this.imageId = imageId;
	}
	
	public Food(String name,String content, int imageId,String  price) {
		this.name = name;
		this.content = content;
		this.imageId = imageId;
		this.price  = price;
	}

	public String getName() {
		return name;
	}

	public int getImageId() {
		return imageId;
	}

	public String getContent() {
		return content;
	}
}
