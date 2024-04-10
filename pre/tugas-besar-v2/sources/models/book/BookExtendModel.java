package models.book;


import models.genre.GenreModel;

public class BookExtendModel extends BookModel {
	private final GenreModel[] genres;

	public BookExtendModel(int id, String title, String description, GenreModel[] genres) {
		super(id, title, description);

		this.genres = genres;
	}

	public GenreModel[] getGenres() {
		return this.genres;
	}

	@Override
	public String toString() {
		return "BookExtendModel("
				+ "id=" + this.getId() + ", "
				+ "title=" + this.getTitle() + ", "
				+ "description=" + this.getDescription() + ", "
				+ "genres=" + this.genres
				+ ")";
	}
}
