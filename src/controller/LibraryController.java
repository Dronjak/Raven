package controller;

import model.Book;
import model.Library;
import view.LibraryView;
import model.Handler;

/**
 * Created by Batzuhan on 14/12/2017.
 */
public class LibraryController {
    private Library library;
    private LibraryView view;
    Handler handler = new Handler();

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
        handler.addBook(name,author,quantity,library);
    }

    public void deleteButtonClicked(String name,String author,int quantity) {
        handler.deleteBook(name,author,quantity,library);
    }

    public void showInfoButtonClicked(String name,String author) {
        //if(!name.equals("") getBooksByName() çağırmak için kullamılabilir.
    }

    public void listAllButtonClicked() {
    }
}
