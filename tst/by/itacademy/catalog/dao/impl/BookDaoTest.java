package by.itacademy.catalog.dao.impl;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import by.itacademy.catalog.dao.BookDao;

public class BookDaoTest {

	private static BookDao dao;
	
	@BeforeClass
	public static void initTest() {
		dao = new BookDaoImpl();
	}
	
	@Test
	public void testReadBooksNotNull() {
		assertNotNull("The books were not read", dao.readBooks());
	}
	
	@Test
	public void testReadBooksNotEmpty() {
		assertNotNull("Impossible to chek: books list is null", dao.readBooks());
		assertTrue("The books list contatins zero books", dao.readBooks().size() > 0);
	}

}
