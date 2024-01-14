package org.ashokit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ashokit.model.BookModel;
import org.ashokit.service.BookDao;
@WebServlet("/book")
public class BookServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookDao bookdao=new BookDao();
		List<BookModel> books=bookdao.getBooks();
		 
		req.setAttribute("books", books);
		RequestDispatcher rd=req.getRequestDispatcher("/view.jsp");
		rd.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//capture form data
		String name=req.getParameter("name");
		String price=req.getParameter("price");
		String author=req.getParameter("author");
		
		//save form data to bookmodel object for transfer
		BookModel book=new BookModel(); 
		book.setBookName(name);
		book.setBookPrice(Double.parseDouble(price));
		book.setBookAuthor(author);
		
		//calling dao method
		BookDao dao=new BookDao();
		boolean status=dao.saveBook(book);
		String msg=null;
		if(status) 
			msg="Book details saved...";
		else
			msg="Book details is not saved !!!";
		
		req.setAttribute("msg", msg);
		RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");
		rd.forward(req, resp);
		
	}

}
