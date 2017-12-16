package controller;

import model.Book;
import model.Library;
import view.LibraryView;

/**
 * Created by Batzuhan on 14/12/2017.
 */
public class LibraryController {
    private Library library;
    private LibraryView view;

    public LibraryController(Library library) {
        this.library = library;
        this.view = new LibraryView(this);
    }

    public Library getLibrary() {
        return library;
    }

    public LibraryView getView() {
        return view;
    }

    public void addButtonClicked(String name,String author,int quantity) {
        Book book = new Book(name,author,quantity);
        library.addBook(book);
    }

    public void deleteButtonClicked() {
    }

    public void showInfoButtonClicked() {
    }

    public void listAllButtonClicked() {
    }
}
