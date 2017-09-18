package by.itacademy.catalog.web.command.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.itacademy.catalog.domain.entity.Book;
import by.itacademy.catalog.domain.vo.Catalog;
import by.itacademy.catalog.service.CatalogService;
import by.itacademy.catalog.service.impl.SimpleCatalogImpl;
import by.itacademy.catalog.web.command.BasicAction;

public class DeleteBookCheckbox implements BasicAction{
 
	private CatalogService service = new SimpleCatalogImpl(); 
	
	@Override
	public String executeAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Catalog catalog = service.getCatalog();
		PrintWriter out = response.getWriter();
		
		out.println("<html><head></head><body>"
				+ "<p><b>Choose a book you want to delete</b></p> "+
				"<form action='MainServlet' method='GET'>"
				);
		
		for (Book book : catalog.getBooks()) {		
		
		out.println("<br><input type='checkbox' name='book_id' value='" + book.getId()+"'>"+book.getId()+": "+book.getTitle());
		
		}
		
		out.println("<p><input type='hidden' name='command' value='delete_book_checkbox_action'>"
				+ "<input type='submit' value='delete' />"
				+ "</form></body></html>");
		
		return null;
	}

}
