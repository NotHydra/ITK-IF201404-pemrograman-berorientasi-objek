import java.util.ArrayList;

public class Catalogue {
    private ArrayList<Book> books;

    public Catalogue(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    public void changeBook(Book oldBook, Book newBook) {
        this.books.set(this.books.indexOf(oldBook), newBook);
    }

    public Book searchBookById(int id) {
        for (Book book : this.books) {
            if (book.getId() == id) {
                return book;
            }
        }
     
        return null;
    }

    public ArrayList<Book> searchBookByAuthor(Author author) {
        ArrayList<Book> books = new ArrayList<Book>();
        for (Book book : this.books) {
            if (book.getAuthors().contains(author)) {
                books.add(book);
            }
        }

        return books;
    }

    public ArrayList<Book> searchBookByPublisher(Publisher publisher) {
        ArrayList<Book> books = new ArrayList<Book>();
        for (Book book : this.books) {
            if (book.getPublishers().contains(publisher)) {
                books.add(book);
            }
        }

        return books;
    }

    public ArrayList<Book> searchBookByGenre(Genre genre) {
        ArrayList<Book> books = new ArrayList<Book>();
        for (Book book : this.books) {
            if (book.getGenres().contains(genre)) {
                books.add(book);
            }
        }

        return books;
    }

    public Book searchBookByISBN(String isbn) {
        for (Book book : this.books) {
            if (book.getISBN().equals(isbn)) {
                return book;
            }
        }

        return null;
    }
    
    public Book searchBookByDDS(String dds) {
        for (Book book : this.books) {
            if (book.getDDS().equals(dds)) {
                return book;
            }
        }

        return null;
    }

    public Book searchBookByTitle(String title) {
        for (Book book : this.books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }

        return null;
    }

    public String toString() {
        return "Catalogue("
            + "books=" + this.books
            + ")";
    }
}
