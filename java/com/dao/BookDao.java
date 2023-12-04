package com.dao;

import java.awt.print.Book;
import java.util.ArrayList;

import com.pojo.BookShopPojo;

public interface BookDao {
	int insert(BookShopPojo bookpojo);

	ArrayList<BookShopPojo> selectAll();

	int update(BookShopPojo bookPojo);

	BookShopPojo selectById(int id);

	int delete(int id);

	ArrayList<BookShopPojo> requiredStock();

	ArrayList<BookShopPojo> availableStock();

	int updateQuantity(int id);
	
	ArrayList<BookShopPojo> searchWithName(String name);
}
