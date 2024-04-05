package models.author;


import models.book.BookModel;

public class AuthorExtendModel extends AuthorModel {
	private final BookModel book;

	public AuthorExtendModel(int id, String name, int idBook, BookModel book) {
		super(id, name, idBook);

		this.book = book;
	}

	public BookModel getBook() {
		return this.book;
	}

	@Override
	public String toString() {
		return "AuthorExtendModel("
				+ "id=" + this.getId() + ", "
				+ "name=" + this.getName() + ", "
				+ "idBook=" + this.getIdBook() + ", "
				+ "book=" + this.book
				+ ")";
	}
}
