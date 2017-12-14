package controller;

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

}
