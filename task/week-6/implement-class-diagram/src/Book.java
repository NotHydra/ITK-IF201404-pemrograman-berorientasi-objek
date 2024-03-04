import java.util.ArrayList;

public class Book {
    private int id;
    private ArrayList<Author> authors;
    private ArrayList<Publisher> publisher;
    private ArrayList<Genre> genres;
    private String isbn;
    private String dds;
    private String title;

    public Book(int id, ArrayList<Author> authors, ArrayList<Publisher> publisher, ArrayList<Genre> genres, String isbn, String dds, String title) {
        this.id = id;
        this.authors = authors;
        this.publisher = publisher;
        this.genres = genres;
        this.isbn = isbn;
        this.dds = dds;
        this.title = title;
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<Author> getAuthors() {
        return this.authors;
    }

    public ArrayList<Publisher> getPublishers() {
        return this.publisher;
    }

    public ArrayList<Genre> getGenres() {
        return this.genres;
    }

    public String getISBN() {
        return this.isbn;
    }

    public String getDDS() {
        return this.dds;
    }

    public String getTitle() {
        return this.title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public void setPublishers(ArrayList<Publisher> publisher) {
        this.publisher = publisher;
    }

    public void setGenres(ArrayList<Genre> genres) {
        this.genres = genres;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public void setDDS(String dds) {
        this.dds = dds;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public void addPublisher(Publisher publisher) {
        this.publisher.add(publisher);
    }

    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }

    public void removeAuthor(Author author) {
        this.authors.remove(author);
    }

    public void removePublisher(Publisher publisher) {
        this.publisher.remove(publisher);
    }

    public void removeGenre(Genre genre) {
        this.genres.remove(genre);
    }
    
    public String toString() {
        return "Book("
            + "id=" + this.id + ", " 
            + "authors=" + this.authors + ", "
            + "publisher=" + this.publisher + ", "
            + "genres=" + this.genres + ", "
            + "isbn=" + this.isbn + ", "
            + "dds=" + this.dds + ", "
            + "title=" + this.title
            + ")";
    }
}
