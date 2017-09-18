package by.itacademy.catalog.web.command.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.itacademy.catalog.domain.entity.Book;
import by.itacademy.catalog.service.CatalogService;
import by.itacademy.catalog.service.impl.SimpleCatalogImpl;
import by.itacademy.catalog.web.command.BasicAction;

public class AddBook implements BasicAction {

	private CatalogService service = new SimpleCatalogImpl();

	@Override
	public String executeAction(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();		
		out.print("<html><head></head><body>"
				+ "<p>The book will be added</p>"
				+ "</body></html>");
		
		Book book = new Book();
		service.addBook(book);
		
		return null;

	}

}