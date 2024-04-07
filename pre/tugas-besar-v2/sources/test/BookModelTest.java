package test;


import static org.junit.Assert.*;

import org.junit.Test;

import models.book.BookModel;

public class BookModelTest {

	@Test
	public void testConstructorWithTitleAndDescription() {
		String title = "Test Title";
		String description = "Test Description";

		BookModel book = new BookModel(title, description);

		assertNotNull(book);
		assertEquals(title, book.getTitle());
		assertEquals(description, book.getDescription());
	}

	@Test
	public void testConstructorWithIdTitleAndDescription() {
		int id = 1;
		String title = "Test Title";
		String description = "Test Description";

		BookModel book = new BookModel(id, title, description);

		assertNotNull(book);
		assertEquals(id, book.getId());
		assertEquals(title, book.getTitle());
		assertEquals(description, book.getDescription());
	}

	@Test
	public void testConstructorWithNullTitle() {
		try {
			new BookModel(null, "Test Description");

			fail("Expected IllegalArgumentException");
		}
		catch (IllegalArgumentException e) {
			assertEquals("Title cannot be empty", e.getMessage());
		}
	}

	@Test
	public void testConstructorWithEmptyTitle() {
		try {
			new BookModel("", "Test Description");

			fail("Expected IllegalArgumentException");
		}
		catch (IllegalArgumentException e) {
			assertEquals("Title cannot be empty", e.getMessage());
		}
	}

	@Test
	public void testConstructorWithNullDescription() {
		try {
			new BookModel("Test Title", null);

			fail("Expected IllegalArgumentException");
		}
		catch (IllegalArgumentException e) {
			assertEquals("Description cannot be empty", e.getMessage());
		}
	}

	@Test
	public void testConstructorWithEmptyDescription() {
		try {
			new BookModel("Test Title", "");

			fail("Expected IllegalArgumentException");
		}
		catch (IllegalArgumentException e) {
			assertEquals("Description cannot be empty", e.getMessage());
		}
	}

	@Test
	public void testToString() {
		BookModel book = new BookModel(1, "Test Title", "Test Description");

		assertEquals("BookModel(id=1, title=Test Title, description=Test Description)", book.toString());
	}
}
