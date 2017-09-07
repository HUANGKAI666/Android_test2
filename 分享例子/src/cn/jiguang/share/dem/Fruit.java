package cn.jiguang.share.dem;

public class Fruit {

	private String name;

	private int imageId;

	public Fruit(String name, int imageId) {
		this.name = name;
		this.imageId = imageId;
	}

	public Fruit() {
	
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getName() {
		return name;
	}

	public int getImageId() {
		return imageId;
	}

}
