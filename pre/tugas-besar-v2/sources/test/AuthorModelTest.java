package test;


import static org.junit.Assert.*;

import org.junit.Test;

import models.author.AuthorModel;

public class AuthorModelTest {

	@Test
	public void testConstructorWithNameAndIdBook() {
		String name = "Test Name";
		int idBook = 1;

		AuthorModel author = new AuthorModel(name, idBook);

		assertNotNull(author);
		assertEquals(name, author.getName());
		assertEquals(idBook, author.getIdBook());
	}

	@Test
	public void testConstructorWithIdNameAndIdBook() {
		int id = 1;
		String name = "Test Name";
		int idBook = 1;

		AuthorModel author = new AuthorModel(id, name, idBook);

		assertNotNull(author);
		assertEquals(id, author.getId());
		assertEquals(name, author.getName());
		assertEquals(idBook, author.getIdBook());
	}

	@Test
	public void testConstructorWithNullName() {
		try {
			new AuthorModel(null, 1);

			fail("Expected IllegalArgumentException");
		}
		catch (IllegalArgumentException e) {
			assertEquals("Name cannot be empty", e.getMessage());
		}
	}

	@Test
	public void testConstructorWithEmptyName() {
		try {
			new AuthorModel("", 1);

			fail("Expected IllegalArgumentException");
		}
		catch (IllegalArgumentException e) {
			assertEquals("Name cannot be empty", e.getMessage());
		}
	}

	@Test
	public void testConstructorWithIdBookEqualToZero() {
		try {
			new AuthorModel("Test Name", 0);

			fail("Expected IllegalArgumentException");
		}
		catch (IllegalArgumentException e) {
			assertEquals("IdBook cannot be less than or equal to 0", e.getMessage());
		}
	}

	@Test
	public void testConstructorWithIdBookLessThanZero() {
		try {
			new AuthorModel("Test Name", -1);

			fail("Expected IllegalArgumentException");
		}
		catch (IllegalArgumentException e) {
			assertEquals("IdBook cannot be less than or equal to 0", e.getMessage());
		}
	}

	@Test
	public void testToString() {
		AuthorModel author = new AuthorModel(1, "Test Name", 1);

		assertEquals("AuthorModel(id=1, name=Test Name, idBook=1)", author.toString());
	}
}