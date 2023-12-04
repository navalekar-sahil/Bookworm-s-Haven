package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BookShopModel;
import com.pojo.BookShopPojo;

//import jakarta.servlet.RequestDispatcher;

import javax.servlet.*;
//import jakarta.servlet.RequestDispatcher;

@WebServlet("/book")
public class BookShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookShopModel bookShopModel = new BookShopModel();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "add": {
			RequestDispatcher dispatcher = request.getRequestDispatcher("addBook.html");
			dispatcher.forward(request, response);
			break;
		}
		case "list": {
			ArrayList<BookShopPojo> list = bookShopModel.selectAll();
			request.setAttribute("list", list);

			RequestDispatcher dispatcher = request.getRequestDispatcher("bookList.jsp");
			dispatcher.forward(request, response);
			break;
		}
		case "sale": {
			int id = Integer.parseInt(request.getParameter("id"));
			BookShopPojo list = bookShopModel.selectById(id);
			request.setAttribute("list", list);

			if (list.getQuantity() > 0) {
				int res = bookShopModel.updateQuantity(id);
				if (res > 0) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("sale.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Book is not Available');");
				out.println("</script>");

			}

			break;
		}
		case "edit": {
			int id = Integer.parseInt(request.getParameter("id"));
			BookShopPojo list = bookShopModel.selectById(id);
			request.setAttribute("list", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
			dispatcher.forward(request, response);
			break;
		}
		case "delete": {
			int id = Integer.parseInt(request.getParameter("id"));
			int res = bookShopModel.delete(id);
			if (res > 0) {
				response.sendRedirect("book?action=list");
			}
			break;
		}
		case "requiredStock": {

			ArrayList<BookShopPojo> requiredlist = bookShopModel.requiredStock();
			request.setAttribute("list1", requiredlist);
			RequestDispatcher dispatcher = request.getRequestDispatcher("required_Stock.jsp");
			dispatcher.forward(request, response);
			break;
		}
		case "salelist": {

			ArrayList<BookShopPojo> requiredlist = bookShopModel.saleList();
			request.setAttribute("list2", requiredlist);
			RequestDispatcher dispatcher = request.getRequestDispatcher("saleList.jsp");
			dispatcher.forward(request, response);
			break;
		}
		case "availableStock": {

			ArrayList<BookShopPojo> requiredlist = bookShopModel.availableStock();
			request.setAttribute("list2", requiredlist);
			RequestDispatcher dispatcher = request.getRequestDispatcher("availableStock.jsp");
			dispatcher.forward(request, response);
			break;
		}
		case "find":{
			RequestDispatcher dispatcher = request.getRequestDispatcher("searchingbook.html");
			dispatcher.forward(request, response);
			break;
		}
		case "searchBook": {
			String name = request.getParameter("searchedBookName");
			System.out.println(name);

			ArrayList<BookShopPojo> requiredlist = bookShopModel.searchWithName(name);

			request.setAttribute("list2", requiredlist);
			RequestDispatcher dispatcher = request.getRequestDispatcher("searchBook.jsp");
			dispatcher.forward(request, response);
			break;
		}
		default: {
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "add": {
			String name = request.getParameter("bookName");
			String auther = request.getParameter("auther");
			String edition = request.getParameter("edition");
			Double price = Double.parseDouble(request.getParameter("price"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			System.out.println(name + auther + edition);
			boolean isavailable = true;

			int res = bookShopModel.insert(new BookShopPojo(name, auther, edition, price, isavailable, quantity));
			if (res > 0) {
				response.sendRedirect("index.html");
			}

			break;
		}
		case "edit": {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("bookName");
			String auther = request.getParameter("auther");
			String edition = request.getParameter("edition");
			Double price = Double.parseDouble(request.getParameter("price"));
			boolean isavailable = Boolean.parseBoolean(request.getParameter("isAvailable"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));

			int res = bookShopModel.update(new BookShopPojo(id, name, auther, edition, price, isavailable, quantity));
			if (res > 0) {
				response.sendRedirect("book?action=list");
			}
			break;
		}
		case "sale": {

			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("bookName");
			String auther = request.getParameter("author");
			String edition = request.getParameter("edition");
			Double price = Double.parseDouble(request.getParameter("price"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			String date = request.getParameter("date");

			BookShopPojo bookShopPojo = new BookShopPojo(id, name, auther, edition, price, quantity, date);
			int res = bookShopModel.insetInSell(bookShopPojo);
			if (res > 0) {
				response.sendRedirect("book?action=list");
			}
			break;
		}
		case "searchBook": {
			String name = request.getParameter("searchedBookName");
			System.out.println(name);

			ArrayList<BookShopPojo> requiredlist = bookShopModel.searchWithName(name);
			request.setAttribute("list2", requiredlist);
			RequestDispatcher dispatcher = request.getRequestDispatcher("searchBook.jsp");
			dispatcher.forward(request, response);
			break;
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
	}

}
