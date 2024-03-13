package models.book;

public interface BookServiceInterface {
    public BookModel[] find();

    public BookModel findId(int id);

    public void add(BookModel model);

    public void change(BookModel model);
}
