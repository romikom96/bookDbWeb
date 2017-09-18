package by.itacademy.catalog.dao;

import java.util.List;

import by.itacademy.catalog.domain.entity.Book;

public interface BookDao {

	List<Book> readBooks();

	void deleteBook(int bookId);

	void addBook(Book book);
	
	void deleteBookCheckbox(int bookId);

}
