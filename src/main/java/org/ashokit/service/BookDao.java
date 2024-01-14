package org.ashokit.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.ashokit.model.BookModel;
import org.ashokit.util.ConnectionFactory;

public class BookDao {
	private static final String INSERT_SQL="Insert into book_info(book_name,book_price,author_name)values(?,?,?)";
	private static final String SELECT_SQL="Select * from book_info";
	public boolean saveBook(BookModel bm) {
		boolean isSaved=false;
		try {
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement pstmt=con.prepareStatement(INSERT_SQL);
			pstmt.setString(1,bm.getBookName());
			pstmt.setDouble(2, bm.getBookPrice());
			pstmt.setString(3, bm.getBookAuthor());
			int count=pstmt.executeUpdate();
			if(count>0)
				isSaved=true;
			else
				isSaved=false;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
				
	return isSaved;			
	}
	public List<BookModel> getBooks(){
		List<BookModel> books=new ArrayList<BookModel>();
		try {
			Connection con=ConnectionFactory.getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(SELECT_SQL);
			while(rs.next()) {
				BookModel book=new BookModel();
				book.setBookId(rs.getInt("book_id"));
				book.setBookName(rs.getString("book_name"));
				book.setBookPrice(rs.getDouble("book_price"));
				book.setBookAuthor(rs.getString("author_name"));
				
				//adding each book object to collection
				books.add(book);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		return books;
	}

}
