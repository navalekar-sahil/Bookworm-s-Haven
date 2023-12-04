package com.pojo;

public class BookShopPojo {
	private int id;
	private String name;
	private String auther;
	private String edition;
	private double price;
	private boolean isavailable;
	private int quantity;
	private String date;
	/**
	 * @param id
	 * @param name
	 * @param auther
	 * @param edition
	 * @param price
	 * @param isavailable
	 */
	public BookShopPojo(int id, String name, String auther, String edition, double price, boolean isavailable,int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.auther = auther;
		this.edition = edition;
		this.price = price;
		this.isavailable = isavailable;
		this.quantity=quantity;
	}
	public BookShopPojo(int id, String name, String auther, String edition, double price,int quantity,String date) {
		super();
		this.id = id;
		this.name = name;
		this.auther = auther;
		this.edition = edition;
		this.price = price;
		this.quantity=quantity;
		this.date=date;
	}
	/**
	 * @param name
	 * @param auther
	 * @param edition
	 * @param price
	 * @param isavailable
	 */
	public BookShopPojo(String name, String auther, String edition, double price, boolean isavailable,int quantity) {
		super();
		this.name = name;
		this.auther = auther;
		this.edition = edition;
		this.price = price;
		this.isavailable = isavailable;
		this.quantity=quantity;
	}

	public BookShopPojo() {
		super();
	}
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAuther() {
		return auther;
	}
	public String getEdition() {
		return edition;
	}
	public double getPrice() {
		return price;
	}
	public boolean isIsavailable() {
		return isavailable;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setIsavailable(boolean isavailable) {
		this.isavailable = isavailable;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
}
