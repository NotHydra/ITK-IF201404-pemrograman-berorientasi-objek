public class App {
    public static void main(String[] args) throws Exception {
        Author author1 = new Author("Author 1", "Email 1", 'M');
        Book book1 = new Book("Book 1", author1, 59_000d);

        System.out.println(book1.toString());
    }
}
