package by.itacademy.catalog.service.impl;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import by.itacademy.catalog.domain.vo.Catalog;
import by.itacademy.catalog.service.CatalogService;

public class CatalogServiceTest {
	
	public static CatalogService service;
	
	@BeforeClass
	public static void initTest() {
		
		service = new SimpleCatalogImpl();
		
	}

	@Test
	public void testCatalogNotNull() {
		assertNotNull("The Catalog was not created " + service.getCatalog());
	}
	
	@Test
	public void testCatalogField() {
		Catalog catalog = service.getCatalog();
		assertNotNull("Impossible: catalog is null " + catalog);
		assertNotNull("Catalog title is null ", catalog.getTitle());
		assertNotNull("Catalog books is empry ", catalog.getBooks());
	}

}
