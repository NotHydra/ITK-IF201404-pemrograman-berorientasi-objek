package models.book;

import models.base.BaseModel;

public class BookModel extends BaseModel implements BookModelInterface {
    private final String title;
    private final String description;

    public BookModel(String title, String description) {
        super(-1);

        this.title = title;
        this.description = description;
    }

    public BookModel(int id, String title, String description) {
        super(id);

        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return "BookModel("
                + "id=" + this.id + ", "
                + "title=" + this.title + ", "
                + "description=" + this.description
                + ")";
    }
}
