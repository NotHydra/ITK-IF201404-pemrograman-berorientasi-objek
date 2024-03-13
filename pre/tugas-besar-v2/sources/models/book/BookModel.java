package models.book;

public class BookModel {
    private final int id;
    private final String title;
    private final String description;

    public BookModel(String title, String description) {
        this.id = -1;
        this.title = title;
        this.description = description;
    }

    public BookModel(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        return "BookModel("
                + "id=" + this.id + ", "
                + "title=" + this.title + ", "
                + "description=" + this.description
                + ")";
    }
}
