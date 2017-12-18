package model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Murathan on 14/12/2017.
 */
public class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books=new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", books=" + books +
                '}';
    }

}
