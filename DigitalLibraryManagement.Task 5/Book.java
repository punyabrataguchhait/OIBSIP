public class Book {
    int id;
    String title;
    String author;
    boolean issued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    public String toString() {
        return id + ": " + title + " by " + author + (issued ? " (Issued)" : " (Available)");
    }
}