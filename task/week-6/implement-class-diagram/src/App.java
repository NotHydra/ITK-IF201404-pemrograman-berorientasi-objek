import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Author author1 = new Author(1, "Aksawara");
        Author author2 = new Author(2, "Lisa");
        Author author3 = new Author(3, "Andi"); 

        System.out.println(author1);
        System.out.println(author2);
        System.out.println(author3);
        System.out.println();

        author1.setName("Lintas");
        System.out.println(author1.getName());
        System.out.println();

        Publisher publisher1 = new Publisher(1, "PT. Nie", "Jl. Karang Joang");
        Publisher publisher2 = new Publisher(2, "Dept. Cata", "Jl. Sungai Ampal");
        Publisher publisher3 = new Publisher(3, "PT. Fedian", "Jl. Batu Ampar");

        System.out.println(publisher1);
        System.out.println(publisher2);
        System.out.println(publisher3);
        System.out.println();

        publisher1.setName("PT. Nusantara");
        System.out.println(publisher1.getName());
        System.out.println();

        publisher1.setAddress("Jl. Kebon Jeruk");
        System.out.println(publisher1.getAddress());
        System.out.println();

        Genre genre1 = new Genre(1, "Komedi");
        Genre genre2 = new Genre(2, "Petualangan");
        Genre genre3 = new Genre(3, "Mistis");

        System.out.println(genre1);
        System.out.println(genre2);
        System.out.println(genre3);
        System.out.println();

        genre1.setName("Drama");
        System.out.println(genre1.getName());
        System.out.println();

        ArrayList<Author> authors1 = new ArrayList<Author>();
        authors1.add(author1);
        authors1.add(author3); 

        ArrayList<Publisher> publishers1 = new ArrayList<Publisher>();
        publishers1.add(publisher3);

        ArrayList<Genre> genres1 = new ArrayList<Genre>();
        genres1.add(genre1);
        genres1.add(genre2);

        ArrayList<Author> authors2 = new ArrayList<Author>();
        authors2.add(author2);

        ArrayList<Publisher> publishers2 = new ArrayList<Publisher>();
        publishers2.add(publisher2);
        publishers2.add(publisher3);

        ArrayList<Genre> genres2 = new ArrayList<Genre>();
        genres2.add(genre1);

        ArrayList<Author> authors3 = new ArrayList<Author>();
        authors3.add(author2);
        authors3.add(author3);

        ArrayList<Publisher> publishers3 = new ArrayList<Publisher>();
        publishers3.add(publisher1);

        ArrayList<Genre> genres3 = new ArrayList<Genre>();
        genres3.add(genre2);
        genres3.add(genre3);

        
        Book book1 = new Book(1, authors1, publishers1, genres1, "182-942-10-19", "AJD-01", "Petualangan Ojan Part 1");
        Book book2 = new Book(2, authors2, publishers2, genres2, "435-321-43-75", "FAS-01", "Puncak Komedi");
        Book book3 = new Book(3, authors3, publishers3, genres3, "857-029-24-53", "AJD-02", "Petualangan Ojan Part 2");

        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
        System.out.println();

        book1.setAuthors(authors2);
        System.out.println(book1.getAuthors());
        System.out.println();

        book1.setPublishers(publishers3);
        System.out.println(book1.getPublishers());
        System.out.println();

        book1.setGenres(genres3);
        System.out.println(book1.getGenres());
        System.out.println();

        book1.setISBN("123-456-78-90");
        System.out.println(book1.getISBN());
        System.out.println();

        book1.setDDS("FAS-02");
        System.out.println(book1.getDDS());
        System.out.println();

        book1.setTitle("Puncak Petualangan");
        System.out.println(book1.getTitle());
        System.out.println();

        book1.addAuthor(author3);
        System.out.println(book1.getAuthors());
        System.out.println();

        book1.addPublisher(publisher1);
        System.out.println(book1.getPublishers());
        System.out.println();

        book1.addGenre(genre3);
        System.out.println(book1.getGenres());
        System.out.println();

        book1.removeAuthor(author3);
        System.out.println(book1.getAuthors());
        System.out.println();

        book1.removePublisher(publisher1);
        System.out.println(book1.getPublishers());
        System.out.println();

        book1.removeGenre(genre3);
        System.out.println(book1.getGenres());
        System.out.println();

        ArrayList<Book> books1 = new ArrayList<Book>();
        books1.add(book1);
        books1.add(book2);
        books1.add(book3);

        ArrayList<Book> books2 = new ArrayList<Book>();
        books2.add(book2);
        books2.add(book3);

        Catalogue catalogue1 = new Catalogue(books1);
        System.out.println(catalogue1);

        catalogue1.setBooks(books2);
        System.out.println(catalogue1.getBooks());

        catalogue1.addBook(book1);
        System.out.println(catalogue1.getBooks());

        catalogue1.removeBook(book1);
        System.out.println(catalogue1.getBooks());

        catalogue1.changeBook(book2, book3);
        System.out.println(catalogue1.getBooks());

        System.out.println(catalogue1.searchBookById(2));
        System.out.println();

        System.out.println(catalogue1.searchBookByAuthor(author2));
        System.out.println();

        System.out.println(catalogue1.searchBookByPublisher(publisher3));
        System.out.println();

        System.out.println(catalogue1.searchBookByGenre(genre2));
        System.out.println();

        System.out.println(catalogue1.searchBookByISBN("857-029-24-53"));
        System.out.println();

        System.out.println(catalogue1.searchBookByDDS("AJD-02"));
        System.out.println();

        System.out.println(catalogue1.searchBookByTitle("Petualangan Ojan Part 2"));
        System.out.println();
    }
}
