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

public class DeleteBookCheckboxAction implements BasicAction {

	private CatalogService service = new SimpleCatalogImpl();

	@Override
	public String executeAction(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();
		out.println("The books will be deleted");

		
		String book_id = request.getParameter("book_id");
		
		System.out.println(book_id);
		
		Catalog catalog = service.getCatalog();
		for (Book book : catalog.getBooks()) {
			String temp = request.getParameter("book_id" + book.getId());
			if (temp != null) {
				service.removeBookCheckbox(book.getId());
			}
		}

		return null;
	}

}
