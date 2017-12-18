package model;

/**
 * Created by Murathan on 14/12/2017.
 */
public class Book {
    private String name;
    private String author;
    private int quantity;


    public Book(String name, String author, int quantity) {
        if ((name.length() == 0) || (author.length() == 0)) {}
        else {
            this.name = name;
            this.author = author;
            this.quantity = quantity;
        }
    }

    public boolean equals(Object anObject) {
        if (anObject instanceof Book)
            return ((name.equals(((Book) anObject).name)) && (author.equals(((Book) anObject).author)));
        return false;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isNull() {
        if (this.name == null)
            return true;
        return false;
    }

    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
