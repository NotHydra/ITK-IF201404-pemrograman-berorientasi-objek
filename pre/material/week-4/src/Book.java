public class Book {
    private String title;
    private Author author;
    private Double price;

    public Book(String title, Author author, Double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    };

    public String getTitle() {
        return this.title;
    };

    public Author getAuthor() {
        return this.author;
    };

    public Double getPrice() {
        return this.price;
    };

    public void setPrice(Double newPrice) {
        this.price = newPrice;
    };

    public String toString() {
        return "Bookk title is " + this.title +
                ", author is " + this.author.getName() +
                " and price is " + this.price;
    }
}
