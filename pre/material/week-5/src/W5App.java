public class W5App {
    public static void main(String[] args) throws Exception {
        W5Author author1 = new W5Author("Author 1", "Email 1", 'M');
        W5Book book1 = new W5Book("Book 1", author1, 59_000d);

        System.out.println(book1.toString());
    }
}
