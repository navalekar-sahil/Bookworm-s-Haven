package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.BookDao;
import com.pojo.BookShopPojo;

public class BookShopModel implements BookDao {

	static Connection connection = DbConnection.getConnection();

	@Override
	public int insert(BookShopPojo bookpojo) {
		String query = "insert into books(name,auther,edition,price,isavailable,quantity) values(?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bookpojo.getName());
			preparedStatement.setString(2, bookpojo.getAuther());
			preparedStatement.setString(3, bookpojo.getEdition());
			preparedStatement.setDouble(4, bookpojo.getPrice());
			preparedStatement.setBoolean(5, bookpojo.isIsavailable());
			preparedStatement.setInt(6, bookpojo.getQuantity());

			int response = preparedStatement.executeUpdate();
			return response;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<BookShopPojo> selectAll() {
		ArrayList<BookShopPojo> list = new ArrayList();
		String query = "select * from books";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getInt(7) == 0) {
					update_isavailable();
				}
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String auther = resultSet.getString(3);
				String edition = resultSet.getString(4);
				double price = resultSet.getDouble(5);
				boolean isavailable = resultSet.getBoolean(6);
				int quantity = resultSet.getInt(7);
				BookShopPojo bookShopPojo = new BookShopPojo(id, name, auther, edition, price, isavailable, quantity);
				list.add(bookShopPojo);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(BookShopPojo bookPojo) {
		String query = "update books set name=?,auther=?,edition=?,price=?,isavailable=?,quantity=? where id=? ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bookPojo.getName());
			preparedStatement.setString(2, bookPojo.getAuther());
			preparedStatement.setString(3, bookPojo.getEdition());
			preparedStatement.setDouble(4, bookPojo.getPrice());
			preparedStatement.setBoolean(5, bookPojo.isIsavailable());
			preparedStatement.setInt(6, bookPojo.getQuantity());
			preparedStatement.setInt(7, bookPojo.getId());

			int res = preparedStatement.executeUpdate();
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public BookShopPojo selectById(int id) {
		String query = "select * from books where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				int id1 = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String auther = resultSet.getString(3);
				String edition = resultSet.getString(4);
				double price = resultSet.getDouble(5);
				boolean isavailable = resultSet.getBoolean(6);
				int quantity = resultSet.getInt(7);

				BookShopPojo bookShopPojo = new BookShopPojo(id1, name, auther, edition, price, isavailable, quantity);
				return bookShopPojo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int delete(int id) {
		String query = "delete from books where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int response = preparedStatement.executeUpdate();
			return response;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public void update_isavailable() {
		String query = "update books set isavailable=0 where quantity=0";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			int res = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<BookShopPojo> requiredStock() {
		ArrayList<BookShopPojo> list = new ArrayList();
		String query = "select * from books";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getInt("quantity") <= 2) {

					int id = resultSet.getInt(1);
					String name = resultSet.getString(2);
					String auther = resultSet.getString(3);
					String edition = resultSet.getString(4);
					double price = resultSet.getDouble(5);
					boolean isavailable = resultSet.getBoolean(6);
					int quantity = resultSet.getInt(7);
					BookShopPojo bookShopPojo = new BookShopPojo(id, name, auther, edition, price, isavailable,
							quantity);
					list.add(bookShopPojo);
				}
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<BookShopPojo> availableStock() {
		ArrayList<BookShopPojo> list = new ArrayList();
		String query = "select * from books";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getInt("quantity") > 0) {

					int id = resultSet.getInt(1);
					String name = resultSet.getString(2);
					String auther = resultSet.getString(3);
					String edition = resultSet.getString(4);
					double price = resultSet.getDouble(5);
					boolean isavailable = resultSet.getBoolean(6);
					int quantity = resultSet.getInt(7);
					BookShopPojo bookShopPojo = new BookShopPojo(id, name, auther, edition, price, isavailable,
							quantity);
					list.add(bookShopPojo);
				}
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateQuantity(int id) {
		String query = "update books set quantity=quantity-1 where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int response = preparedStatement.executeUpdate();
			return response;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int insetInSell(BookShopPojo bookpojo) {
		String query = "insert into sale(id,name,auther,date,edition,price,quantity_lef) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, bookpojo.getId());
			preparedStatement.setString(2, bookpojo.getName());
			preparedStatement.setString(3, bookpojo.getAuther());
			preparedStatement.setString(4, bookpojo.getDate());
			preparedStatement.setString(5, bookpojo.getEdition());
			preparedStatement.setDouble(6, bookpojo.getPrice());
			preparedStatement.setInt(7, bookpojo.getQuantity());

			int response = preparedStatement.executeUpdate();
			return response;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<BookShopPojo> saleList() {
		ArrayList<BookShopPojo> list = new ArrayList();
		String query = "select * from sale";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String date = resultSet.getString(3);

				String auther = resultSet.getString(4);
				String edition = resultSet.getString(5);
				double price = resultSet.getDouble(6);

				int quantity = resultSet.getInt(7);
				BookShopPojo bookShopPojo = new BookShopPojo(id, name, auther, edition, price, quantity, date);
				list.add(bookShopPojo);

			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<BookShopPojo> searchWithName(String name) {
		ArrayList<BookShopPojo> list = new ArrayList();
		String query = "select * from books where name=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String name1 = resultSet.getString(2);
				String date = resultSet.getString(3);
				String auther = resultSet.getString(4);
				String edition = resultSet.getString(5);
				double price = resultSet.getDouble(6);
				int quantity = resultSet.getInt(7);
				BookShopPojo bookShopPojo = new BookShopPojo(id, name1, auther, edition, price, quantity, date);
				list.add(bookShopPojo);

			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
