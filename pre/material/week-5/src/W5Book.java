public class W5Book {
    private String title;
    private W5Author author;
    private Double price;

    public W5Book(String title, W5Author author, Double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    };

    public String getTitle() {
        return this.title;
    };

    public W5Author getAuthor() {
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
